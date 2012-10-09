package insurance;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Vector;
import javax.swing.table.*;
import java.sql.ResultSet;
import java.sql.*;

public class frmGo extends JFrame {
    public frmGo() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    //��������¼�
    public void tableGo() {
        try {
            //�����ͷ
            vcols.add("�ݷö���");
            vcols.add("��ϵ��ʽ");
            vcols.add("��ʼʱ��");
            vcols.add("����ʱ��");
            vcols.add("��ɽ��");
            ResultSet rs = main.stmt.executeQuery(
                    "select * from GoWhere_form where Avail=1");
            while (rs.next()) {
                vrows.add(rs.getString(1));
                vrows.add(rs.getString(2));
                vrows.add(rs.getString(3));
                vrows.add(rs.getString(4));
                vrows.add(vcols); //��vcols��vrows���
            }
            dtm = new DefaultTableModel(vrows, vcols);
            tableInfo.setModel(dtm);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void jbInit() throws Exception {
        this.setTitle("�г̰ݷù滮");

        sp.getViewport().add(tableInfo);
        tableGo() ;

        //�˳�
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmGo.this.dispose();
            }
        });
        getContentPane().setLayout(null);
        btnSave.setBounds(new Rectangle(411, 411, 70, 29));
        btnSave.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        btnSave.setText("����");
        btnAdd.setBounds(new Rectangle(253, 409, 67, 30));
        btnAdd.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        btnAdd.setText("����");
        btnFresh.setBounds(new Rectangle(492, 409, 67, 31));
        btnFresh.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        btnFresh.setText("ˢ��");
        btnExit.setBounds(new Rectangle(610, 409, 68, 30));
        btnExit.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        btnExit.setText("�˳�");
        btnDelete.setBounds(new Rectangle(332, 410, 71, 30));
        btnDelete.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        btnDelete.setText("ɾ��");
        cmbYear.setFont(new java.awt.Font("Dialog", Font.PLAIN, 10));
        cmbMonth.setFont(new java.awt.Font("Dialog", Font.PLAIN, 10));
        cmbYear.setBounds(new Rectangle(12, 411, 57, 25));
        cmbMonth.setBounds(new Rectangle(85, 412, 43, 25));
        cmbDay.setBounds(new Rectangle(143, 412, 50, 25));
        jLabel1.setText(
                "                     ��                 ��                ��");
        jLabel1.setBounds(new Rectangle(5, 404, 204, 41));
        jLabel2.setBackground(Color.yellow);
        jLabel2.setForeground(Color.white);
        jLabel2.setBorder(BorderFactory.createRaisedBevelBorder());

        jLabel2.setDisplayedMnemonic('0');
        jLabel2.setBounds(new Rectangle(8, 403, 720, 44));
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(cmbYear);
        this.getContentPane().add(cmbMonth);
        this.getContentPane().add(cmbDay);
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(btnDelete);
        this.getContentPane().add(btnSave);
        this.getContentPane().add(btnFresh);
        this.getContentPane().add(btnExit);
        this.getContentPane().add(sp);
        sp.getViewport().add(tableInfo);
        cmbYear.addItem("2000");
        cmbYear.addItem("2001");
        cmbYear.addItem("2002");
        cmbYear.addItem("2003");
        cmbYear.addItem("2004");
        cmbYear.addItem("2005");
        cmbYear.addItem("2006");
        cmbYear.addItem("2007");
        cmbYear.addItem("2008");
        cmbYear.addItem("2009");
        cmbYear.addItem("2010");
        cmbYear.addItem("2011");
        cmbYear.addItem("2012");
        cmbYear.addItem("2013");
        cmbYear.addItem("2014");

        cmbMonth.addItem("1");
        cmbMonth.addItem("2");
        cmbMonth.addItem("3");
        cmbMonth.addItem("4");
        cmbMonth.addItem("5");
        cmbMonth.addItem("6");
        cmbMonth.addItem("7");
        cmbMonth.addItem("8");
        cmbMonth.addItem("9");
        cmbMonth.addItem("10");
        cmbMonth.addItem("11");
        cmbMonth.addItem("12");

        cmbDay.addItem("1");
        cmbDay.addItem("2");
        cmbDay.addItem("3");
        cmbDay.addItem("4");
        cmbDay.addItem("5");
        cmbDay.addItem("6");
        cmbDay.addItem("7");
        cmbDay.addItem("8");
        cmbDay.addItem("9");
        cmbDay.addItem("10");
        cmbDay.addItem("11");
        cmbDay.addItem("12");
        cmbDay.addItem("13");
        cmbDay.addItem("14");
        cmbDay.addItem("15");
        cmbDay.addItem("16");
        cmbDay.addItem("17");
        cmbDay.addItem("18");
        cmbDay.addItem("19");
        cmbDay.addItem("20");
        cmbDay.addItem("21");
        cmbDay.addItem("22");
        cmbDay.addItem("23");
        cmbDay.addItem("24");
        cmbDay.addItem("25");
        cmbDay.addItem("26");
        cmbDay.addItem("27");
        cmbDay.addItem("28");
        cmbDay.addItem("29");
        cmbDay.addItem("30");
        cmbDay.addItem("31");
        sp.setBorder(BorderFactory.createLoweredBevelBorder());
        sp.setBounds(new Rectangle(0, 0, 700, 340));
    }

    Vector vcols = new Vector(); //���ڴ洢��ͷ��Ϣ
    Vector vrows = new Vector(); //���ڴ洢������
    DefaultTableModel dtm; //������һ�����ģ�Ͷ���

    JScrollPane sp = new JScrollPane();
    JTable tableInfo = new JTable();
    JButton btnAdd = new JButton();
    JButton btnSave = new JButton();
    JButton btnFresh = new JButton();
    JButton btnDelete = new JButton();
    JButton btnExit = new JButton();
    JComboBox cmbYear = new JComboBox();
    JComboBox cmbMonth = new JComboBox();
    JComboBox cmbDay = new JComboBox();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();

}
