package insurance;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.*;
import javax.swing.JTable;
import java.util.Vector;
import javax.swing.table.*;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class frameClient extends JFrame {
    public frameClient() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    void clean() { //ˢ�·���
        txtB.setText("");
        cboSex.setSelectedIndex(0);
        cboLeixing.setSelectedIndex(0);
        cboAge.setSelectedIndex(0);
        txtName.setText("");
        txtName2.setText("");
        txtPhone2.setText("");
        txtName3.setText("");
        txtLike.setText("");
        txtPhone1.setText("");
        txtWork.setText("");
        txtEmail.setText("");
        txtAdd.setText("");
        txtBei.setText("");
        txtZu.setText("");
        txtHome.setText("");

    }

    public void newtable() { //�����º���
        x.removeAllElements();
        y.removeAllElements();
        try {
            x.add("���");
            x.add("�ͻ�����");
            x.add("�ͻ�����");
            x.add("����/�ǳ�");
            x.add("�Ա�");
            x.add("��������");
            x.add("����");
            x.add("�ͻ�����");
            x.add("������λ");
            x.add("����/�س�");
            x.add("��ͥסַ");
            x.add("ס���绰");
            x.add("��ϵ�绰��");
            x.add("��ϵ�绰��");
            x.add("�����ʼ�");
            x.add("��ż����");
            x.add("��ע");
            ResultSet rs = main.stmt.executeQuery(
                    "select * from Client_form where Avail=1");
            while (rs.next() == true) {
                Vector lin = new Vector();
                lin.add(rs.getInt(1) + "");
                lin.add(rs.getString(2));
                lin.add(rs.getString(3));
                lin.add(rs.getString(4));
                if (rs.getInt(5) == 0) {
                    lin.add("��");
                } else {
                    lin.add("Ů");
                }
                //lin.add(rs.getInt(5)+"");
                lin.add(rs.getString(6));
                lin.add(rs.getInt(7) + "");
                int leixing = rs.getInt(8);
                if (leixing == 1) {
                    lin.add("׼�û�");
                }
                if (leixing == 2) {
                    lin.add("һ���û�");
                }
                if (leixing == 3) {
                    lin.add("VIP�û�");
                }
                //lin.add(rs.getInt(8)+"");
                lin.add(rs.getString(9));
                lin.add(rs.getString(10));
                lin.add(rs.getString(11));
                lin.add(rs.getString(12));
                lin.add(rs.getString(13));
                lin.add(rs.getString(14));
                lin.add(rs.getString(15));
                lin.add(rs.getString(16));
                lin.add(rs.getString(17));
                y.add(lin);
            }
            model = new DefaultTableModel(y, x);
            infoTable.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        infoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //�ر��Զ�ƽ��
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setForeground(Color.black);
        btnNew.addActionListener(new ActionListener() { //ˢ�°�ť�����¼�
            public void actionPerformed(ActionEvent e) {
                txtB.setText("");
                cboSex.setSelectedIndex(0);
                cboLeixing.setSelectedIndex(0);
                cboAge.setSelectedIndex(0);
                txtName.setText("");
                txtName2.setText("");
                txtPhone2.setText("");
                txtName3.setText("");
                txtLike.setText("");
                txtPhone1.setText("");
                txtWork.setText("");
                txtEmail.setText("");
                txtAdd.setText("");
                txtBei.setText("");
                txtZu.setText("");
                txtHome.setText("");
                newtable(); //���ú���newtable()
            }
        });
        btnOut.addActionListener(new ActionListener() { //�˳���ť�����¼�
            public void actionPerformed(ActionEvent e) {
                try {
                    int yn = JOptionPane.showConfirmDialog(null, "�Ƿ����Ҫ�˳�����",
                            "����", 2);
                    if (yn == 0) {
                        main.stmt.close();
                        frameClient.this.dispose();
                    } else {
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnFind.addActionListener(new ActionListener() { //��ѯ����ť�������¼� δ���
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtName.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "������Ϣ��������������");
                        return;
                    }
                    int leixing = cboLeixing.getSelectedIndex() + 1;
                    ResultSet rsFind = main.stmt.executeQuery(
                            "select * from Client_form where Client_Name='" +
                            txtName.getText() + "' and Client_Sex=" +
                            cboSex.getSelectedIndex() + " and Avail=1");
                    if (rsFind.next() == false) {
                        JOptionPane.showMessageDialog(null, "û�и��û���Ϣ�����ʵ�����룡");
                        return;
                    }

                    txtZu.setText(rsFind.getString(2));
                    //txtName.setText(rsFind.getString(3));�û���д������Ҫ
                    txtName2.setText(rsFind.getString(4));
                    //cboSex.setSelectedIndex(rsFind.getInt(5));�û���д������Ҫ
                    txtB.setText(rsFind.getString(6));
                    cboAge.setSelectedIndex(rsFind.getInt(7) - 1);
                    cboLeixing.setSelectedIndex(rsFind.getInt(8) - 1);
                    txtWork.setText(rsFind.getString(9));
                    txtLike.setText(rsFind.getString(10));
                    txtAdd.setText(rsFind.getString(11));
                    txtHome.setText(rsFind.getString(12));
                    txtPhone1.setText(rsFind.getString(13));
                    txtPhone2.setText(rsFind.getString(14));
                    txtEmail.setText(rsFind.getString(15));
                    txtName3.setText(rsFind.getString(16));
                    txtBei.setText(rsFind.getString(17));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnInsert.addActionListener(new ActionListener() { //�����ӡ���ť�ĵ����¼� ����������
            public void actionPerformed(ActionEvent e) {
                if (txtName.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "������Ϣ��������������");
                    return;
                }
                //����Ϊ������������Ƿ�������ݿ�
                if (txtZu.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "���� �����ݹ�����");
                    return;
                }
                if (txtName.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "���� �����ݹ�����");
                    return;
                }
                if (txtB.getText().length() > 12) {
                    JOptionPane.showMessageDialog(null, "���� �����ݹ�������");
                    return;
                }
                if (txtName2.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "����/�ǳ� �����ݹ�������");
                    return;
                }
                if (txtName2.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "����/�س� �����ݹ�������");
                    return;
                }
                if (txtName3.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ż���� �����ݹ�������");
                    return;
                }
                if (txtAdd.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "��ͥסַ �����ݹ�������");
                    return;
                }
                if (txtHome.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ͥ�绰 �����ݹ�������");
                    return;
                }
                if (txtPhone1.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ϵ�绰�� �����ݹ�������");
                    return;
                }
                if (txtPhone2.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ϵ�绰�� �����ݹ�������");
                    return;
                }
                if (txtWork.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "������λ �����ݹ�������");
                    return;
                }

                if (txtEmail.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "�����ʼ� �����ݹ�������");
                    return;
                }
                if (txtBei.getText().length() > 200) {
                    JOptionPane.showMessageDialog(null, "��ע �����ݹ�������");
                    return;
                }
                String phone = txtHome.getText();
                String phone1 = txtPhone1.getText();
                String phone2 = txtPhone2.getText();
                if (phone.matches("[0-9]*") == false || phone1.matches("[0-9]*") == false ||
                    phone2.matches("[0-9]*") == false) {
                    JOptionPane.showMessageDialog(null, "�绰�������Ϊ���֣�");
                    return;
                }

                try {
                    int age = cboAge.getSelectedIndex() + 1;
                    int leixing = cboLeixing.getSelectedIndex() + 1;
                    ResultSet rs = main.stmt.executeQuery(
                            "select * from Client_form where Client_Name='" +
                            txtName.getText() + "' and Client_Sex=" +
                            cboSex.getSelectedIndex() + " and Avail=1");
                    if (rs.next() == true) {
                        JOptionPane.showMessageDialog(null, "�Ѿ����ڸÿͻ�!");
                        return;
                    }

                    main.stmt.execute("insert into Client_form values('" +
                                      txtZu.getText() + "','" + txtName.getText() +
                                      "','" + txtName2.getText() + "'," +
                                      cboSex.getSelectedIndex() + ",'" +
                                      txtB.getText() + "'," + age + "," +
                                      leixing + ",'" + txtWork.getText() +
                                      "','" + txtLike.getText() + "','" +
                                      txtAdd.getText() + "','" +
                                      txtHome.getText() + "','" +
                                      txtPhone1.getText() + "','" +
                                      txtPhone2.getText() + "','" +
                                      txtEmail.getText() + "','" +
                                      txtName3.getText() + "','" +
                                      txtBei.getText() + "',1)");
                    JOptionPane.showMessageDialog(null, "���ӳɹ�!");
                    newtable(); //���ú���newtable()
                    clean(); //���ú���clean()
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() { //��ɾ������ť�ĵ����¼�
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtName.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "������Ϣ��������������");
                        return;
                    }
                    int leixing = cboLeixing.getSelectedIndex() + 1;
                    ResultSet rsFind = main.stmt.executeQuery(
                            "select * from Client_form where Client_Name='" +
                            txtName.getText() + "' and Client_Sex=" +
                            cboSex.getSelectedIndex() + " and Avail=1");
                    if (rsFind.next() == false) {
                        JOptionPane.showMessageDialog(null, "û�и��û���Ϣ�����ʵ��");
                        return;
                    }
                    int yn = JOptionPane.showConfirmDialog(null, "�Ƿ����Ҫɾ�������ݣ���",
                            "����", 2);
                    if (yn == 0) {
                        main.stmt.execute(
                                "update Client_form set Avail=0 where Client_Name='" +
                                txtName.getText() + "' and Client_Sex=" +
                                cboSex.getSelectedIndex() + " and Client_Type=" +
                                leixing + "");
                        JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
                        newtable();
                        clean();
                    } else {
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() { //���޸ġ���ť�ĵ����¼�
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtName.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "������Ϣ��������������");
                        return;
                    }
                    int leixing = cboLeixing.getSelectedIndex() + 1;
                    ResultSet rsFind = main.stmt.executeQuery(
                            "select * from Client_form where Client_Name='" +
                            txtName.getText() + "' and Client_Sex=" +
                            cboSex.getSelectedIndex() + " and Avail=1");
                    if (rsFind.next() == false) {
                        JOptionPane.showMessageDialog(null, "û�и��û���Ϣ�����ʵ��");
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //����Ϊ������������Ƿ�������ݿ�
                if (txtZu.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "���� �����ݹ�����");
                    return;
                }
                if (txtName.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "���� �����ݹ�����");
                    return;
                }
                if (txtB.getText().length() > 12) {
                    JOptionPane.showMessageDialog(null, "���� �����ݹ�������");
                    return;
                }
                if (txtName2.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "����/�ǳ� �����ݹ�������");
                    return;
                }
                if (txtName2.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "����/�س� �����ݹ�������");
                    return;
                }
                if (txtName3.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ż���� �����ݹ�������");
                    return;
                }
                if (txtAdd.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "��ͥסַ �����ݹ�������");
                    return;
                }
                if (txtHome.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ͥ�绰 �����ݹ�������");
                    return;
                }
                if (txtPhone1.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ϵ�绰�� �����ݹ�������");
                    return;
                }
                if (txtPhone2.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ϵ�绰�� �����ݹ�������");
                    return;
                }
                if (txtWork.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "������λ �����ݹ�������");
                    return;
                }

                if (txtEmail.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "�����ʼ� �����ݹ�������");
                    return;
                }
                if (txtBei.getText().length() > 200) {
                    JOptionPane.showMessageDialog(null, "��ע �����ݹ�������");
                    return;
                }
                String phone = txtHome.getText();
                String phone1 = txtPhone1.getText();
                String phone2 = txtPhone2.getText();
                if (phone.matches("[0-9]*") == false || phone1.matches("[0-9]*") == false ||
                    phone2.matches("[0-9]*") == false) {
                    JOptionPane.showMessageDialog(null, "�绰�������Ϊ���֣�");
                    return;
                }
                try {
                    int yn = JOptionPane.showConfirmDialog(null, "�Ƿ����Ҫ�޸ģ���",
                            "����", 2);
                    if (yn == 0) {
                        int age = cboAge.getSelectedIndex() + 1;
                        int leixing = cboLeixing.getSelectedIndex() + 1;
                        main.stmt.execute("update Client_form set Group_No='" +
                                          txtZu.getText() + "',Client_Name='" +
                                          txtName.getText() + "',Nick_Name='" +
                                          txtName2.getText() + "',Client_Sex=" +
                                          cboSex.getSelectedIndex() +
                                          ",Birthday='" + txtB.getText() +
                                          "',Age=" + age + ",Client_Type=" +
                                          leixing + ",Client_Commary='" +
                                          txtWork.getText() +
                                          "',Client_Interest='" +
                                          txtLike.getText() +
                                          "',Client_Address='" + txtAdd.getText() +
                                          "',Home_No='" + txtHome.getText() +
                                          "',Tele_No1='" + txtPhone1.getText() +
                                          "',Tele_No2='" + txtPhone2.getText() +
                                          "',E_mail='" + txtEmail.getText() +
                                          "',Consort_Name='" + txtName3.getText() +
                                          "',Remark='" + txtBei.getText() +
                                          "' where Client_Name='" +
                                          txtName.getText() +
                                          "' and Client_Sex=" +
                                          cboSex.getSelectedIndex() + "");
                        JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
                        newtable();
                        clean();
                    } else {
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        infoTable.addMouseListener(new MouseAdapter() { //������갴���¼�
            public void mousePressed(MouseEvent e) {
                try {
                    ResultSet rsTable = main.stmt.executeQuery(
                            "select * from Client_form where Avail=1");
                    for (int i = 0; i <= infoTable.getSelectedRow(); i++) {
                        rsTable.next();
                    }
                    txtZu.setText(rsTable.getString(2));
                    txtName.setText(rsTable.getString(3));
                    txtName2.setText(rsTable.getString(4));
                    cboSex.setSelectedIndex(rsTable.getInt(5));
                    txtB.setText(rsTable.getString(6));
                    cboAge.setSelectedIndex(rsTable.getInt(7) - 1);
                    cboLeixing.setSelectedIndex(rsTable.getInt(8) - 1);
                    txtWork.setText(rsTable.getString(9));
                    txtLike.setText(rsTable.getString(10));
                    txtAdd.setText(rsTable.getString(11));
                    txtHome.setText(rsTable.getString(12));
                    txtPhone1.setText(rsTable.getString(13));
                    txtPhone2.setText(rsTable.getString(14));
                    txtEmail.setText(rsTable.getString(15));
                    txtName3.setText(rsTable.getString(16));
                    txtBei.setText(rsTable.getString(17));
                    newtable();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        txtBei.setLineWrap(true);
        this.setTitle("�ͻ���Ϣ����");
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setBounds(new Rectangle(0, 0, 800, 205));
        lblzuming.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        lblzuming.setText("��   �飺");
        lblzuming.setBounds(new Rectangle(17, 243, 68, 36));
        lblName.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        lblName.setText("*��   ����");
        lblName.setBounds(new Rectangle(14, 277, 68, 36));
        lblSex.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        lblSex.setText("*��   ��");
        lblSex.setBounds(new Rectangle(14, 316, 68, 36));
        lblClass.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        lblClass.setText("*�ͻ����ͣ�");
        lblClass.setBounds(new Rectangle(14, 351, 83, 36));
        jLabel1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel1.setForeground(SystemColor.textHighlight);
        jLabel1.setText("��Ҫ��Ϣ����*�����");
        jLabel1.setBounds(new Rectangle(9, 209, 172, 36));
        jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel2.setForeground(SystemColor.textHighlight);
        jLabel2.setText("��ϸ��Ϣ��");
        jLabel2.setBounds(new Rectangle(359, 209, 83, 36));
        lblName2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        lblName2.setText("����/�ǳƣ�");
        lblName2.setBounds(new Rectangle(360, 297, 81, 36));
        lblAge.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        lblAge.setText(" ��      �䣺");
        lblAge.setBounds(new Rectangle(360, 236, 81, 36));
        jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel3.setText("������λ��");
        jLabel3.setBounds(new Rectangle(360, 512, 81, 36));
        jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel4.setText("����/�س���");
        jLabel4.setBounds(new Rectangle(360, 327, 81, 36));
        jLabel5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel5.setText("��ͥסַ��");
        jLabel5.setBounds(new Rectangle(360, 390, 81, 36));
        jLabel6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel6.setText("��ϵ�绰��");
        jLabel6.setBounds(new Rectangle(360, 452, 95, 36));
        jLabel7.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel7.setText("��ϵ�绰��");
        jLabel7.setBounds(new Rectangle(360, 482, 97, 36));
        jLabel8.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel8.setText("��ż������");
        jLabel8.setBounds(new Rectangle(360, 357, 88, 36));
        jLabel9.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel9.setText("�����ʼ���");
        jLabel9.setBounds(new Rectangle(360, 542, 88, 36));
        jLabel10.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel10.setText("��   ע��");
        jLabel10.setBounds(new Rectangle(14, 400, 88, 36));
        txtName.setBounds(new Rectangle(92, 282, 104, 24));
        cboSex.setBounds(new Rectangle(92, 318, 105, 25));
        txtName2.setText("");
        txtName2.setBounds(new Rectangle(448, 301, 97, 23));
        txtPhone2.setText("");
        txtPhone2.setBounds(new Rectangle(448, 489, 210, 23));
        txtName3.setText("");
        txtName3.setBounds(new Rectangle(448, 363, 97, 23));
        txtLike.setText("");
        txtLike.setBounds(new Rectangle(448, 333, 97, 23));
        txtPhone1.setText("");
        txtPhone1.setBounds(new Rectangle(448, 460, 208, 23));
        txtWork.setText("");
        txtWork.setBounds(new Rectangle(448, 518, 211, 23));
        txtEmail.setFocusAccelerator('h');
        txtEmail.setBounds(new Rectangle(448, 545, 211, 23));
        txtAdd.setText("");
        txtAdd.setBounds(new Rectangle(448, 396, 209, 23));
        cboLeixing.setBounds(new Rectangle(91, 356, 106, 25));
        cboAge.setBounds(new Rectangle(448, 243, 97, 24));
        btnDelete.setBounds(new Rectangle(695, 330, 102, 33));
        btnDelete.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnDelete.setText("ɾ��");
        btnInsert.setBounds(new Rectangle(693, 284, 102, 33));
        btnInsert.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnInsert.setText("����");
        btnUpdate.setBounds(new Rectangle(695, 377, 102, 33));
        btnUpdate.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnUpdate.setText("�޸�");
        btnNew.setBounds(new Rectangle(695, 427, 102, 33));
        btnNew.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnNew.setText("ˢ��");
        btnFind.setBounds(new Rectangle(693, 238, 102, 33));
        btnFind.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnFind.setText("��ѯ");
        txtBei.setBorder(BorderFactory.createEtchedBorder());
        txtBei.setMaximumSize(new Dimension(20, 10));
        txtBei.setText("");
        txtBei.setBounds(new Rectangle(72, 404, 262, 157));
        btnOut.setBounds(new Rectangle(695, 471, 102, 33));
        btnOut.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnOut.setText("�˳�");
        txtZu.setText("");
        txtZu.setBounds(new Rectangle(92, 248, 104, 24));
        jLabel11.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel11.setText("��ͥ�绰��");
        jLabel11.setBounds(new Rectangle(359, 419, 81, 36));
        txtHome.setBounds(new Rectangle(448, 426, 209, 23));
        jLabel12.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15));
        jLabel12.setText("  ��      �գ�");
        jLabel12.setBounds(new Rectangle(354, 265, 88, 36));
        jLabel13.setText("jLabel13");
        jLabel13.setBounds(new Rectangle(0, 0, 40, 16));
        txtB.setBounds(new Rectangle(448, 272, 97, 23));
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(lblName);
        this.getContentPane().add(lblSex);
        this.getContentPane().add(lblzuming);
        this.getContentPane().add(lblClass);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(lblAge);
        this.getContentPane().add(jLabel10);
        this.getContentPane().add(cboLeixing);
        this.getContentPane().add(cboSex);
        this.getContentPane().add(txtName);
        this.getContentPane().add(cboAge);
        this.getContentPane().add(btnInsert);
        this.getContentPane().add(btnUpdate);
        this.getContentPane().add(btnDelete);
        this.getContentPane().add(btnFind);
        this.getContentPane().add(btnNew);
        this.getContentPane().add(txtBei);
        this.getContentPane().add(btnOut);
        this.getContentPane().add(txtZu);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(txtAdd);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jLabel9);
        this.getContentPane().add(jLabel7);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(txtPhone1);
        this.getContentPane().add(txtPhone2);
        this.getContentPane().add(txtWork);
        this.getContentPane().add(txtEmail);
        this.getContentPane().add(jLabel11);
        this.getContentPane().add(txtHome);
        this.getContentPane().add(jLabel13);
        this.getContentPane().add(lblName2);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel8);
        this.getContentPane().add(txtLike);
        this.getContentPane().add(txtName3);
        this.getContentPane().add(jLabel12);
        this.getContentPane().add(txtB);
        this.getContentPane().add(txtName2);
        jScrollPane1.getViewport().add(infoTable);
        cboSex.addItem("��");
        cboSex.addItem("Ů");
        for (int i = 1; i <= 120; i++) { //���������б�� ֵ
            cboAge.addItem(i + "");
        }
        cboLeixing.addItem("׼�û�");
        cboLeixing.addItem("һ���û�");
        cboLeixing.addItem("VIP�û�");
        x.add("���");
        x.add("�ͻ�����");
        x.add("�ͻ�����");
        x.add("����/�ǳ�");
        x.add("�Ա�");
        x.add("��������");
        x.add("����");
        x.add("�ͻ�����");
        x.add("������λ");
        x.add("����/�س�");
        x.add("��ͥסַ");
        x.add("ס���绰");
        x.add("��ϵ�绰��");
        x.add("��ϵ�绰��");
        x.add("�����ʼ�");
        x.add("��ż����");
        x.add("��ע");
        ResultSet rs = main.stmt.executeQuery(
                "select * from Client_form where Avail=1");
        while (rs.next() == true) {
            Vector lin = new Vector();
            lin.add(rs.getInt(1) + "");
            lin.add(rs.getString(2));
            lin.add(rs.getString(3));
            lin.add(rs.getString(4));
            if (rs.getInt(5) == 0) {
                lin.add("��");
            } else {
                lin.add("Ů");
            }
            //lin.add(rs.getInt(5)+"");
            lin.add(rs.getString(6));
            lin.add(rs.getInt(7) + "");
            int leixing = rs.getInt(8);
            if (leixing == 1) {
                lin.add("׼�û�");
            }
            if (leixing == 2) {
                lin.add("һ���û�");
            }
            if (leixing == 3) {
                lin.add("VIP�û�");
            }
            //lin.add(rs.getInt(8)+"");
            lin.add(rs.getString(9));
            lin.add(rs.getString(10));
            lin.add(rs.getString(11));
            lin.add(rs.getString(12));
            lin.add(rs.getString(13));
            lin.add(rs.getString(14));
            lin.add(rs.getString(15));
            lin.add(rs.getString(16));
            lin.add(rs.getString(17));
            y.add(lin);
        }
        model = new DefaultTableModel(y, x);
        infoTable.setModel(model);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    JScrollPane jScrollPane1 = new JScrollPane();
    JTable infoTable = new JTable();
    Vector x = new Vector();
    Vector y = new Vector();
    DefaultTableModel model;
    JLabel lblzuming = new JLabel();
    JLabel lblName = new JLabel();
    JLabel lblSex = new JLabel();
    JLabel lblClass = new JLabel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel lblName2 = new JLabel();
    JLabel lblAge = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JTextField txtName = new JTextField();
    JComboBox cboSex = new JComboBox();
    JTextField txtName2 = new JTextField();
    JTextField txtPhone2 = new JTextField();
    JTextField txtName3 = new JTextField();
    JTextField txtLike = new JTextField();
    JTextField txtPhone1 = new JTextField();
    JTextField txtWork = new JTextField();
    JTextField txtEmail = new JTextField();
    JTextField txtAdd = new JTextField();
    JComboBox cboLeixing = new JComboBox();
    JComboBox cboAge = new JComboBox();
    JButton btnDelete = new JButton();
    JButton btnInsert = new JButton();
    JButton btnUpdate = new JButton();
    JButton btnNew = new JButton();
    JButton btnFind = new JButton();
    JTextArea txtBei = new JTextArea();
    JButton btnOut = new JButton();
    JTextField txtZu = new JTextField();
    JLabel jLabel11 = new JLabel();
    JTextField txtHome = new JTextField();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel13 = new JLabel();
    JTextField txtB = new JTextField();
}
