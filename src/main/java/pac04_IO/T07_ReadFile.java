package pac04_IO;

import utils.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TFC
 * @date 2019年7月5日 下午3:53:34
 * @note io, 文本读取标准样例
 *
 * 步骤：
 * 1.创建源
 * 2.选择流
 * 3.操作源
 * 4.释放资源
 */
public class T07_ReadFile {

    public static void main(String[] args) {
        File f1 = new File("test1");
        //外部初始化
        InputStream in = null;
        try {

            in = new FileInputStream(f1);
            int tempData;
            //读到为空返回-1
            //方法1
            while ((tempData = in.read()) != -1) {
                System.out.print((char) tempData);
            }
            //方法2
			/*while(true) {
				tempData=in.read();
				if(tempData==-1) { break; }
				System.out.print((char)tempData);
			}*/

        } catch (IOException e) {
            e.printStackTrace();
        }//finally避免空指针异常
        finally {
            IOStream.close(in);
        }
    }

}
