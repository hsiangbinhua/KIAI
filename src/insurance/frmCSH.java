package insurance;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class frmCSH extends JFrame {
    ImageIcon age = new ImageIcon("image\\Init.jpg");
    JProgressBar pb1 = new JProgressBar();
    public frmCSH() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setResizable(false);
        setSize(370, 538);
        getContentPane().setLayout(null);
        lblok.setText("");
        lblok.setBounds(new Rectangle(0, 0, 370, 538));
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("ϵͳ�����У����Ժ򡣡���");
        pb1.setStringPainted(true); //��ʾ�ٷֱ�
        pb1.setMaximum(2000);
        this.getContentPane().add(pb1);
        this.getContentPane().add(lblok);
        pb1.setBounds(new Rectangle(92, 461, 247, 26));
        tt = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count += 10;
                pb1.setValue(count);
                if (count >= 2000) {
                    tt.stop();
                    frmMain ft = new frmMain();
                    ft.setUndecorated(true); //ȥ��������
                    ft.setSize(800, 600);
                    ft.setLocationRelativeTo(null);
                    ft.show();
                    frmCSH.this.dispose();
                }
            }
        });
        tt.start();
    }

    Timer tt;
    int count = 0;
    JLabel lblok = new JLabel(age);
}
