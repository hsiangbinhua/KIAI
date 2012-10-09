package insurance;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;


public class frmContract extends JFrame {
    ImageIcon yeji = new ImageIcon("image\\yeji.png");
    ImageIcon yeji2 = new ImageIcon("image\\yeji2.png");
    BorderLayout borderLayout1 = new BorderLayout();
    JTabbedPane jTabbedPane1 = new JTabbedPane();
    JPanel pnlContract = new JPanel();
    JPanel pnlTongji = new JPanel();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable table1 = new JTable();
    JLabel lbl1 = new JLabel();
    JTextField txtNo = new JTextField();
    JLabel lblMoney = new JLabel();
    JLabel lblType = new JLabel();
    JLabel lblName = new JLabel();
    JComboBox cboName = new JComboBox();
    JComboBox cboType = new JComboBox();
    JTextField txtMoney = new JTextField();
    JLabel lblEnd = new JLabel();
    JLabel lblStart = new JLabel();
    JTextField txtStart = new JTextField();
    JTextField txtEnd = new JTextField();
    JLabel lblName1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel lblName2 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel lblRemark = new JLabel();
    JTextField txtName1 = new JTextField();
    JTextField txtCard1 = new JTextField();
    JTextField txtName2 = new JTextField();
    JTextField txtCard2 = new JTextField();
    JComboBox cboRelation = new JComboBox();
    JTextArea txtarea = new JTextArea();
    JButton btnAdd = new JButton();
    JButton jButton2 = new JButton();
    JButton btnDelete = new JButton();
    JButton btnFresh = new JButton();
    JLabel lblCount = new JLabel();
    JLabel lblCount2 = new JLabel();
    JLabel lblAlltxt = new JLabel();
    JLabel lblAll = new JLabel();
    JLabel lblMost = new JLabel();
    JLabel lblAvg = new JLabel();
    JLabel lblLow = new JLabel();
    JLabel lblNew = new JLabel();
    JLabel lblMoney2 = new JLabel();
    JLabel lblMoney1 = new JLabel();
    JLabel lblMoney3 = new JLabel();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTable tableNew = new JTable();
    JLabel lblyeji = new JLabel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel4 = new JLabel();
    Vector x = new Vector();
    Vector y = new Vector();
    Vector xNo2 = new Vector();
    Vector yNo2 = new Vector();
    DefaultTableModel model1;
    DefaultTableModel modelnew;
    JComboBox cboZt = new JComboBox();


