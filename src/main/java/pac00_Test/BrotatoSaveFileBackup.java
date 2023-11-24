package pac00_Test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-06-28 02:23
 * @desc
 **/
@SuppressWarnings("all")
public class BrotatoSaveFileBackup {

    public static final String YEAR_MONTH_DAY_HOUR1 = "yyyy-MM-dd_HH-mm-ss";
    public static final String YEAR_MONTH_DAY_HOUR2 = "yyyy-MM-dd HH:mm:ss";

    private static final String saveFilePath = "C:/Users/82518/AppData/Roaming/Brotato/76561198429033993";
    private static final String destFilePath = "D:/GameShortCut/BrotatoSave/";

    private static File logFile = new File("D:/GameShortCut/BrotatoSave/copyLog.txt");


    public static void main(String[] args) throws Exception {

        while (true) {
            createLogFile();
            copyDir();
            TimeUnit.SECONDS.sleep(120);
        }

    }

    /**
     * 拷贝存档 C:/Users/82518/AppData/Roaming/Brotato/76561198429033993
     * @author Frank.Tang
     */
    public static void copyDir() {
        Date crtDate = new Date();

        String destDirDateStr = formatDirDate(crtDate);
        String logDateStr = formatDate(crtDate);

        String dirFullPath = saveFilePath;
        File saveFile = new File(dirFullPath);

        try {
            String destDirFullPath = destFilePath + destDirDateStr;
            File destFile = new File(destDirFullPath);

            FileUtils.copyDirectory(saveFile, destFile);

            String successLog = "备份成功, 时间: " + logDateStr + "\n";
            FileUtils.writeStringToFile(logFile, successLog, StandardCharsets.UTF_8, true);
        } catch (Exception e) {
            e.printStackTrace();
            String failedLog = "备份失败, 时间: " + logDateStr + "\n" + e.getMessage() + "\n";
            try {
                FileUtils.writeStringToFile(logFile, failedLog, StandardCharsets.UTF_8, true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * 创建日志文件
     * @author Frank.Tang
     */
    public static void createLogFile() {
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static String formatDirDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR1);
        return format.format(date);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR2);
        return format.format(date);
    }

}
