package pac00_Test;

import javax.swing.*;

/**
 * @author Frank.Tang
 * @date 2023-06-28 13:58
 * @desc
 **/
public class BrotatoSaveFileBackupWindow {

    private JPanel panel1;
    private JButton btn_start;
    private JButton btn_pause;
    private JPanel lb_dynamic;

    public static void main(String[] args) {
        JFrame frame = new JFrame("BrotatoSaveFileBackupWindow");
        frame.setContentPane(new BrotatoSaveFileBackupWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
