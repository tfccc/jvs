package pac04_IO;

import java.io.File;
import java.io.IOException;

/**
 * @author TFC
 * @date 2019年7月4日 上午10:00:13
 * @note 文件夹/文件创建、文件目录遍历
 */
public class T03_CrateFile {
    public static void main(String[] args) throws IOException {
        //创建text文档
        File f = new File("C:/Users/82818/Desktop/Java/IO_test/"
                + "test.txt");
        f.createNewFile();//f.delete();


        /* 创建文件夹(目录)
         * 1.mkdirs()上级目录可不存在(推荐使用)
         * 2.mkdir() 上级目录必须存在才能创建
         */
        File f2 = new File("C:/Users/82818/Desktop/Java/IO_test/dir1");
        f2.mkdirs();


        /* 列出下一级
         * 1.list()     列出下一级所有名称
         * 2.listFiles()列出下一级所有对象
         */
        // 1.list方法
        File f3 = new File("C:/Users/82818/Desktop/Java/IO_test");
        String[] filenames = f3.list();

        for (String s : filenames) {
            System.out.println(s);
        }
        System.out.println();
        // 2.listFiles方法
        File[] fc = f3.listFiles();
        for (File s : fc) {
            System.out.println(s);
        }
    }
}
