package pac07_Web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

/**
 * @author TFC
 * @date 2019��8��4�� ����7:36:12
 * @note ��װrequest(�汾2)(��װ���������Map)
 *
 */
public class T08_Request_enc2 {
    private String requestInfo;
    private String method;        //����ʽ
    private String src;            //����src
    private String parameter;    //�������
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
        //1.��ȡmethod
        method = requestInfo.substring(
                0, requestInfo.indexOf("/"))/*.toLowerCase()*/.trim();
        //2.��ȡsrc
        //(a)��ȡ/��λ��
        int start = requestInfo.indexOf("/") + 1;
        //(b)��ȡhttp/��λ��
        int end = requestInfo.indexOf("HTTP/");
        //(c)�ָ��ַ���
        src = requestInfo.substring(start, end);
        //(d)��ȡ?��λ��
        int queMark = requestInfo.indexOf("?");
        //(e)�ָ��ʺ����ҵ��ַ�
        if (queMark >= 0/*�����������*/) {
            String[] urlArray = src.split("\\?");
            src = urlArray[0];
            parameter = urlArray[1];
        }
        //3.��ȡ�������
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
        //System.out.println(method+"����>"+src+"����>"+parameter+"\n");
        convertParToMap();
    }

    private void convertParToMap() {
        //����: var=1&var=2&uname=tfc&pwd=123456&other=

        //1.�ָ�parameter�ɵ������� (����&)
        String[] singlePar = parameter.split("&");
        for (String sp : singlePar) {
            //2.�ָ�K,V (����=)
            String kv[] = sp.split("=");
            kv = Arrays.copyOf(kv, 2);
            String key = kv[0];
            String val = kv[1]/*==null ? null:handleChinese(kv[1])*/;
            //K,V����Map (���������ͬ��key,����ArrayList�ں���׷��ֵ)
            if (!parMap.containsKey(key)) {
                parMap.put(key, new ArrayList<String>());
            }
            parMap.get(key).add(val);
        }
    }

    //����val�������ĵ����
    public String handleChinese(String val) {
        try {
            return URLDecoder.decode(val, "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //��ȡ��Ӧkey������ֵ
    public String[] getparMapVal(String key) {
        String[] nullArr = {"no such key!"};
        List<String> vals = parMap.get(key);
        if (null == vals || vals.size() <= 0)
            return nullArr;
        //new String[0]��ģ������,ָ���������������,0Ϊ�˽�ʡ�ռ䣬��ֻ��˵���˷��ص�����
		return vals.toArray(new String[0]);
    }

    //��ȡ��Ӧkey�ĵ�һ��ֵ
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
