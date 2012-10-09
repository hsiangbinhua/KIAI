package insurance;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.sql.*;

public class frmManager extends JFrame {
    public frmManager() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*�޸��û����õķ���*/
    public void userSetup() {
        String name = txtName.getText();
        String oldpw = txtOldPW.getText();
        String newpw = txtNew.getText();
        String surepw = txtSurePw.getText();
        String question = txtQuestion.getText();
        String answer = txtAnswer.getText();
        String strsql =
                "update User_form set Login_Name='" + name + "' , Login_Id='" +
                newpw + "' , Question='" + question + "' , Answer='" +
                answer + "',picture=''  where Login_Id='" + oldpw + "'";
        System.out.println();
        if (name.length() == 0 || oldpw.length() == 0 || question.length() == 0 ||
            answer.length() == 0) {
            JOptionPane.showConfirmDialog(null, "����д������Ϣ", "�û�������ʾ", 1);
            return;
        }
        if (newpw.equals(surepw) == false) {
            JOptionPane.showConfirmDialog(null, "ȷ�������������벻һ�£���ȷ��������", "�û�������ʾ",
                                          1);
            return;
        } else {
            try {
                main.stmt.execute(strsql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void jbInit() throws Exception {

        /*ȷ���޸�,�����µ�¼*/
        btnSure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userSetup(); //�����޸����õķ���
                frmManager.this.dispose();
                frmLogin login = new frmLogin();
                login.setUndecorated(true); //ȥ��������
                login.setSize(650, 480);
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            }
        });
        /*����*/
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        ImageIcon mima = new ImageIcon("image\\mima.jpg");
        lblbei.setIcon(mima);
        //lblbei.setVisible(false);
        lblbei.setBounds(new Rectangle(0, 0, 777, 604));
        ImageIcon inter = new ImageIcon("image\\����.jpg");
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        jTabbedPane1.setBounds(new Rectangle( -1, 0, 593, 550));
        pnlChangePW.setFont(new java.awt.Font("������κ", Font.PLAIN, 15));
        pnlChangePW.setLayout(null);
        txtName.setText("");
        txtName.setBounds(new Rectangle(114, 67, 131, 29));
        lblAnswer.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblAnswer.setForeground(Color.magenta);
        lblAnswer.setText("�ܱ��𰸣�");
        lblAnswer.setBounds(new Rectangle(289, 153, 103, 35));
        lblOldPw.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblOldPw.setForeground(Color.magenta);
        lblOldPw.setText("ԭ���룺");
        lblOldPw.setBounds(new Rectangle(19, 107, 81, 42));
        txtOldPW.setBounds(new Rectangle(115, 116, 131, 29));
        lblQuestion.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblQuestion.setForeground(Color.magenta);
        lblQuestion.setText("�ܱ����⣺");
        lblQuestion.setBounds(new Rectangle(285, 53, 102, 43));
        lblNew.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblNew.setForeground(Color.magenta);
        lblNew.setText("�����룺");
        lblNew.setBounds(new Rectangle(17, 153, 82, 40));
        txtAnswer.setText("");
        txtAnswer.setBounds(new Rectangle(289, 213, 251, 26));
        btnSure.setBounds(new Rectangle(98, 279, 152, 34));
        btnSure.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        btnSure.setForeground(Color.green);
        btnSure.setText("ȷ�����µ�¼");
        btnCancel.setBounds(new Rectangle(334, 280, 99, 32));
        btnCancel.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        btnCancel.setForeground(Color.green);
        btnCancel.setText("����");
        lblbei.setText("");
        lblbei.setBounds(new Rectangle( -4, 0, 691, 426));
        lbltxtbg.setLabelFor(jTabbedPane1);
        lbltxtbg.setText("");
        pnltxt.setToolTipText("��ȫ������ܰ��ʾ");
        ImageIcon imgtxtbg = new ImageIcon("image\\changePwtxt.jpg");
        lbltxtbg.setIcon(imgtxtbg);
        txtQuestion.setText("");
        txtQuestion.setBounds(new Rectangle(284, 101, 250, 29));
        lblName.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblName.setForeground(Color.magenta);
        lblName.setText("�û�����");
        lblName.setBounds(new Rectangle(15, 53, 81, 41));
        txtNew.setBounds(new Rectangle(116, 167, 131, 29));
        txtSurePw.setBounds(new Rectangle(119, 218, 131, 29));
        lblSurePw.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblSurePw.setForeground(Color.magenta);
        lblSurePw.setText("ȷ��������");
        lblSurePw.setBounds(new Rectangle(1, 202, 111, 43));
        this.setResizable(false);
        this.setTitle("�û�����");
        pnlChangePW.add(btnSure);
        pnlChangePW.add(btnCancel);
        pnlChangePW.add(lblSurePw);
        pnlChangePW.add(lblNew);
        pnlChangePW.add(lblOldPw);
        pnlChangePW.add(txtNew);
        pnlChangePW.add(txtSurePw);
        pnlChangePW.add(txtOldPW);
        pnlChangePW.add(txtName);
        pnlChangePW.add(lblName);
        pnlChangePW.add(txtAnswer);
        pnlChangePW.add(txtQuestion);
        pnlChangePW.add(lblQuestion);
        pnlChangePW.add(lblAnswer);
        pnlChangePW.add(lblbei);
        pnltxt.add(lbltxtbg);
        pnlChangePW.add(lblbei);
        pnlChangePW.add(lblbei);
        this.getContentPane().add(jTabbedPane1);
        jTabbedPane1.add(pnltxt, "�û���ȫ������ܰ��ʾ");
        jTabbedPane1.add(pnlChangePW, "�û����ò���");
    }

    JTabbedPane jTabbedPane1 = new JTabbedPane();
    JPanel pnlChangePW = new JPanel();
    JTextField txtName = new JTextField();
    JLabel lblAnswer = new JLabel();
    JLabel lblOldPw = new JLabel();
    JTextField txtOldPW = new JTextField();
    JLabel lblQuestion = new JLabel();
    JLabel lblNew = new JLabel();
    JTextField txtAnswer = new JTextField();
    JButton btnSure = new JButton();
    JButton btnCancel = new JButton();
    JLabel lblbei = new JLabel();
    JLabel lbltxtbg = new JLabel();
    JPanel pnltxt = new JPanel();
    JTextField txtQuestion = new JTextField();
    JLabel lblName = new JLabel();
    JTextField txtNew = new JTextField();
    JTextField txtSurePw = new JTextField();
    JLabel lblSurePw = new JLabel();
}
