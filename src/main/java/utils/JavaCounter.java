package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-07 16:15
 * @desc:
 **/
public class JavaCounter {
    private static String PATH
            = "F:\\1.WorkSpaces\\IDEA_2019.2.4\\HRMS_SpringbootDemo\\src\\main\\java";
    private static int Number = 0;
    private static List<String> filePathList = new ArrayList<>();

    public static void main(String[] args) {
        getCodeFilePath(PATH);

        filePathList.forEach(file -> StatisticsCodeNumber(new File(file)));

        System.out.println(Number);

    }

    private static void StatisticsCodeNumber(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while (br.readLine() != null) {
                Number++;
            }
            fis.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getCodeFilePath(String path) {
        File file = new File(path);
        File[] filesArr = file.listFiles();
        if (filesArr != null) {
            for (File item : filesArr) {
                if (item.isDirectory()) {
                    getCodeFilePath(item.getPath());
                } else {
                    if (item.getPath().substring(item.getPath().lastIndexOf(".")).equals(".java"))
                        filePathList.add(item.getPath());
                }
            }
        }
    }
}

