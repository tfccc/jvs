package pac07_Web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date 2019年8月2日 上午11:16:43
 * @note 手写web服务器02(进阶版)
 *
 * (获得请求参协议+返回响应协议+分解协议/参数)
 *
 */
public class T05_WebServer02 {
    private ServerSocket serverSocket;
    private Socket client;
    private T06_Response_enc res;
    private T08_Request_enc2 req;
    //private File html=new File("src/pac5_Web/index.html");

    public static void main(String[] args) throws IOException {
        T05_WebServer02 server = new T05_WebServer02();
        server.start();
        server.stop();
    }

    //1.启动服务
    public void start() throws IOException {
        serverSocket = new ServerSocket(8888);
        receive();
    }

    //2.接收连接处理
    public void receive() {
        try {
            client = serverSocket.accept();
            System.out.println("建立了一个连接");
            //1.得到请求协议
            //getRequset(client);
            //2.得到请求协议(使用封装的方法)
            req = new T08_Request_enc2(client);
            System.out.println(req.getSingleParMapVal("uname"));
            System.out.println(req.getRequestInfo());
            //1.返回响应协议,及请求内容
            //returnResponse(client);
            //2.返回响应协议,及请求内容(使用封装的方法)
            res = new T06_Response_enc(client);
            res.pushToBrowser(200);
            System.out.print("end......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3.关闭服务
    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
/*	public String getHtml(File html) {
		String text = "";
		try {
			DataInputStream in=new DataInputStream(
					new FileInputStream(html));
			byte buffer[]=new byte[1024*10];
			int len=-1;
			while((len=in.read(buffer))!=-1){
				String str=new String(buffer,0,len);
				text+=str;
			}
			in.close();
		} catch ( IOException e) { e.printStackTrace(); }
		return text;
	}
	public void returnResponse(Socket client) {
		StringBuilder response=new StringBuilder();
		String blank=" ";	String CRLF="\r\n";
		//1.响应行：HTTP/1.1 200 OK
		response.append("HTTP/1.1").append(blank)
		.append(200).append(blank)
		.append("OK").append(CRLF);
		//2.响应头：Date/Server/Content-type/Content-length
		response.append("Date:").append(new Date()).append(CRLF);
		response.append("Server:").append("TfcServer/0.0.1;charset=UTF-8").append(CRLF);
		response.append("Content-type:text/html").append(CRLF);
		response.append("Content-length:").append(html.length()).append(CRLF);
		response.append(CRLF);
		//3.正文
		response.append(getHtml(html));
		try {
			BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			System.out.println("已发送请求\n");
		} catch (IOException e) { e.printStackTrace(); }
	}
	public void getRequset(Socket client) {
		InputStream is;
		try {
			is = client.getInputStream();
			byte []datas=new byte[1024*10];
			int len=is.read(datas);
			if(len>0)
				System.out.println("\n请求协议内容：\n"+new String(datas,0,len));
		} catch (IOException e) { e.printStackTrace(); }
		
	}*/
}
