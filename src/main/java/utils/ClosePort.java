package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TFC
 * @date 2019��8��5�� ����12:06:26
 * @note �رն˿�
 */
public class ClosePort {
    private Set<Integer> ports;

    public static void main(String[] args) throws Exception {
        run();
    }

    /**
     * @Desc �������
     * @return void
     */
    public static void run() throws InterruptedException {
        System.out.println("������Ҫɱ����windows���̵Ķ˿ںţ�����ж�������Զ������");
        System.out.println("Please input kill port");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        String[] split = input.split(",");
        Set<Integer> ports = new HashSet<>();
        for (String spid : split) {
            try {
                int pid = Integer.parseInt(spid);
                ports.add(pid);
            } catch (Exception e) {
                System.out.println("����Ķ˿ںţ�������һ�����߶���˿ڣ���Ӣ�Ķ��Ÿ���");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        }

        ClosePort kill = new ClosePort();
        kill.ports = ports;
        System.out.println("need kill " + ports.size() + " num");
        for (Integer pid : ports) {
            kill.start(pid);
        }
        System.out.println("������ϣ����򼴽��˳�");
        System.out.println("SUCCESS");
        Thread.sleep(1000);
        System.exit(0);
    }

    private void start(int port) {
        Runtime runtime = Runtime.getRuntime();
        try {
            //���ҽ��̺�
            Process p = runtime.exec("cmd /c netstat -ano | findstr \"" + port + "\"");
            InputStream inputStream = p.getInputStream();
            List<String> read = read(inputStream);
            if (read.size() == 0) {
                System.out.println("�Ҳ����ö˿ڵĽ���");
                try {
                    Thread.sleep(6000);
                    System.exit(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (String string : read) {
                    System.out.println(string);
                }
                System.out.println("�ҵ�" + read.size() + "�����̣�����׼������");
                kill(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��֤�����Ƿ�Ϊָ���Ķ˿ڣ���Ϊ findstr ������ǰѰ������ҳ�����
     * �������80�˿ڣ����ǻ��8099���ҳ���
     */
    private boolean validPort(String str) {
        Pattern pattern = Pattern.compile("^ *[a-zA-Z]+ +\\S+");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        String find = matcher.group();
        int spStart = find.lastIndexOf(":");
        find = find.substring(spStart + 1);

        int port;
        try {
            port = Integer.parseInt(find);
        } catch (NumberFormatException e) {
            System.out.println("���ҵ�����Ķ˿�:" + find);
            return false;
        }
        return this.ports.contains(port);
    }

    /**
     * ����Ϊһ��Set��ȥ���ظ���pidֵ
     */
    private void kill(List<String> data) {
        Set<Integer> pids = new HashSet<>();
        for (String line : data) {
            int offset = line.lastIndexOf(" ");
            String spId = line.substring(offset);
            spId = spId.replaceAll(" ", "");
            int pid = 0;
            try {
                pid = Integer.parseInt(spId);
            } catch (NumberFormatException e) {
                System.out.println("��ȡ�Ľ��̺Ŵ���:" + spId);
            }
            pids.add(pid);
        }
        killWithPid(pids);
    }

    /**
     * һ����ɱ�����еĶ˿�
     */
    private void killWithPid(Set<Integer> pIds) {
        for (Integer pid : pIds) {
            try {
                Process process = Runtime.getRuntime().exec("taskkill /F /pid " + pid + "");
                InputStream inputStream = process.getInputStream();
                String txt = readTxt(inputStream, "GBK");
                System.out.println(txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> read(InputStream in) throws IOException {
        List<String> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            boolean validPort = validPort(line);
            if (validPort) {
                data.add(line);
            }
        }
        reader.close();
        return data;
    }

    private String readTxt(InputStream in, String charset) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }
}

