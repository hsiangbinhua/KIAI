package insurance;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class frmforget extends JFrame {
    JLabel lblsz = new JLabel();
    JLabel lblname = new JLabel();
    JLabel lblm1 = new JLabel();
    JLabel lblm2 = new JLabel();
    JTextField txtAnswer = new JTextField();
    JTextField txtname = new JTextField();
    JButton btnSure = new JButton();
    JButton btnCancel = new JButton();
    JTextField txtQuestion = new JTextField();
    JList lstQuestion = new JList();
    JLabel lblDown = new JLabel();
    DefaultListModel dlm = new DefaultListModel();
    JLabel lblmima = new JLabel();
    public frmforget() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        //ȷ��������û������ܱ�����
        btnSure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtname.getText().length() == 0 ||
                    txtQuestion.getText().length() == 0 ||
                    txtAnswer.getText().length() == 0) {
                    JOptionPane.showConfirmDialog(null, "������������Ϣ��",
                                                  "�û�������ʾ", 1);
                    return;
                }

                String strname =
                        "select Login_name from User_form where Login_Name='" +
                        txtname.getText() + "'";
                try {
                    ResultSet rsname = main.stmt.executeQuery(strname);
                    System.out.println(strname);
                    if (rsname.next() == false) {
                        JOptionPane.showConfirmDialog(null, "�����ڴ��û�����������",
                                "��ȫϵͳ��ʾ", 2);
                        return;
                    }
                } catch (Exception ex1) {
                    ex1.printStackTrace();
                }

                String str = "select * from User_form where Login_name = '" +
                             txtname.getText() + "' and Question='" +
                             txtQuestion.getText() + "' and Answer='" +
                             txtAnswer.getText() + "'";
                try {
                    System.out.println(str);
                    ResultSet re = main.stmt.executeQuery(str);
                    if (re.next()) {
                        lblmima.setText("��ϲ�㣡����û���Ϊ��" +
                                        txtname.getText() + ",��������ǣ�" +
                                        re.getString(2));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                lblDown.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        lstQuestion.setVisible(true);
                    }
                });
                lstQuestion.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        txtQuestion.setText(lstQuestion.getSelectedValue() + "");
                        lstQuestion.setVisible(false);
                    }
                });
                lstQuestion.addMouseListener(new MouseAdapter() {
                    public void mouseExited(MouseEvent e) {
                        lstQuestion.setVisible(false);
                    }
                });
            }
        });

        //������ť�¼�
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtname.setText("");
                txtQuestion.setText("");
                txtAnswer.setText("");
            }
        });

        lblDown.setVisible(true);

        txtname.setOpaque(false);

        txtname.setForeground(Color.white);

        txtQuestion.setOpaque(false);

        txtQuestion.setForeground(Color.white);

        txtAnswer.setOpaque(false);

        txtAnswer.setForeground(Color.white);

        ImageIcon img = new ImageIcon("image\\Skin_Move.GIF");
        lblDown.setIcon(img);

        lstQuestion.setVisible(false);

        dlm.addElement("����˭��");

        dlm.addElement("�������ĸ����У�");

        dlm.addElement("��ĵ�ַ�ǣ�");

        dlm.addElement("�������ĸ����У�");

        dlm.addElement("���־Ͷ����ĸ��༶��");

        lstQuestion.setModel(dlm);

        ImageIcon sz = new ImageIcon("image\\����.jpg");
        lblsz.setIcon(sz);

        getContentPane().setLayout(null);

        lblsz.setBounds(new Rectangle(0, 0, 500, 375));

        lblm2.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));

        lblm2.setForeground(Color.red);

        lblm2.setText("�ܱ��𰸣�");

        lblm2.setBounds(new Rectangle(125, 195, 100, 38));

        lblm1.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));

        lblm1.setForeground(Color.red);

        lblm1.setText("�ܱ����⣺");

        lblm1.setBounds(new Rectangle(126, 154, 103, 37));

        lblname.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));

        lblname.setForeground(Color.red);

        txtAnswer.setBounds(new Rectangle(227, 201, 163, 27));

        txtname.setBounds(new Rectangle(228, 121, 118, 26));

        btnCancel.setFont(new java.awt.Font("������κ", Font.PLAIN, 25));

        btnCancel.setForeground(Color.magenta);

        btnSure.setFont(new java.awt.Font("������κ", Font.PLAIN, 25));

        btnSure.setForeground(Color.magenta);

        txtQuestion.setBounds(new Rectangle(228, 161, 163, 23));

        lstQuestion.setBounds(new Rectangle(224, 183, 166, 129));

        lblDown.setBounds(new Rectangle(367, 162, 23, 22));

        btnCancel.setBounds(new Rectangle(275, 263, 85, 35));

        btnCancel.setText("����");

        btnSure.setBounds(new Rectangle(155, 264, 84, 35));

        btnSure.setText("ȷ��");

        lblmima.setFont(new java.awt.Font("������κ", Font.PLAIN, 18));

        lblmima.setForeground(Color.magenta);

        lblmima.setText("");

        lblmima.setBounds(new Rectangle(18, 65, 452, 39));

        this.setResizable(false);

        this.setTitle("�û���ȫ���ã��һ�����");

        this.getContentPane().add(lstQuestion);

        this.getContentPane().add(btnCancel);

        this.getContentPane().add(txtAnswer);

        this.getContentPane().add(lblm2);

        this.getContentPane().add(lblm1);

        this.getContentPane().add(lblname);

        this.getContentPane().add(btnSure);

        this.getContentPane().add(lblDown);

        this.getContentPane().add(txtQuestion);

        this.getContentPane().add(txtname);

        this.getContentPane().add(lblmima);

        this.getContentPane().add(lblsz, null);

        lblname.setText("��  ��  ����");

        lblname.setBounds(new Rectangle(125, 115, 100, 36));
    }
}
