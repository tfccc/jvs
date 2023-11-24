package pac07_Web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date 2019��8��2�� ����11:16:43
 * @note ��дweb������02(���װ�)
 *
 * (��������Э��+������ӦЭ��+�ֽ�Э��/����)
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

    //1.��������
    public void start() throws IOException {
        serverSocket = new ServerSocket(8888);
        receive();
    }

    //2.�������Ӵ���
    public void receive() {
        try {
            client = serverSocket.accept();
            System.out.println("������һ������");
            //1.�õ�����Э��
            //getRequset(client);
            //2.�õ�����Э��(ʹ�÷�װ�ķ���)
            req = new T08_Request_enc2(client);
            System.out.println(req.getSingleParMapVal("uname"));
            System.out.println(req.getRequestInfo());
            //1.������ӦЭ��,����������
            //returnResponse(client);
            //2.������ӦЭ��,����������(ʹ�÷�װ�ķ���)
            res = new T06_Response_enc(client);
            res.pushToBrowser(200);
            System.out.print("end......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3.�رշ���
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
		//1.��Ӧ�У�HTTP/1.1 200 OK
		response.append("HTTP/1.1").append(blank)
		.append(200).append(blank)
		.append("OK").append(CRLF);
		//2.��Ӧͷ��Date/Server/Content-type/Content-length
		response.append("Date:").append(new Date()).append(CRLF);
		response.append("Server:").append("TfcServer/0.0.1;charset=UTF-8").append(CRLF);
		response.append("Content-type:text/html").append(CRLF);
		response.append("Content-length:").append(html.length()).append(CRLF);
		response.append(CRLF);
		//3.����
		response.append(getHtml(html));
		try {
			BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			System.out.println("�ѷ�������\n");
		} catch (IOException e) { e.printStackTrace(); }
	}
	public void getRequset(Socket client) {
		InputStream is;
		try {
			is = client.getInputStream();
			byte []datas=new byte[1024*10];
			int len=is.read(datas);
			if(len>0)
				System.out.println("\n����Э�����ݣ�\n"+new String(datas,0,len));
		} catch (IOException e) { e.printStackTrace(); }
		
	}*/
}
