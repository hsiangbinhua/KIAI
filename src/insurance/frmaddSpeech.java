package insurance;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class frmaddSpeech extends JFrame {
    public frmaddSpeech() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        btnok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textInsert.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "����Ϊ�գ������뱣�ջ���");
                } else {

                }
            }
        });
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "�Ƿ����Ҫ�˳���", "��ܰ��ʾ",
                        JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    frmaddSpeech.this.dispose();
                }

            }
        });
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(" �� �� �� �� �� ��");
        jLabel1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
        jLabel1.setForeground(Color.magenta);
        jLabel1.setBorder(BorderFactory.createEtchedBorder());
        jLabel1.setText("  ��  ��  ��  ��  ��  �⣺");
        jLabel1.setBounds(new Rectangle(0, 0, 194, 29));
        btnok.setBackground(Color.yellow);
        btnok.setFont(new java.awt.Font("Dialog", Font.PLAIN, 10));
        btnok.setForeground(Color.magenta);
        btnExit.setBackground(Color.yellow);
        btnExit.setFont(new java.awt.Font("Dialog", Font.PLAIN, 10));
        btnExit.setForeground(Color.blue);
        textInsert.setBorder(BorderFactory.createLoweredBevelBorder());
        txtarea.setText("");
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.
                                                VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBounds(new Rectangle(6, 93, 329, 184));
        this.getContentPane().add(jPanel1);
        jPanel1.setLayout(null);
        textInsert.setBounds(new Rectangle(6, 6, 254, 36));
        btnok.setBounds(new Rectangle(77, 279, 59, 29));
        btnok.setText("ȷ  ��");
        btnExit.setBounds(new Rectangle(166, 281, 59, 28));
        btnExit.setText("��  ��");
        jPanel1.add(textInsert);
        textInsert.setText("");
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(btnok);
        this.getContentPane().add(btnExit);
        this.getContentPane().add(jScrollPane1);
        jScrollPane1.getViewport().add(txtarea);
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setBounds(new Rectangle(4, 37, 274, 47));
    }

    JLabel jLabel1 = new JLabel();
    JPanel jPanel1 = new JPanel();
    JTextField textInsert = new JTextField();
    JButton btnok = new JButton();
    JButton btnExit = new JButton();
    JTextArea txtarea = new JTextArea();
    JScrollPane jScrollPane1 = new JScrollPane();
}
