package pac07_Web;

import java.io.File;

/**
 * @author TFC
 * @date   2019年8月5日 上午10:13:17
 * @note   登录脚本
 */
public class Servlet01 implements T09_Servlet{
	private File html01=new File("src/pac5_Web/LoginBoxUI.html");
	
	@Override
	public void service(T06_Response_enc response, T08_Request_enc2 request) {
		response.create_html(html01);
	}
}
