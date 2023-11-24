package utils;

import java.io.Closeable;

/**
 * @author TFC
 * @date 2019年7月9日 下午7:44:39
 * @note IO流关闭工具
 */
public class IOStream {

    /**
     * @Desc 关闭IO流
     * @param streams:可变数组,可传入任意数量流或一个流数组
     * @return void
     */
    public static void close(Closeable... streams) {
        for (Closeable stream : streams) {
            try {
                if (null != stream) stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}