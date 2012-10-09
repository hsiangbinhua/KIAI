package insurance;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class frmLogin extends JFrame {
    BorderLayout borderLayout1 = new BorderLayout();

    public frmLogin() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    //��¼�ɹ��ķ���
    public void Login() {

    }

    private void jbInit() throws Exception {
        //���ڹر��¼�
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "�Ƿ����Ҫ�˳���",
                        "��ʾ",
                        JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    System.exit(0);
                }
            }
        });
        //��������
        lblForget.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frmforget fz = new frmforget();
                fz.setSize(500, 375);
                fz.setLocationRelativeTo(null);
                fz.setVisible(true);
                // lstQuestion.setVisible(true);
            }
        });

        //��¼��ȷ����ť
        btnshow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] df = pwdpass.getPassword();
                String sdr2 = new String(df);
                String strsql = "select * from User_form where Login_Name = '" +
                                txtname.getText() + "'and Login_Id='" + sdr2 +
                                "'";
                System.out.println(strsql);
                try {
                    ResultSet rs = main.stmt.executeQuery(strsql);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "��¼�ɹ�����ӭ���٣�");
                        frmCSH fc = new frmCSH();
                        fc.setUndecorated(true); //ȥ��������
                        fc.setSize(370, 538);
                        fc.setLocationRelativeTo(null);
                        fc.setVisible(true);
                        frmLogin.this.dispose();
                    } else {
                        JOptionPane.showConfirmDialog(null, "��¼ʧ��,�����û��������룡");
                        return;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //�˳���ť�¼�
        btnexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmLogin.this.dispose();
            }
        });

        ImageIcon img = new ImageIcon("image\\TAI.jpg");
        lblMain.setIcon(img);
        ImageIcon iga = new ImageIcon("image\\login.jpg");
        lblok.setIcon(iga);
        getContentPane().setLayout(null);
        lblMain.setBorder(BorderFactory.createLineBorder(Color.black));
        lblMain.setDisabledIcon(null);
        lblMain.setText("");
        lblMain.setBounds(new Rectangle( 0, 0, 650, 475));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("���մ�������Ϣ����ϵͳ V1.0");
        lblok.setText("");
        lblok.setBounds(new Rectangle(193, 173, 262, 208));
        lblname.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblname.setForeground(Color.cyan);
        lblname.setText("�û�����");
        lblname.setBounds(new Rectangle(209, 208, 83, 28));
        lblpwd.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblpwd.setForeground(Color.cyan);
        lblpwd.setText("��    �룺");
        lblpwd.setBounds(new Rectangle(210, 263, 81, 28));
        txtname.setText("");
        txtname.setBounds(new Rectangle(287, 208, 132, 31));
        btnshow.setBounds(new Rectangle(233, 304, 72, 27));
        btnshow.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        btnshow.setForeground(Color.red);
        btnshow.setText("ȷ��");
        btnexit.setBounds(new Rectangle(334, 306, 74, 27));
        btnexit.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        btnexit.setForeground(Color.red);
        btnexit.setText("ȡ��");
        lblNA.setFont(new java.awt.Font("������κ", Font.PLAIN, 13));
        lblNA.setForeground(Color.white);
        lblNA.setText("�û���¼ User login");
        lblNA.setBounds(new Rectangle(199, 176, 184, 31));
        pwdpass.setText("");
        pwdpass.setBounds(new Rectangle(287, 262, 132, 33));
        pwdpass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                pwdpass_keyPressed(e);
            }
        });

        lblForget.setToolTipText("");
        lblForget.setText("");
        lblForget.setBounds(new Rectangle(519, 243, 114, 41));
        ImageIcon imgforget = new ImageIcon("image\\fogetPw.gif");
        lblForget.setIcon(imgforget);
        lblForget.setForeground(Color.red);
        this.getContentPane().add(lblForget);
        this.getContentPane().add(lblname);
        this.getContentPane().add(lblpwd);
        this.getContentPane().add(txtname);
        this.getContentPane().add(pwdpass);
        this.getContentPane().add(btnshow);
        this.getContentPane().add(btnexit);
        this.getContentPane().add(lblNA);
        this.getContentPane().add(lblok);
        this.getContentPane().add(lblMain);
    }
 public static String Login_name;
    Statement stmt;
    Connection con;
    ResultSet rs;
    JLabel lblMain = new JLabel();
    JLabel lblok = new JLabel();
    JLabel lblname = new JLabel();
    JLabel lblpwd = new JLabel();
    JTextField txtname = new JTextField();
    JTextField txtpwd = new JTextField();
    JButton btnshow = new JButton();
    JButton btnexit = new JButton();
    JLabel lblNA = new JLabel();
    JPasswordField pwdpass = new JPasswordField();
    JLabel lblForget = new JLabel();

    //�س���   ����һ���ش�����  ������һ�������ж��������޷�ִ�е�¼
    public void pwdpass_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
//            char[] df = pwdpass.getPassword();
//            String sdr2 = new String(df);
//            String strsql = "select * from User_form where Login_Name = '" +
//                            txtname.getText() + "'and Login_Id='" + sdr2 +
//                            "'";
//            System.out.println(strsql);
//            try {
//                ResultSet rs = main.stmt.executeQuery(strsql);
//            } catch (SQLException ex1) {
//            }
//            try {
//
//                if (rs.next()) {
//                    Login(); //����Login����
//                } else {
//                    JOptionPane.showConfirmDialog(null, "��¼ʧ��,�����û��������룡");
//                    return;
//                }
//            } catch (HeadlessException ex) {
//            } catch (SQLException ex) {
//            }
            Login();
        }
    }
}
