package insurance;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class frmDataCenter extends JFrame {
    public frmDataCenter() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

///88888888888888*******Client**********************////
   public void clientinfo() { //�����º���
       Vector x = new Vector();
       Vector y = new Vector();
       DefaultTableModel model;

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
                   "select * from Client_form where Avail=0");
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
           tableInfo.setModel(model);

       } catch (Exception ex) {
           ex.printStackTrace();
       }
   }


    //��ʾ��ɾ���ͻ��ķ���
    public void Client() {
        clientinfo();
    }

////--------------------------------------------------------------------------
    //-------------------------------------------------------
    //Contract

    public void ContractInfo() {
        Vector x = new Vector();
        Vector y = new Vector();
        Vector xNo2 = new Vector();
        Vector yNo2 = new Vector();
        DefaultTableModel model1;
        DefaultTableModel modelnew;
        ResultSet rsF;

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
            rsF = main.stmt.executeQuery(
                    "select * from Plicy_form where Avail=0 ");
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
            tableInfo.setModel(model1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Contract() {
        ContractInfo();
    }

    /////////////////------------------------------------------------------
///////////////-------------------��Ʒ
    public void productInfo() {
        Vector Productx = new Vector();
        Vector Producty = new Vector();
        DefaultTableModel dtm;
        DefaultTableModel dtmt;

        Productx.add("��Ʒ����");
        Productx.add("��Ʒ����");
        Productx.add("���ѷ�ʽ");
        Productx.add("��������");
        Productx.add("��������");
        Productx.add("��ע");

        String str =
                "select * from InsureInfo where Avail=0 order by InsureID";
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
        tableInfo.setModel(dtm);
    }


    public void Product() {
        productInfo();
    }


///////////////-------------------��Ʒ



    /*-----==================��   ��=======================-----*/
    public void teamInfo() {
        DefaultTableModel dtm;
        Vector Teamx = new Vector();
        Vector Teamy = new Vector();
        Vector my = new Vector();
        dtm = new DefaultTableModel(Teamy, Teamx);
        tableInfo.setModel(dtm);
        Teamx.add("����");
        Teamx.add("Ա������");
        Teamx.add("ְ ��");
        Teamx.add("����");
        Teamx.add("����");
        Teamx.add("����״��");
        Teamx.add("ѧ��");
        Teamx.add("��˾ǰְҵ");
        Teamx.add("��˾ʱ��");
        Teamx.add("�س�");
        Teamx.add(" ס���绰");
        Teamx.add("�ƶ��绰1");
        Teamx.add("�ƶ��绰2");
        Teamx.add("QQ��");
        Teamx.add("EMail��ַ");
        Teamx.add("��ע");

        String str = "select * from Team_form where Avail=0 order by Team_Name";
        try {
            ResultSet rs = main.stmt.executeQuery(str);
            ResultSetMetaData rsmd = rs.getMetaData(); // ������ݿ���ԭ��
            int count = rsmd.getColumnCount(); //ȡ�ñ��е��е�����
            while (rs.next()) {
                Vector v = new Vector(); //����ĵ�һ�����ݶ���ʵ��
                for (int i = 1; i <= count; i++) {
                    v.add(rs.getObject(i).toString()); //ͨ��ѭ������һ�е�ֵ��ӵ��ж�����ȥ
                }
                Teamy.add(v); //��ÿһ�еĶ�����ӵ��������ȥ
            }
            my = (Vector) Teamy.clone();
            dtm = new DefaultTableModel(Teamy, Teamx);
            tableInfo.setModel(dtm);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Team() {
        teamInfo();
    }

    /*-----==================��   ��=======================-----*/
    //������������������������������������������������
    private void jbInit() throws Exception {
        //�һ�ɾ��������
        lblGo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (rdoClient.isSelected()) {
                    Client();
                }
                if (rdoContract.isSelected()) {
                    ContractInfo();
                }
                if (rdoProduct.isSelected()) {
                    Product();
                }
                if (rdoTeam.isSelected()) {
                    Team();
                }
            }
        });


        getContentPane().setLayout(null);
        this.setTitle("���ݴ�������");
        rdoClient.setFont(new java.awt.Font("����", Font.PLAIN, 24));
        rdoClient.setForeground(Color.red);
        rdoClient.setText("�һؿͻ���Ϣ");
        rdoClient.setBounds(new Rectangle(24, 14, 181, 44));
        rdoContract.setFont(new java.awt.Font("����", Font.PLAIN, 24));
        rdoContract.setForeground(Color.blue);
        rdoContract.setText("�һض�ʧ�ı���");
        rdoContract.setBounds(new Rectangle(74, 79, 222, 30));
        rdoTeam.setFont(new java.awt.Font("����", Font.PLAIN, 24));
        rdoTeam.setForeground(Color.blue);
        rdoTeam.setText("�һ��Ŷӳ�Ա��Ϣ");
        rdoTeam.setBounds(new Rectangle(279, 17, 229, 37));
        rdoProduct.setFont(new java.awt.Font("����", Font.PLAIN, 24));
        rdoProduct.setText("ɾ���ı��ղ�Ʒ");
        rdoProduct.setBounds(new Rectangle(331, 81, 201, 33));
        lblGo.setBorder(BorderFactory.createEtchedBorder());
        lblGo.setIcon(imgComeback);
        lblGo.setText("");
        lblGo.setBounds(new Rectangle(554, 14, 134, 101));
        jScrollPane1.setBounds(new Rectangle(31, 154, 743, 420));
        this.getContentPane().add(rdoClient);
        this.getContentPane().add(jScrollPane1);
        this.getContentPane().add(rdoTeam);
        this.getContentPane().add(rdoProduct);
        this.getContentPane().add(lblGo);
        this.getContentPane().add(rdoContract);
        jScrollPane1.getViewport().add(tableInfo);
        bg.add(rdoClient);
        bg.add(rdoContract);
        bg.add(rdoProduct);
        bg.add(rdoTeam);
    }
    ImageIcon imgComeback = new ImageIcon("image\\comeback2.png");
    JRadioButton rdoClient = new JRadioButton();
    JRadioButton rdoContract = new JRadioButton();
    JRadioButton rdoTeam = new JRadioButton();
    JRadioButton rdoProduct = new JRadioButton();
    JLabel lblGo = new JLabel();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable tableInfo = new JTable();
    ButtonGroup bg = new ButtonGroup();
}
