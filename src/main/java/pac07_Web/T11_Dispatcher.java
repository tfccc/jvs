package pac07_Web;

import java.io.IOException;
import java.net.Socket;

/**
 * @author TFC
 * @date   2019年8月5日 上午11:25:45
 * @note   高效分发器(多线程)
 */
public class T11_Dispatcher implements Runnable{
	private Socket client;
	private T08_Request_enc2 request;
	private T06_Response_enc response;
	
	public T11_Dispatcher(Socket client) {
		this.client=client;
		try {
			request =new T08_Request_enc2(client);
			response=new T06_Response_enc(client);
		} catch (IOException e) {
			e.printStackTrace();	
			release();
		}
	}
	//释放资源
	private void release() {
		try {client.close();}
		catch (IOException e) {e.printStackTrace();}
	}
	@Override
	public void run() {
		T09_Servlet servlet=new Servlet01();
		servlet.service(response, request);
		try {
			response.pushToBrowser(200);
		} catch (IOException e) {
			e.printStackTrace();
		}
		release();
	}
}
