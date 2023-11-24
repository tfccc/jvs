package pac07_Web;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author TFC
 * @date   2019年8月2日 下午5:46:58
 * @note   封装response(封装响应信息)(用servlet接口在外部引入html文本)
 */
public class T06_Response_enc {
	private BufferedWriter bw;
	private DataInputStream in;
	private StringBuilder rInfo;		//返回协议
	private StringBuilder content;		//返回正文(html等)
	private int len;
	private final String BLANK=" ";
	private final String CRLF="\r\n";

	public T06_Response_enc() {
		content=new StringBuilder();
		rInfo  =new StringBuilder();
	}
	public T06_Response_enc(Socket client) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(
								client.getOutputStream()));
		} catch (IOException e) { e.printStackTrace(); rInfo=null;}
	}
	public T06_Response_enc(OutputStream os) {
		this();
		bw=new BufferedWriter(
				new OutputStreamWriter(os));
	}
	
	public void pushToBrowser(int code) throws IOException {
		if(rInfo==null)
			code=505;
		create_rInfo(code);
		bw.append(rInfo);
		bw.append(content);
		bw.flush();
	}
	private void create_rInfo(int code) {
		//1.响应行(HTTP/1.1 200 OK)
		
		rInfo.append("HTTP/1.1").append(BLANK)
		.append(200).append(BLANK);
		switch(code) {
			case 200:
				rInfo.append("OK");
			case 404:
				rInfo.append("NOT FOUND");
			case 505:
				rInfo.append("SERVER ERROR");
		}
		rInfo.append(CRLF);
		//2.响应头
		rInfo.append("Date:").append(new Date()).append(CRLF);
		rInfo.append("Server:").append("Tfc Server/0.0.1;charset=gbk").append(CRLF);
		rInfo.append("Content-type:text/html").append(CRLF);
		rInfo.append("Content-length:").append(len).append(CRLF);
		rInfo.append(CRLF);
	}
	void create_html(File file) {
		try {
			len=(int)file.length();
			in=new DataInputStream(new FileInputStream(file));
			byte[] datas =new byte[len];
			in.readFully(datas);
			content.append(new String(datas,0,len));
			
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
