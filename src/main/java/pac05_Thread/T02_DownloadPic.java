package pac05_Thread;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 * @author TFC
 * @date   2019年7月14日 下午6:52:58
 * @note   使用线程下载图片
 */
public class T02_DownloadPic extends Thread{
	private String url;
	private String name;
	public T02_DownloadPic(String url,String name) {
		this.url=url;
		this.name=name;
	}
	
	@Override
	public void run() {
		try {
			FileUtils.copyURLToFile(new URL(url),new File(name));
			System.out.println(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		T02_DownloadPic d1=new T02_DownloadPic("https://img.alicdn.com/tps/i4/TB1OKgFXvb2gK0jSZK9SuuEgFXa.jpg_q90_.webp", "p1.jpg");
		T02_DownloadPic d2=new T02_DownloadPic("https://img.alicdn.com/tps/i4/TB1OKgFXvb2gK0jSZK9SuuEgFXa.jpg_q90_.webp", "p2.jpg");
		T02_DownloadPic d3=new T02_DownloadPic("https://img.alicdn.com/tps/i4/TB1OKgFXvb2gK0jSZK9SuuEgFXa.jpg_q90_.webp", "p3.jpg");
		
		d1.start();
		d2.start();
		d3.start();
		
	}
}
