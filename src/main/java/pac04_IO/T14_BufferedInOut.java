package pac04_IO;

/**
 * @author TFC
 * @date   2019��7��10�� ����10:44:51
 * @note   �ֽڻ�����(װ����,����IO����)
 */
public class T14_BufferedInOut {

	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		
		T24_FileCopy3_BufferedByte.copy("55.jpg", "11.jpg");
		
		long end  =System.currentTimeMillis();
		System.out.println(end-start);
	}

}