    public frmContract() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void newTable() { //������
        x.removeAllElements();
        y.removeAllElements();
        try {
            x.add("������");
            x.add("��������");
            x.add("Ͷ��������");
            x.add("Ͷ�������֤");
            x.add("����������");
            x.add("���������֤");
            x.add("��Ͷ���˹�ϵ");
            x.add("״̬");
            x.add("���ѷ�ʽ");
            x.add("���ѱ�׼");
            x.add("��ʼʱ��");
            x.add("��ֹʱ��");
            x.add("��ע");
            ResultSet rsF = main.stmt.executeQuery(
                    "select * from Plicy_form where Avail=1 ");
            while (rsF.next() == true) {
                Vector use = new Vector();
                use.add(rsF.getString(1));
                use.add(rsF.getString(2));
                use.add(rsF.getString(3));
                use.add(rsF.getString(4));
                use.add(rsF.getString(5));
                use.add(rsF.getString(6));
                //use.add(rsF.getInt(7)+"");
                int getR = rsF.getInt(7);
                if (getR == 0) {
                    use.add("��(ĸ)/��(Ů)");
                }
                if (getR == 1) {
                    use.add("�游(ĸ)/����(Ů)");
                }
                if (getR == 2) {
                    use.add("�常(ĸ)/ֶ��(Ů)");
                }
                if (getR == 3) {
                    use.add("�ֵܽ���");
                }
                if (getR == 4) {
                    use.add("����");
                }
                if (getR == 5) {
                    use.add("����");
                }
                use.add(rsF.getString(8));
                //use.add(rsF.getInt(9)+"");
                int getType = rsF.getInt(9);
                if (getType == 0) {
                    use.add("��");
                }
                if (getType == 1) {
                    use.add("��");
                }
                if (getType == 2) {
                    use.add("10��");
                }
                if (getType == 3) {
                    use.add("20��");
                }
                use.add(rsF.getFloat(10) + "");
                use.add(rsF.getString(11));
                use.add(rsF.getString(12));
                use.add(rsF.getString(13));

                y.add(use);
            }
            model1 = new DefaultTableModel(y, x);
            table1.setModel(model1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void shua() { //ˢ�·���
        txtNo.setText("");
        cboName.setSelectedIndex(0);
        cboType.setSelectedIndex(0);
        txtarea.setText("");
        txtCard1.setText("");
        txtCard2.setText("");
        txtEnd.setText("");
        txtName1.setText("");
        txtMoney.setText("");
        txtName2.setText("");
        txtStart.setText("");
        //txtZt.setText("");
        cboZt.setSelectedIndex(0);
        cboRelation.setSelectedIndex(0);
    }

    public void No2() { //�ڶ�ҳ����
        try { //�ڶ��� �ۼƱ�����Ŀ
            ResultSet rsCount = main.stmt.executeQuery(
                    "select count(*) from Plicy_form where Avail=1");
            rsCount.next();
            lblCount2.setText(rsCount.getString(1));
            //�ۼƱ��ս��
            ResultSet rsAll = main.stmt.executeQuery(
                    "select Pay_Stadard from Plicy_form where Avail=1");
            float All = 0;
            while (rsAll.next()) {
                All += rsAll.getFloat(1);
            }
            lblAll.setText(All + "");
            //��߱��ս��
            ResultSet rsMax = main.stmt.executeQuery(
                    "select max(Pay_Stadard) from Plicy_form where Avail=1");
            rsMax.next();
            lblMoney1.setText(rsMax.getString(1));
            //��ͱ��ս��
            ResultSet rsMin = main.stmt.executeQuery(
                    "select min(Pay_Stadard) from Plicy_form where Avail=1");
            rsMin.next();
            lblMoney2.setText(rsMin.getString(1));
            //ƽ�����ս��
            ResultSet rsAvg = main.stmt.executeQuery(
                    "select Avg(Pay_Stadard) from Plicy_form where Avail=1");
            rsAvg.next();
            lblMoney3.setText(rsAvg.getString(1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void newTable2() { //�ڶ�ҳ���
        xNo2.removeAllElements();
        yNo2.removeAllElements();
        xNo2.add("������");
        xNo2.add("��������");
        xNo2.add("Ͷ��������");
        xNo2.add("Ͷ�������֤");
        xNo2.add("����������");
        xNo2.add("���������֤");
        xNo2.add("��Ͷ���˹�ϵ");
        xNo2.add("״̬");
        xNo2.add("���ѷ�ʽ");
        xNo2.add("���ѱ�׼");
        xNo2.add("��ʼʱ��");
        xNo2.add("��ֹʱ��");
        xNo2.add("��ע");
        try {
            ResultSet rsNo2 = main.stmt.executeQuery(
                    "select top 5 * from Plicy_form where Avail=1 order by ForDate desc");
            while (rsNo2.next()) {
                Vector use = new Vector();
                use.add(rsNo2.getString(1));
                use.add(rsNo2.getString(2));
                use.add(rsNo2.getString(3));
                use.add(rsNo2.getString(4));
                use.add(rsNo2.getString(5));
                use.add(rsNo2.getString(6));
                //use.add(rsF.getInt(7)+"");
                int getR = rsNo2.getInt(7);
                if (getR == 0) {
                    use.add("��(ĸ)/��(Ů)");
                }
                if (getR == 1) {
                    use.add("�游(ĸ)/����(Ů)");
                }
                if (getR == 2) {
                    use.add("�常(ĸ)/ֶ��(Ů)");
                }
                if (getR == 3) {
                    use.add("�ֵܽ���");
                }
                if (getR == 4) {
                    use.add("����");
                }
                if (getR == 5) {
                    use.add("����");
                }
                use.add(rsNo2.getString(8));
                //use.add(rsF.getInt(9)+"");
                int getType = rsNo2.getInt(9);
                if (getType == 0) {
                    use.add("��");
                }
                if (getType == 1) {
                    use.add("��");
                }
                if (getType == 2) {
                    use.add("10��");
                }
                if (getType == 3) {
                    use.add("20��");
                }
                use.add(rsNo2.getFloat(10) + "");
                use.add(rsNo2.getString(11));
                use.add(rsNo2.getString(12));
                use.add(rsNo2.getString(13));

                yNo2.add(use);
            }
            modelnew = new DefaultTableModel(yNo2, xNo2);
            tableNew.setModel(modelnew);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //�ر��Զ�ƽ��
        tableNew.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //�ر��Զ�ƽ��
        getContentPane().setLayout(borderLayout1);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        newTable2();
        this.setTitle("���������ҵ��ͳ��");
        pnlContract.setLayout(null);
        pnlTongji.setLayout(null);
        jScrollPane1.setBounds(new Rectangle(0, 0, 800, 260));
        lbl1.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lbl1.setForeground(Color.blue);
        lbl1.setText("�� �� ��:");
        lbl1.setBounds(new Rectangle(11, 280, 80, 30));
        txtNo.setText("");
        txtNo.setBounds(new Rectangle(100, 282, 245, 27));
        lblMoney.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lblMoney.setForeground(Color.blue);
        lblMoney.setText("�ɷѱ�׼:");
        lblMoney.setBounds(new Rectangle(14, 414, 80, 30));
        lblType.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lblType.setForeground(Color.blue);
        lblType.setText("�ɷѷ�ʽ:");
        lblType.setBounds(new Rectangle(11, 379, 80, 30));
        lblName.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lblName.setForeground(Color.blue);
        lblName.setText("�������ƣ�");
        lblName.setBounds(new Rectangle(9, 324, 81, 32));
        cboName.setBounds(new Rectangle(101, 330, 243, 27));
        cboType.setBounds(new Rectangle(99, 378, 121, 28));
        txtMoney.setText("");
        txtMoney.setBounds(new Rectangle(99, 416, 122, 22));
        lblEnd.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lblEnd.setForeground(Color.blue);
        lblEnd.setText("��ֹʱ�䣺");
        lblEnd.setBounds(new Rectangle(11, 478, 80, 28));
        lblStart.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lblStart.setForeground(Color.blue);
        lblStart.setText("��ʼʱ�䣺");
        lblStart.setBounds(new Rectangle(11, 449, 80, 28));
        txtStart.setText("");
        txtStart.setBounds(new Rectangle(99, 448, 122, 26));
        txtEnd.setText("");
        txtEnd.setBounds(new Rectangle(100, 479, 121, 28));
        lblName1.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lblName1.setForeground(Color.blue);
        lblName1.setText("Ͷ �� �� �� ����");
        lblName1.setBounds(new Rectangle(412, 289, 136, 27));
        jLabel2.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        jLabel2.setForeground(Color.blue);
        jLabel2.setText("Ͷ�������֤�ţ�");
        jLabel2.setBounds(new Rectangle(419, 359, 129, 29));
        jLabel3.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        jLabel3.setForeground(Color.blue);
        jLabel3.setText("������������ ��");
        jLabel3.setBounds(new Rectangle(419, 324, 128, 24));
        lblName2.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        lblName2.setForeground(Color.blue);
        lblName2.setText("�����������֤�ţ�");
        lblName2.setBounds(new Rectangle(408, 402, 150, 26));
        jLabel5.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        jLabel5.setForeground(Color.blue);
        jLabel5.setText("�� Ͷ �� �� �� ϵ��");
        jLabel5.setBounds(new Rectangle(404, 447, 153, 24));
        lblRemark.setFont(new java.awt.Font("����", Font.PLAIN, 17));
        lblRemark.setForeground(Color.blue);
        lblRemark.setText("��      ע��");
        lblRemark.setBounds(new Rectangle(420, 498, 121, 25));
        txtName1.setText("");
        txtName1.setBounds(new Rectangle(564, 285, 113, 28));
        txtCard1.setBounds(new Rectangle(565, 361, 212, 27));
        txtName2.setBounds(new Rectangle(565, 325, 113, 28));
        txtCard2.setBounds(new Rectangle(565, 403, 213, 28));
        cboRelation.setBounds(new Rectangle(567, 445, 212, 31));
        txtarea.setBorder(BorderFactory.createEtchedBorder());
        txtarea.setText("");
        txtarea.setBounds(new Rectangle(565, 487, 216, 43));
        btnAdd.setBounds(new Rectangle(283, 380, 71, 30));
        btnAdd.setFont(new java.awt.Font("����", Font.PLAIN, 18));
        btnAdd.setText("����");
        jButton2.setBounds(new Rectangle(281, 454, 70, 34));
        jButton2.setFont(new java.awt.Font("����", Font.PLAIN, 18));
        jButton2.setText("�޸�");
        btnDelete.setBounds(new Rectangle(281, 494, 72, 31));
        btnDelete.setFont(new java.awt.Font("����", Font.PLAIN, 18));
        btnDelete.setText("ɾ��");
        btnFresh.setBounds(new Rectangle(282, 416, 71, 30));
        btnFresh.setFont(new java.awt.Font("����", Font.PLAIN, 18));
        btnFresh.setText("ˢ��");
        lblCount.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblCount.setForeground(Color.magenta);
        lblCount.setText("�ۼƱ���������");
        lblCount.setBounds(new Rectangle(8, 16, 148, 35));
        lblCount2.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblCount2.setForeground(Color.magenta);
        lblCount2.setBorder(BorderFactory.createEtchedBorder());
        lblCount2.setText("");
        lblCount2.setBounds(new Rectangle(166, 17, 120, 31));
        lblAlltxt.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblAlltxt.setForeground(Color.magenta);
        lblAlltxt.setText("�ۼƱ��ս�");
        lblAlltxt.setBounds(new Rectangle(315, 13, 148, 35));
        lblAll.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblAll.setForeground(Color.magenta);
        lblAll.setBorder(BorderFactory.createEtchedBorder());
        lblAll.setBounds(new Rectangle(476, 16, 120, 31));
        lblMost.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblMost.setForeground(Color.magenta);
        lblMost.setText("��߱��");
        lblMost.setBounds(new Rectangle(11, 74, 101, 35));
        lblAvg.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblAvg.setForeground(Color.magenta);
        lblAvg.setText("ƽ�����");
        lblAvg.setBounds(new Rectangle(260, 74, 100, 35));
        lblLow.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblLow.setForeground(Color.magenta);
        lblLow.setText("��ͱ��");
        lblLow.setBounds(new Rectangle(552, 75, 105, 32));
        lblNew.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblNew.setForeground(Color.blue);

        lblNew.setText("�� �� ҵ ����");
        lblNew.setBounds(new Rectangle(34, 128, 145, 32));
        lblMoney2.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblMoney2.setForeground(Color.magenta);
        lblMoney2.setBorder(BorderFactory.createEtchedBorder());
        lblMoney2.setText("");
        lblMoney2.setBounds(new Rectangle(665, 78, 120, 31));
        lblMoney1.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblMoney1.setForeground(Color.magenta);
        lblMoney1.setBorder(BorderFactory.createEtchedBorder());
        lblMoney1.setText("");
        lblMoney1.setBounds(new Rectangle(121, 77, 120, 31));
        lblMoney3.setFont(new java.awt.Font("����", Font.PLAIN, 20));
        lblMoney3.setForeground(Color.magenta);
        lblMoney3.setBorder(BorderFactory.createEtchedBorder());
        lblMoney3.setText("");
        lblMoney3.setBounds(new Rectangle(360, 76, 152, 31));
        jScrollPane2.setBounds(new Rectangle(0, 188, 795, 205));
        lblyeji.setBorder(null);
        lblyeji.setIcon(yeji);
        lblyeji.setLabelFor(pnlTongji);
        lblyeji.setText("");
        lblyeji.setBounds(new Rectangle(151, 405, 184, 130));
        jLabel1.setIcon(yeji2);
        jLabel1.setLabelFor(pnlTongji);
        jLabel1.setBounds(new Rectangle(419, 401, 184, 130));
        jLabel4.setFont(new java.awt.Font("����", Font.PLAIN, 16));
        jLabel4.setForeground(Color.blue);
        jLabel4.setText("״    ̬��");
        jLabel4.setBounds(new Rectangle(12, 513, 80, 28));
        cboZt.setBounds(new Rectangle(100, 513, 122, 26));
        pnlContract.add(jScrollPane1);
        pnlContract.add(txtNo);
        pnlContract.add(lbl1);
        pnlContract.add(lblName);
        pnlContract.add(cboName);
        pnlContract.add(lblType);
        pnlContract.add(cboType);
        pnlContract.add(lblName2);
        pnlContract.add(jLabel5);
        pnlContract.add(cboRelation);
        pnlContract.add(txtCard2);
        pnlContract.add(txtarea);
        pnlContract.add(txtCard1);
        pnlContract.add(txtName2);
        pnlContract.add(txtName1);
        pnlContract.add(jLabel3);
        pnlContract.add(lblName1);
        pnlContract.add(jLabel2);
        pnlContract.add(lblMoney);
        pnlContract.add(txtMoney);
        pnlContract.add(lblStart);
        pnlContract.add(txtStart);
        pnlContract.add(txtEnd);
        pnlContract.add(jLabel4);
        pnlContract.add(lblEnd);
        pnlContract.add(btnDelete);
        pnlContract.add(jButton2);
        pnlContract.add(btnFresh);
        pnlContract.add(btnAdd);
        pnlContract.add(lblRemark);
        pnlContract.add(cboZt);
        jScrollPane1.getViewport().add(table1);

        pnlTongji.add(lblAlltxt);
        pnlTongji.add(lblAll);
        pnlTongji.add(lblCount2);
        pnlTongji.add(lblMost);
        pnlTongji.add(lblCount);
        pnlTongji.add(lblMoney1);
        pnlTongji.add(lblLow);
        pnlTongji.add(lblMoney2);
        pnlTongji.add(lblNew);
        pnlTongji.add(jScrollPane2);
        pnlTongji.add(lblyeji);
        pnlTongji.add(jLabel1);
        pnlTongji.add(lblAvg);
        pnlTongji.add(lblMoney3);
        jScrollPane2.getViewport().add(tableNew);

        jTabbedPane1.add(pnlTongji, " ��ҵ  ��  ͳ  �� ");
        this.getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.add(pnlContract, "@������Ϣ����");
        try { //�ڶ��� �ۼƱ�����Ŀ
            ResultSet rsCount = main.stmt.executeQuery(
                    "select count(*) from Plicy_form where Avail=1");
            rsCount.next();
            lblCount2.setText(rsCount.getString(1));
            //�ۼƱ��ս��
            ResultSet rsAll = main.stmt.executeQuery(
                    "select Pay_Stadard from Plicy_form where Avail=1");
            float All = 0;
            while (rsAll.next()) {
                All += rsAll.getFloat(1);
            }
            lblAll.setText(All + "");
            //��߱��ս��
            ResultSet rsMax = main.stmt.executeQuery(
                    "select max(Pay_Stadard) from Plicy_form where Avail=1");
            rsMax.next();
            lblMoney1.setText(rsMax.getString(1));
            //��ͱ��ս��
            ResultSet rsMin = main.stmt.executeQuery(
                    "select min(Pay_Stadard) from Plicy_form where Avail=1");
            rsMin.next();
            lblMoney2.setText(rsMin.getString(1));
            //ƽ�����ս��
            ResultSet rsAvg = main.stmt.executeQuery(
                    "select Avg(Pay_Stadard) from Plicy_form where Avail=1");
            rsAvg.next();
            lblMoney3.setText(rsAvg.getString(1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            x.add("������");
            x.add("��������");
            x.add("Ͷ��������");
            x.add("Ͷ�������֤");
            x.add("����������");
            x.add("���������֤");
            x.add("��Ͷ���˹�ϵ");
            x.add("״̬");
            x.add("���ѷ�ʽ");
            x.add("���ѱ�׼");
            x.add("��ʼʱ��");
            x.add("��ֹʱ��");
            x.add("��ע");
            ResultSet rsF = main.stmt.executeQuery(
                    "select * from Plicy_form where Avail=1 ");
            while (rsF.next() == true) {
                Vector use = new Vector();
                use.add(rsF.getString(1));
                use.add(rsF.getString(2));
                use.add(rsF.getString(3));
                use.add(rsF.getString(4));
                use.add(rsF.getString(5));
                use.add(rsF.getString(6));
                //use.add(rsF.getInt(7)+"");
                int getR = rsF.getInt(7);
                if (getR == 0) {
                    use.add("��(ĸ)/��(Ů)");
                }
                if (getR == 1) {
                    use.add("�游(ĸ)/����(Ů)");
                }
                if (getR == 2) {
                    use.add("�常(ĸ)/ֶ��(Ů)");
                }
                if (getR == 3) {
                    use.add("�ֵܽ���");
                }
                if (getR == 4) {
                    use.add("����");
                }
                if (getR == 5) {
                    use.add("����");
                }
                use.add(rsF.getString(8));
                //use.add(rsF.getInt(9)+"");
                int getType = rsF.getInt(9);
                if (getType == 0) {
                    use.add("��");
                }
                if (getType == 1) {
                    use.add("��");
                }
                if (getType == 2) {
                    use.add("10��");
                }
                if (getType == 3) {
                    use.add("20��");
                }
                use.add(rsF.getFloat(10) + "");
                use.add(rsF.getString(11));
                use.add(rsF.getString(12));
                use.add(rsF.getString(13));

                y.add(use);
            }
            model1 = new DefaultTableModel(y, x);
            table1.setModel(model1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        cboName.addItem("̫ƽ���⿨");
        cboName.addItem("̫ƽ���鿨");
        cboName.addItem("̫ƽ˳�⿨");
        cboName.addItem("����סԺ����");
        cboName.addItem("����סԺ����");
        cboName.addItem("���Ӹ��������˺�ҽ��");
        cboName.addItem("����סԺҽ��");
        cboName.addItem("����סԺҽ�Ʋ���");
        cboName.addItem("�������������˺�_98");
        cboName.addItem("�������껤���");
        cboName.addItem("���ӻ�޽�");
        cboName.addItem("��������סԺ����ҽ��");

        cboType.addItem("��");
        cboType.addItem("��");
        cboType.addItem("10��");
        cboType.addItem("20��");

        cboRelation.addItem("��(ĸ)/��(Ů)");
        cboRelation.addItem("�游(ĸ)/����(Ů)");
        cboRelation.addItem("�常(ĸ)/ֶ��(Ů)");
        cboRelation.addItem("�ֵܽ���");
        cboRelation.addItem("����");
        cboRelation.addItem("����");

        cboZt.addItem("��Ч");
        cboZt.addItem("��Ч");
        btnAdd.addActionListener(new ActionListener() { //���Ӱ�ť
            public void actionPerformed(ActionEvent e) {
                if (txtNo.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "�����ű������룡");
                    return;
                }
                if (txtNo.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "�����ų��Ȳ��ܳ���20�ֽڣ�");
                    return;
                }
                if (txtName1.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Ͷ���������������룡");
                    return;
                }
                if (txtName1.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "Ͷ�����������ܳ���20�ֽڣ�");
                    return;
                }
                if (txtName2.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "�����������������룡");
                    return;
                }
                if (txtName2.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "�������������ܳ���20�ֽڣ�");
                    return;
                }
                if (txtMoney.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "���ѱ�׼�������룡");
                    return;
                }
                String get = txtMoney.getText();
                if (get.matches("[0-9]*") == false) {
                    JOptionPane.showMessageDialog(null, "���ѱ�׼����Ϊ������");
                    return;
                }
                if (txtStart.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "��ʼʱ��������룡");
                    return;
                }
                if (txtStart.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ʼʱ�䲻�ܳ���20�ֽڣ�");
                    return;
                }
                if (txtEnd.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "��ֹʱ��������룡");
                    return;
                }
                if (txtEnd.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "��ֹʱ�䲻�ܳ���20�ֽڣ�");
                    return;
                }
//                if(txtZt.getText().length()==0)
//                {
//                    JOptionPane.showMessageDialog(null,"״̬�������룡");
//                    return;
//                }
//                if(txtZt.getText().length()>20)
//                {
//                    JOptionPane.showMessageDialog(null,"״̬���ܳ���20�ֽڣ�");
//                    return;
//                }
                if (txtCard2.getText().length() != 0) {
                    String Card = txtCard2.getText();
                    if (Card.matches("[0-9]*") == false ||
                        txtCard2.getText().length() != 18) {
                        JOptionPane.showMessageDialog(null, "���������֤�Ų��Ϸ���");
                        return;
                    }
                }
                if (txtCard1.getText().length() != 0) {
                    String Card = txtCard1.getText();
                    if (Card.matches("[0-9]*") == false ||
                        txtCard1.getText().length() != 18) {
                        JOptionPane.showMessageDialog(null, "Ͷ�������֤�Ų��Ϸ���");
                        return;
                    }
                }
                try {
                    ResultSet rs = main.stmt.executeQuery(
                            "select * from Plicy_form where Plicy_No='" +
                            txtNo.getText() + "' and Avail=1");
                    if (rs.next() == true) {
                        JOptionPane.showMessageDialog(null, "�Ѿ����ڸñ�����");
                        return;
                    }
                    main.stmt.execute("insert into Plicy_form  values('" +
                                      txtNo.getText() + "','" +
                                      cboName.getSelectedItem() + "','" +
                                      txtName1.getText() + "','" +
                                      txtCard1.getText() + "','" +
                                      txtName2.getText() + "','" +
                                      txtCard2.getText() + "'," +
                                      cboRelation.getSelectedIndex() + ",'" +
                                      cboZt.getSelectedItem() + "'," +
                                      cboType.getSelectedIndex() + "," +
                                      txtMoney.getText() + ",'" +
                                      txtStart.getText() + "','" +
                                      txtEnd.getText() + "','" +
                                      txtarea.getText() + "',1)");
                    JOptionPane.showMessageDialog(null, "���ӳɹ���");
                    newTable(); //��������
                    shua(); //����ˢ�º���
                    No2(); //����No2����
                    newTable2(); //���÷��� ���ڸ��µڶ�ҳ���
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() { //ɾ����ť
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtNo.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "�����ű������룡");
                        return;
                    }
                    ResultSet rs = main.stmt.executeQuery(
                            "select * from Plicy_form where Plicy_No='" +
                            txtNo.getText() + "'and Avail=1");
                    if (rs.next() == false) {
                        JOptionPane.showMessageDialog(null, "�����ڸñ�����");
                        return;
                    }
                    int yn = JOptionPane.showConfirmDialog(null, "�Ƿ����Ҫɾ�������ݣ�",
                            "��ܰ��ʾ", 2);
                    if (yn == 0) { /////////////////////////////////////////////////©������
                        main.stmt.execute(
                                "update Plicy_form set Avail=0 where Plicy_No ='" +
                                txtNo.getText() + "'");
                        JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
                        newTable(); //���ú���
                        shua(); //����ˢ�º���
                        No2(); //����No2����
                        newTable2(); //���÷��� ���ڸ��µڶ�ҳ���
                    } else {
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jButton2.addActionListener(new ActionListener() { //�޸İ�ť
            public void actionPerformed(ActionEvent e) {
                if (txtNo.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "�����ű������룡");
                    return;
                }
                if (txtNo.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "�����ų��Ȳ��ܳ���20�ֽڣ�");
                    return;
                }
                try {
                    ResultSet rs = main.stmt.executeQuery(
                            "select * from Plicy_form where Plicy_No='" +
                            txtNo.getText() + "'and Avail=1");
                    if (rs.next() == false) {
                        JOptionPane.showMessageDialog(null, "�������ڸñ�����");
                        return;
                    }
                    if (txtName1.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Ͷ���������������룡");
                        return;
                    }
                    if (txtName1.getText().length() > 20) {
                        JOptionPane.showMessageDialog(null, "Ͷ�����������ܳ���20�ֽڣ�");
                        return;
                    }
                    if (txtName2.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "�����������������룡");
                        return;
                    }
                    if (txtName2.getText().length() > 20) {
                        JOptionPane.showMessageDialog(null, "�������������ܳ���20�ֽڣ�");
                        return;
                    }
                    if (txtMoney.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "���ѱ�׼�������룡");
                        return;
                    }
                    String get = txtMoney.getText();
                    if (get.matches("[0-9]*") == false) {
                        JOptionPane.showMessageDialog(null, "���ѱ�׼����Ϊ������");
                        return;
                    }
                    if (txtStart.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "��ʼʱ��������룡");
                        return;
                    }
                    if (txtStart.getText().length() > 20) {
                        JOptionPane.showMessageDialog(null, "��ʼʱ�䲻�ܳ���20�ֽڣ�");
                        return;
                    }
                    if (txtEnd.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "��ֹʱ��������룡");
                        return;
                    }
                    if (txtEnd.getText().length() > 20) {
                        JOptionPane.showMessageDialog(null, "��ֹʱ�䲻�ܳ���20�ֽڣ�");
                        return;
                    }
//                if(txtZt.getText().length()==0)
//                {
//                    JOptionPane.showMessageDialog(null,"״̬�������룡");
//                    return;
//                }
//                if(txtZt.getText().length()>20)
//                {
//                    JOptionPane.showMessageDialog(null,"״̬���ܳ���20�ֽڣ�");
//                    return;
//                }
                    if (txtCard2.getText().length() != 0) {
                        String Card = txtCard2.getText();
                        if (Card.matches("[0-9]*") == false ||
                            txtCard2.getText().length() != 18) {
                            JOptionPane.showMessageDialog(null, "���������֤�Ų��Ϸ���");
                            return;
                        }
                    }
                    if (txtCard1.getText().length() != 0) {
                        String Card = txtCard1.getText();
                        if (Card.matches("[0-9]*") == false ||
                            txtCard1.getText().length() != 18) {
                            JOptionPane.showMessageDialog(null, "Ͷ�������֤�Ų��Ϸ���");
                            return;
                        }
                    }

                    int yn = JOptionPane.showConfirmDialog(null, "�Ƿ����Ҫ�޸ĸ����ݣ�",
                            "��ܰ��ʾ", 2);
                    if (yn == 0) {
                        main.stmt.execute("update Plicy_form set Plicy_No='" +
                                          txtNo.getText() + "',Plicy_Name='" +
                                          cboName.getSelectedItem() +
                                          "',Holder_Name='" + txtName1.getText() +
                                          "',HCard_Id='" + txtCard1.getText() +
                                          "',Insurant_Name='" +
                                          txtName2.getText() + "',ICard_Id='" +
                                          txtCard2.getText() + "',Relation=" +
                                          cboRelation.getSelectedIndex() +
                                          ",State='" + cboZt.getSelectedItem() +
                                          "',Pay_Type=" +
                                          cboType.getSelectedIndex() +
                                          ",Pay_Stadard=" + txtMoney.getText() +
                                          ",Start_Time='" + txtStart.getText() +
                                          "',End_Time='" + txtEnd.getText() +
                                          "',Remark='" + txtarea.getText() +
                                          "' where Plicy_No='" + txtNo.getText() +
                                          "'");
                        JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
                        newTable(); //���ú���
                        shua(); //����ˢ�º���
                        No2(); //����No2����
                        newTable2(); //���÷��� ���ڸ��µڶ�ҳ���
                    } else {
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnFresh.addActionListener(new ActionListener() { //ˢ�°�ť
            public void actionPerformed(ActionEvent e) {
                txtNo.setText("");
                cboName.setSelectedIndex(0);
                cboType.setSelectedIndex(0);
                txtarea.setText("");
                txtCard1.setText("");
                txtCard2.setText("");
                txtEnd.setText("");
                txtName1.setText("");
                txtMoney.setText("");
                txtName2.setText("");
                txtStart.setText("");
                //txtZt.setText("");
                cboZt.setSelectedIndex(0);
                cboRelation.setSelectedIndex(0);
                No2(); //����No2����
                newTable2(); //���÷��� ���ڸ��µڶ�ҳ���
            }
        });
        table1.addMouseListener(new MouseAdapter() { //��񵥻�
            public void mousePressed(MouseEvent e) {
                try {
                    ResultSet rsTable = main.stmt.executeQuery(
                            "select * from Plicy_form where Avail=1");
                    for (int i = 0; i <= table1.getSelectedRow(); i++) {
                        rsTable.next();
                    }
                    txtNo.setText(rsTable.getString(1));
                    cboName.setSelectedItem(rsTable.getString(2));
                    txtName1.setText(rsTable.getString(3));
                    txtCard1.setText(rsTable.getString(4));
                    txtName2.setText(rsTable.getString(5));
                    txtCard2.setText(rsTable.getString(6));
                    cboRelation.setSelectedIndex(rsTable.getInt(7));
                    //txtZt.setText(rsTable.getString(8));
                    cboZt.setSelectedItem(rsTable.getString(8));
                    cboType.setSelectedIndex(rsTable.getInt(9));
                    txtMoney.setText(rsTable.getFloat(10) + "");
                    txtStart.setText(rsTable.getString(11));
                    txtEnd.setText(rsTable.getString(12));
                    txtarea.setText(rsTable.getString(13));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
