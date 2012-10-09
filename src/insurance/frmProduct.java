package insurance;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JTable;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.ResultSet;

public class frmProduct extends JFrame {
    public frmProduct() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void tt() {
        String str =
                "select * from InsureInfo where Avail=1 order by InsureID";
        Producty.removeAllElements();
        try {
            ResultSet rs = main.stmt.executeQuery(str);
            while (rs.next() == true) {
                Vector v = new Vector();
                v.add(rs.getString(1) + "");
                v.add(rs.getString(2) + "");
                v.add(rs.getString(3) + "");
                v.add(rs.getString(4) + "");
                v.add(rs.getString(5) + "");
                v.add(rs.getString(6) + "");
                Producty.add(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dtm = new DefaultTableModel(Producty, Productx);
        jTableProduct.setModel(dtm);
    }

    private void jbInit() throws Exception {
        this.setResizable(false);
        Productx.add("��Ʒ����");
        Productx.add("��Ʒ����");
        Productx.add("���ѷ�ʽ");
        Productx.add("��������");
        Productx.add("��������");
        Productx.add("��ע");
        tt();
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strr =
                        "select * from InsureInfo where Avail=1 and InsureID='" +
                        txt1.getText() + "' or InsureName='" + txt2.getText() +
                        "'";

                try {
                    if (txt1.getText().length() == 0 &&
                        txt2.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "�������Ʒ���Ż����ƽ��в�ѯ��");
                        return;
                    }
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    txt8.setText("");
                    tt();
                    ResultSet rs = main.stmt.executeQuery(strr);

                    if (rs.next() == true) {

                        txt1.setText(rs.getString(1) + "");
                        txt2.setText(rs.getString(2) + "");
                        txt3.setText(rs.getString(4) + "");
                        txt4.setText(rs.getString(5) + "");

                        txt8.setText(rs.getString(6) + "");
                    } else {
                        txt1.setText("");
                        txt2.setText("");
                        txt3.setText("");
                        txt4.setText("");

                        txt8.setText("");
                        JOptionPane.showMessageDialog(null,
                                "�Բ���û��������ѯ�Ĳ�Ʒ��");
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                jCheckBox1.setSelected(false);
                jCheckBox2.setSelected(false);
                jCheckBox4.setSelected(false);
                jCheckBox6.setSelected(false);
                jCheckBox10.setSelected(false);
                jCheckBox11.setSelected(false);
                jCheckBox13.setSelected(false);
                jCheckBox14.setSelected(false);
                txt8.setText("");
                tt();
            }
        });
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stro = "select * from InsureInfo  where InsureID='" +
                              txt1.getText() + "' and InsureName='" +
                              txt2.getText() + "' and Avail=1";
                try {
                    if (txt3.getText().matches("[0-9]*") == false ||
                        txt4.getText().matches("[0-9]*") == false) {
                        JOptionPane.showMessageDialog(null, "����������������֣�");
                        return;
                    }
                    if (txt1.getText().length() == 0 ||
                        txt2.getText().length() == 0 ||
                        txt3.getText().length() == 0 ||
                        txt4.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "����д������Ϣ��");
                        return;
                    }
                    ResultSet rs = main.stmt.executeQuery(stro);
                    if (rs.next() == true) {
                        JOptionPane.showMessageDialog(null, "�ò�Ʒ�Ѵ��ڣ������������ӣ�");
                        return;
                    }

                    x = Integer.parseInt(txt3.getText());
                    y = Integer.parseInt(txt4.getText());
                    if (x > y && x==y) {
                        JOptionPane.showMessageDialog(null,
                                "������������������ޱ�����ڻ�����������ޣ�");
                        return;
                    }
                    if (jCheckBox1.isSelected()) {
                        F1 = "�꽻" + " " + F1;
                    }
                    if (jCheckBox2.isSelected()) {
                        F1 = "����" + " " + F1;
                    }
                    if (jCheckBox4.isSelected()) {
                        F1 = "3�꽻" + " " + F1;
                    }
                    if(jCheckBox6.isSelected()){
                       F1="1�꽻"+" "+ F1;
                   }
                    if(jCheckBox10.isSelected()){
                        F1 = "30�꽻" + " " + F1;
                    }
                    if (jCheckBox11.isSelected()) {
                        F1 = "20�꽻" + " " + F1;
                    }
                    if (jCheckBox13.isSelected()) {
                        F1 = "10�꽻" + " " + F1;
                    }
                    if (jCheckBox14.isSelected()) {
                        F1 = "5�꽻" + " " + F1;
                    }
                    String strs = "insert into InsureInfo values('" +
                                  txt1.getText() +
                                  "','" + txt2.getText() + "','" + F1 + "'," +
                                  txt3.getText() +
                                  "," +
                                  txt4.getText() + ",'" +
                                  txt8.getText() + "',1)";
                    main.stmt.execute(strs);
                    System.out.println(strs);
                    JOptionPane.showMessageDialog(null,
                                                  "����" + txt2.getText() +
                                                  "��Ʒ�ɹ���");
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    txt8.setText("");
                    tt();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strc = "select * from InsureInfo where InsureID='" +
                              txt1.getText() + "' and Avail=1";
                try {
                    if (txt1.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "�������Ʒ���ţ�");
                        return;
                    }
                    ResultSet rs = main.stmt.executeQuery(strc);
                    if (rs.next() == false) {
                        JOptionPane.showMessageDialog(null, "û����Ҫ�޸ĵĲ�Ʒ��");
                        return;
                    }
                    rs.close();
                    if (jCheckBox1.isSelected()) {
                        F1 = "�꽻" + " " + F1;
                    }
                    if (jCheckBox2.isSelected()) {
                        F1 = "����" + " " + F1;
                    }
                    if (jCheckBox4.isSelected()) {
                        F1 = "3�꽻" + " " + F1;
                    }
                    if(jCheckBox6.isSelected()){
                       F1="1�꽻"+" "+ F1;
                   }
                    if(jCheckBox10.isSelected()){
                        F1 = "30�꽻" + " " + F1;
                    }
                    if (jCheckBox11.isSelected()) {
                        F1 = "20�꽻" + " " + F1;
                    }
                    if (jCheckBox13.isSelected()) {
                        F1 = "10�꽻" + " " + F1;
                    }
                    if (jCheckBox14.isSelected()) {
                        F1 = "5�꽻" + " " + F1;
                    }

                    String stra = "update InsureInfo set InsureName='" +
                                  txt2.getText() +
                                  "',JfType='"+F1+"',MinAge=" + txt3.getText() +
                                  ",MaxAge=" + txt4.getText() +
                                  ",Remark ='" + txt8.getText() +
                                  "'where InsureID='" + txt1.getText() +
                                  "'";
                    main.stmt.execute(stra);
                    JOptionPane.showMessageDialog(null,
                                                  "" + txt1.getText() +
                                                  "��Ʒ��Ϣ�޸ĳɹ���");
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    txt6.setText("");
                    txt8.setText("");
                    jCheckBox1.setSelected(false);
                    jCheckBox2.setSelected(false);
                    jCheckBox4.setSelected(false);
                    jCheckBox6.setSelected(false);
                    jCheckBox10.setSelected(false);
                    jCheckBox11.setSelected(false);
                    jCheckBox13.setSelected(false);
                    jCheckBox14.setSelected(false);
                    tt();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jb5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strw = "select * from InsureInfo where InsureID='" +
                              txt1.getText() + "' and Avail=1";
                try {
                    if (txt1.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "�������Ʒ���ţ�");
                        return;
                    }
                    ResultSet rs = main.stmt.executeQuery(strw);
                    if (rs.next() == false) {
                        JOptionPane.showMessageDialog(null, "û����Ҫɾ���Ĳ�Ʒ��");
                        return;
                    }
                    String strb =
                            "update InsureInfo set Avail=0 where InsureID='" +
                            txt1.getText() + "'";
                    main.stmt.execute(strb);
                    JOptionPane.showMessageDialog(null,
                                                  "" + txt2.getText() +
                                                  "��Ʒɾ���ɹ���");
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    jCheckBox1.setSelected(false);
                    jCheckBox2.setSelected(false);
                    jCheckBox4.setSelected(false);
                    jCheckBox6.setSelected(false);
                    jCheckBox10.setSelected(false);
                    jCheckBox11.setSelected(false);
                    jCheckBox13.setSelected(false);
                    jCheckBox14.setSelected(false);
                    txt8.setText("");
                    tt();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        txt2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (txt2.getText().length() == 100) {
                    e.consume(); //�ع��¼�
                }
            }
        });

        txt8.setLineWrap(true); //�����Զ�����

        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
                jbox1.setSelectedItem("��Ч");
                txt8.setText("");
            }
        });
        jb6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmProduct.this.dispose();
            }
        });
        jTableProduct.setAutoResizeMode(JTable.
                                        AUTO_RESIZE_OFF);

        txt2.setText("");
        txt2.setBounds(new Rectangle(107, 359, 139, 20));
        txt3.setBounds(new Rectangle(107, 413, 74, 21));
        txt4.setBounds(new Rectangle(108, 472, 74, 21));
        sp.getViewport().add(jTableProduct);
        getContentPane().setLayout(null);
        jCheckBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox1.setText("�꽻");
        jCheckBox1.setBounds(new Rectangle(407, 346, 83, 25));
        jCheckBox2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox2.setText("�ý�");
        jCheckBox2.setBounds(new Rectangle(506, 346, 83, 25));
        jCheckBox4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox4.setText("3����");
        jCheckBox4.setBounds(new Rectangle(699, 345, 83, 25));
        jCheckBox6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox6.setText("1����");
        jCheckBox6.setBounds(new Rectangle(603, 346, 83, 25));
        jCheckBox10.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox10.setText("30����");
        jCheckBox10.setBounds(new Rectangle(699, 373, 83, 25));
        jCheckBox11.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox11.setText("20����");
        jCheckBox11.setBounds(new Rectangle(604, 372, 83, 25));
        jCheckBox13.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox13.setText("10����");
        jCheckBox13.setBounds(new Rectangle(505, 375, 88, 25));
        jCheckBox14.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        jCheckBox14.setText("5����");
        jCheckBox14.setBounds(new Rectangle(408, 375, 87, 25));

        sp.setBounds(new Rectangle(10, 13, 771, 270));

        sptt.getViewport().add(txt8);
        sptt.setBounds(new Rectangle(404, 420, 357, 80));
        jb1.setBounds(new Rectangle(204, 294, 71, 25));
        jb1.setFont(new java.awt.Font("����_GB2312",
                                      Font.PLAIN, 18));
        jb1.setText("��ѯ");
        jb2.setBounds(new Rectangle(304, 294, 73, 25));
        jb2.setFont(new java.awt.Font("����_GB2312",
                                      Font.PLAIN, 18));
        jb2.setText("ˢ��");
        jb3.setBounds(new Rectangle(404, 294, 71, 25));
        jb3.setFont(new java.awt.Font("����_GB2312",
                                      Font.PLAIN, 18));
        jb3.setText("����");
        jb4.setBounds(new Rectangle(504, 294, 71, 25));
        jb4.setFont(new java.awt.Font("����_GB2312",
                                      Font.PLAIN, 18));
        jb4.setText("�޸�");
        jb5.setBounds(new Rectangle(604, 294, 71, 25));
        jb5.setFont(new java.awt.Font("����_GB2312",
                                      Font.PLAIN, 18));
        jb5.setText("ɾ��");
        jb6.setBounds(new Rectangle(704, 294, 71, 25));
        jb6.setFont(new java.awt.Font("����_GB2312",
                                      Font.PLAIN, 18));
        jb6.setText("�˳�");
        jLabel1.setForeground(SystemColor.activeCaption);
        jLabel2.setForeground(SystemColor.activeCaption);
        jLabel5.setForeground(SystemColor.activeCaption);
        txt1.setBounds(new Rectangle(107, 298, 75, 20));
        jLabel1.setText("��Ʒ���ţ�");
        jLabel1.setBounds(new Rectangle(15, 295, 90, 25));
        jLabel1.setFont(new java.awt.Font("����_GB2312",
                                          Font.PLAIN, 18));
        jLabel2.setText("��Ʒ���ƣ�");
        jLabel2.setFont(new java.awt.Font("����_GB2312",
                                          Font.PLAIN, 18));
        jLabel2.setBounds(new Rectangle(13, 355, 91, 25));
        jLabel5.setFont(new java.awt.Font("����_GB2312",
                                          Font.PLAIN, 18));
        jLabel5.setText("��    ע��");
        jLabel5.setBounds(new Rectangle(304, 411, 90, 25));
        jLabel8.setFont(new java.awt.Font("����_GB2312",
                                          Font.PLAIN, 18));
        jLabel8.setForeground(SystemColor.activeCaption);
        jLabel8.setText("�������ޣ�");
        jLabel8.setBounds(new Rectangle(15, 411, 93, 24));
        jLabel7.setFont(new java.awt.Font("����_GB2312",
                                          Font.PLAIN, 18));
        jLabel7.setForeground(SystemColor.activeCaption);
        jLabel7.setText("�������ޣ�");
        jLabel7.setBounds(new Rectangle(15, 471, 95, 22));
        jLabel9.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        jLabel9.setForeground(SystemColor.activeCaption);
        jLabel9.setText("���ѷ�ʽ��");
        jLabel9.setBounds(new Rectangle(303, 348, 90, 23));
        this.setTitle("���ղ�Ʒ��Ϣ��");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(sp);
        this.getContentPane().add(sptt);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jLabel8);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(txt1);
        this.getContentPane().add(jCheckBox14);
        this.getContentPane().add(jCheckBox1);
        this.getContentPane().add(jCheckBox2);
        this.getContentPane().add(jCheckBox13);
        this.getContentPane().add(jCheckBox6);
        this.getContentPane().add(jCheckBox11);
        this.getContentPane().add(jCheckBox4);
        this.getContentPane().add(jCheckBox10);
        this.getContentPane().add(jb1);
        this.getContentPane().add(jb2);
        this.getContentPane().add(jb3);
        this.getContentPane().add(jb6);
        this.getContentPane().add(jb5);
        this.getContentPane().add(jb4);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(txt2);

        this.getContentPane().add(txt4);
        this.getContentPane().add(txt3);
    }
    int x=0, y=0;
    String  F1=" ";
    JTable jTableProduct = new JTable();
    Vector Productx = new Vector();
    Vector Producty = new Vector();
    DefaultTableModel dtm;
    DefaultTableModel dtmt;
    JScrollPane sp = new JScrollPane();

    JScrollPane sptt = new JScrollPane();
    JButton jb3 = new JButton();
    JButton jb5 = new JButton();
    JButton jb6 = new JButton();
    JButton jb1 = new JButton();
    JTextField txt1 = new JTextField();
    JLabel jLabel1 = new JLabel();
    JComboBox jbox1 = new JComboBox();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JTextArea txt7 = new JTextArea();
    JButton jb4 = new JButton();
    JTextArea txt8 = new JTextArea();
    JButton jb2 = new JButton();
    JList lstName = new JList();

    JTextField txt2 = new JTextField();
    JTextField txt6 = new JTextField();
    JLabel jLabel8 = new JLabel();
    JTextField txt3 = new JTextField();
    JLabel jLabel7 = new JLabel();
    JTextField txt4 = new JTextField();
    JLabel jLabel9 = new JLabel();
    JComboBox jbox2 = new JComboBox();
    JTextField txt5 = new JTextField();
    JCheckBox jCheckBox1 = new JCheckBox();
    JCheckBox jCheckBox2 = new JCheckBox();
    JCheckBox jCheckBox4 = new JCheckBox();
    JCheckBox jCheckBox6 = new JCheckBox();
    JCheckBox jCheckBox10 = new JCheckBox();
    JCheckBox jCheckBox11 = new JCheckBox();
    JCheckBox jCheckBox13 = new JCheckBox();
    JCheckBox jCheckBox14 = new JCheckBox();
}
