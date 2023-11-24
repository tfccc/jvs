package pac07_Web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

/**
 * @author TFC
 * @date 2019年8月4日 下午7:36:12
 * @note 封装request(版本2)(封装请求参数到Map)
 *
 */
public class T08_Request_enc2 {
    private String requestInfo;
    private String method;        //请求方式
    private String src;            //请求src
    private String parameter;    //请求参数
    private Map<String, List<String>> parMap;

    private T08_Request_enc2(InputStream in) throws IOException {
        parMap = new HashMap<>();
        byte[] datas = new byte[1024 * 100];
        int len = in.read(datas);
        if (len > 0)
            requestInfo = new String(datas, 0, len);
        parseRequest();
    }

    T08_Request_enc2(Socket client) throws IOException {
        this(client.getInputStream());
    }

    private void parseRequest() {
        //1.获取method
        method = requestInfo.substring(
                0, requestInfo.indexOf("/"))/*.toLowerCase()*/.trim();
        //2.获取src
        //(a)获取/的位置
        int start = requestInfo.indexOf("/") + 1;
        //(b)获取http/的位置
        int end = requestInfo.indexOf("HTTP/");
        //(c)分割字符串
        src = requestInfo.substring(start, end);
        //(d)获取?的位置
        int queMark = requestInfo.indexOf("?");
        //(e)分割问号左右的字符
        if (queMark >= 0/*存在请求参数*/) {
            String[] urlArray = src.split("\\?");
            src = urlArray[0];
            parameter = urlArray[1];
        }
        //3.获取请求参数
        if (method.equals("POST")) {
            String str = requestInfo.substring(
                    requestInfo.lastIndexOf("\r\n")).trim();
            if (null == parameter) {
                parameter = str;
            } else {
                parameter += "&" + str;
            }
        }
        parameter = (null == parameter ? "" : parameter);
        //System.out.println(method+"——>"+src+"——>"+parameter+"\n");
        convertParToMap();
    }

    private void convertParToMap() {
        //例如: var=1&var=2&uname=tfc&pwd=123456&other=

        //1.分割parameter成单个参数 (依据&)
        String[] singlePar = parameter.split("&");
        for (String sp : singlePar) {
            //2.分割K,V (依据=)
            String kv[] = sp.split("=");
            kv = Arrays.copyOf(kv, 2);
            String key = kv[0];
            String val = kv[1]/*==null ? null:handleChinese(kv[1])*/;
            //K,V放入Map (如果遇到相同的key,则用ArrayList在后面追加值)
            if (!parMap.containsKey(key)) {
                parMap.put(key, new ArrayList<String>());
            }
            parMap.get(key).add(val);
        }
    }

    //处理val中有中文的情况
    public String handleChinese(String val) {
        try {
            return URLDecoder.decode(val, "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取对应key的所有值
    public String[] getparMapVal(String key) {
        String[] nullArr = {"no such key!"};
        List<String> vals = parMap.get(key);
        if (null == vals || vals.size() <= 0)
            return nullArr;
        //new String[0]起模板作用,指定返回数组的类型,0为了节省空间，它只是说明了返回的类型
		return vals.toArray(new String[0]);
    }

    //获取对应key的第一个值
    public String getSingleParMapVal(String key) {
        return getparMapVal(key)[0];
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public String getMethod() {
        return method;
    }

    public String getSrc() {
        return src;
    }

    public String getParameter() {
        return parameter;
    }
}
