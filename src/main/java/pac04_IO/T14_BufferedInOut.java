package pac04_IO;

/**
 * @author TFC
 * @date   2019年7月10日 上午10:44:51
 * @note   字节缓冲流(装饰类,提升IO性能)
 */
public class T14_BufferedInOut {

	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		
		T24_FileCopy3_BufferedByte.copy("55.jpg", "11.jpg");
		
		long end  =System.currentTimeMillis();
		System.out.println(end-start);
	}

}
