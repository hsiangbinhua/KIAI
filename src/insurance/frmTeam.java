package insurance;

import java.awt.*;

import javax.swing.*;
import javax.swing.JTable;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import java.awt.FileDialog;


public class frmTeam extends JFrame {
    public frmTeam() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //ˢ�µķ���
    public void fresh() {
        txtTeam.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtBirth.setText("");
        txtCode.setText("");
        txtJoin.setText("");
        txtHome.setText("");
        txtQQ.setText("");
        txtPhone1.setText("");
        txtPhone2.setText("");
        txtAreaRe.setText("");

        cmbGrade.setSelectedIndex(0);
        cmbEducation.setSelectedIndex(0);
        cmbMarriage.setSelectedIndex(0);
        cmbBefore.setSelectedIndex(0);
        cmbStrong.setSelectedIndex(0);
        ImageIcon imgPic = new ImageIcon("image\\NoPicture.png");
        lblTou.setIcon(imgPic);
    }

    public void tableDemo1() {
        //************��  ��  ģ  ��**************//
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
    }

    public void tableDemo2() {
        //Teamx.removeAllElements();
        Teamy.removeAllElements();
        String str = "select * from Team_form where Avail=1 order by Team_Name";
        try {
            ResultSet rs = main.stmt.executeQuery(str);
            Teamy.removeAllElements(); //���ǰ�������
            ResultSetMetaData rsmd = rs.getMetaData(); // ������ݿ���ԭ��
            int count = rsmd.getColumnCount(); //ȡ�ñ��е��е�����
            System.out.println("count:" + count);
//            for (int i = 1; i <=count; i++) {
//                Teamx.add(rsmd.getCatalogName(i));             //����һ���ж���
//            }
//
            System.out.println(str);
            while (rs.next()) {
                Vector v = new Vector(); //����ĵ�һ�����ݶ���ʵ��
                for (int i = 1; i <= count; i++) {
                    v.add(rs.getObject(i).toString()); //ͨ��ѭ������һ�е�ֵ��ӵ��ж�����ȥ
                }
                Teamy.add(v); //��ÿһ�еĶ�����ӵ��������ȥ
            }
            my = (Vector) Teamy.clone();
            System.out.println("============" + my.get(0).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //��ʾͷ��ķ���
    public void picture() {
        String picture =
                "select Team_Img from Team_form where Colleague_Name='" +
                txtName.getText() + "'";

        try {
            ResultSet rs = main.stmt.executeQuery(picture);
            if (rs.next()) {
                dir = rs.getString("Team_Img");
            }
            System.out.println(dir);
            ImageIcon imgPic = new ImageIcon(dir);
            lblTou.setIcon(imgPic);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        //�ϴ�ͷ��
        btnUpPic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fd.setMode(FileDialog.LOAD);
                fd.show();
                dir = fd.getDirectory() + fd.getFile();
                ImageIcon imgPic = new ImageIcon(dir);
                lblTou.setIcon(imgPic);
                String dirPic = "update Team_form set Team_Img='" + dir +
                                "' where Colleague_Name='" + txtName.getText() +
                                "'";
                try {
                    main.stmt.execute(dirPic);
                    JOptionPane.showMessageDialog(null, "�ϴ��ɹ���");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println(dirPic);
            }
        });

        //*********************���÷��������ñ������*************//
        tableDemo1();
        tableDemo2();
        //*********************���÷��������ñ������*************//

        /*ˢ�°�ť�¼�*/
        btnFresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fresh(); //������տؼ��ķ���
                tableDemo2(); //�ٴε��ò�ѯ
            }
        });

        //�����Ŷӳ�Ա
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strsql = "insert into Team_form values ('" +
                                txtTeam.getText() + "','" + txtCode.getText() +
                                "','" + cmbGrade.getSelectedItem() + "','" +
                                txtName.getText() + "','" + txtBirth.getText() +
                                "','" + cmbMarriage.getSelectedItem() +
                                "','" + cmbEducation.getSelectedItem() + "','" +
                                cmbBefore.getSelectedItem() + "','" +
                                txtJoin.getText() + "','" +
                                cmbStrong.getSelectedItem() + "','" +
                                txtHome.getText() + "','" + txtPhone1.getText() +
                                "','" + txtPhone2.getText() + "','" +
                                txtQQ.getText() + "','" + txtEmail.getText() +
                                "','','" + txtAreaRe.getText() + "',1)";
                try {
                    if (txtName.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "��������Ϊ�գ�����������");
                    } else {
                        main.stmt.execute(strsql);
                        JOptionPane.showMessageDialog(null, "�����ͬ�³ɹ�", " ��ӳɹ�",
                                1);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                fresh(); //������տؼ��ķ���
                tableDemo2(); //�ٴε��ò�ѯ
            }
        });

        //��ѯ��ť�¼�
        btnQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String code = txtCode.getText();
                String strsql =
                        "select * from Team_form where Colleague_Name like '%" +
                        name + "%' or Code_Name like '%" +
                        code + "%' and Avail = 1";
                System.out.println(strsql);
                try {
                    ResultSet rs = main.stmt.executeQuery(strsql);
//                    ResultSetMetaData rsmd = rs.getMetaData(); // ������ݿ���ԭ��
//                    int count = rsmd.getColumnCount();
                    if (rs.next()) {
//                        Vector v = new Vector(); //����ĵ�һ�����ݶ���ʵ��
//                        for (int i = 1; i <= count; i++) {
//                            v.add(rs.getObject(i).toString()); //ͨ��ѭ������һ�е�ֵ��ӵ��ж�����ȥ
//                        }
//                        Teamy.add(v);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "��������λͬ�£���������˲�ѯ�����������ͬ��");
                        return;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //ɾ����ť���¼������£�
        btnShang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strsql =
                        "update Team_form  set Avail=0 where Avail = 1";

            }
        });
        //�����޸�
        btnSaveAmend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String strsql = "update Team_form set Team_Name='" +
                                txtTeam.getText() + "', Code_Name='" +
                                txtCode.getText() +
                                "',Grade_Type='" + cmbGrade.getSelectedItem() +
                                "',Colleague_Name='" +
                                txtName.getText() + "',Birth='" +
                                txtBirth.getText() +
                                "',Marriage='" + cmbMarriage.getSelectedItem() +
                                "',Education='" + cmbEducation.getSelectedItem() +
                                "',Before_occup='" +
                                cmbBefore.getSelectedItem() + "',Join_Time='" +
                                txtJoin.getText() + "',Strong='" +
                                cmbStrong.getSelectedItem() + "',Home_No='" +
                                txtHome.getText() + "',Tele_No1='" +
                                txtPhone1.getText() +
                                "',Tele_No1='" + txtPhone2.getText() +
                                "',QQ_No='" +
                                txtQQ.getText() + "',E_mail='" +
                                txtEmail.getText() +
                                "','',Remark='" + txtAreaRe.getText() +
                                "',Avail=1 where Colleague_Name='" +
                                txtName.getText() + "'";
                System.out.println(strsql);
                try {
                    main.stmt.execute(strsql);
                    JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("�Ŷӹ����������������");
        tableTeamInfo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                tableTeamInfo_mouseClicked(e);
            }
        });
        fd.setTitle("��ѡ��ͼƬ");
        this.getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(new Rectangle(0, 0, 800, 600));
        jTabbedPane1.add(pnlFamlily,
                         "\u6211\u4eec\u7684\u56e2\u961f\u5927\u5bb6\u5ead");
        lblFamily.setBorder(BorderFactory.createEtchedBorder());
        lblFamily.setText("");
        lblFamily.setBounds(new Rectangle(0, 0, 651, 502));
        btnHuo.setFont(new java.awt.Font("����", Font.PLAIN, 22));
        btnHuo.setForeground(Color.BLUE);
        btnHuo.setBounds(new Rectangle(648, 0, 148, 34));
        btnHuo.setText("����������");
        jTabbedPane1.add(pnlInfo, "��ϸ��Ϣ");
        lblBefor.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblBefor.setForeground(SystemColor.activeCaption);
        lblBefor.setText("��˾ǰְҵ");
        lblBefor.setBounds(new Rectangle(214, 42, 96, 29));
        cmbBefore.addItem("");
        cmbBefore.addItem("��˾ְԱ");
        cmbBefore.addItem("����Ա");
        cmbBefore.addItem("���廧");
        cmbBefore.addItem("ũҵ/��ҵ");
        cmbBefore.addItem("����/��ѵ");
        cmbBefore.addItem("�� ��");
        lblJoin.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblJoin.setForeground(SystemColor.activeCaption);
        lblJoin.setText("��˾ʱ��");
        lblJoin.setBounds(new Rectangle(224, 77, 73, 29));
        lblName.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblName.setForeground(SystemColor.activeCaption);
        lblName.setText("��   ��");
        lblName.setBounds(new Rectangle(0, 41, 68, 29));
        lblGrade.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblGrade.setForeground(SystemColor.activeCaption);
        lblGrade.setText("ְ   ��");
        lblGrade.setBounds(new Rectangle(0, 75, 68, 29));
        cmbGrade.addItem("");
        cmbGrade.addItem("ҵ �� Ա");
        cmbGrade.addItem("�ֹ�˾����");
        cmbGrade.addItem("ҵ����");
        cmbGrade.addItem("��ѵ����");
        cmbGrade.addItem("��Ʒ�߻�");
        cmbGrade.addItem("�߼���ʦ");
        cmbGrade.addItem("ʵϰ��");
        lblCode.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblCode.setForeground(SystemColor.activeCaption);
        lblCode.setText("Ա������ ");
        lblCode.setBounds(new Rectangle(0, 110, 81, 29));
        lblMarriage.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblMarriage.setForeground(SystemColor.activeCaption);
        lblMarriage.setText("�������");
        lblMarriage.setBounds(new Rectangle(222, 4, 73, 29));
        cmbMarriage.addItem("");
        cmbMarriage.addItem("δ��");
        cmbMarriage.addItem("�ѻ�");
        cmbMarriage.addItem("ɥ��");
        cmbMarriage.addItem("ɥ��");
        lblBirth.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblBirth.setForeground(SystemColor.activeCaption);
        lblBirth.setText("��������");
        lblBirth.setBounds(new Rectangle(0, 148, 73, 29));
        lblEducation.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblEducation.setForeground(SystemColor.activeCaption);
        lblEducation.setText("�����̶�");
        lblEducation.setBounds(new Rectangle(4, 187, 75, 29));
        cmbEducation.setBounds(new Rectangle(81, 191, 115, 27));
        cmbEducation.addItem("");
        cmbEducation.addItem("�� ѧ");
        cmbEducation.addItem("�� ��");
        cmbEducation.addItem("�� ��");
        cmbEducation.addItem("�о�������");
        cmbEducation.addItem("�� ��");
        lblStrong.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblStrong.setForeground(SystemColor.activeCaption);
        lblStrong.setText("��   ��");
        lblStrong.setBounds(new Rectangle(228, 112, 68, 29));
        cmbStrong.addItem("");
        cmbStrong.addItem("����");
        cmbStrong.addItem("����/����");
        cmbStrong.addItem("�赸");
        cmbStrong.addItem("�黭");
        cmbStrong.addItem("��  ��");
        lblTeam.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblTeam.setForeground(SystemColor.activeCaption);
        lblTeam.setText("��������");
        lblTeam.setBounds(new Rectangle(0, 5, 72, 29));
        txtTeam.setBorder(BorderFactory.createEtchedBorder());
        txtTeam.setText("");
        txtTeam.setBounds(new Rectangle(77, 6, 114, 28));
        txtName.setBounds(new Rectangle(79, 41, 114, 28));
        txtCode.setBounds(new Rectangle(80, 111, 116, 30));
        txtJoin.setBounds(new Rectangle(324, 76, 114, 30));
        txtBirth.setBounds(new Rectangle(81, 151, 114, 30));
        cmbStrong.setBounds(new Rectangle(326, 113, 115, 27));
        cmbGrade.setBounds(new Rectangle(79, 77, 115, 27));
        cmbBefore.setBounds(new Rectangle(322, 40, 115, 27));
        cmbMarriage.setBounds(new Rectangle(319, 5, 115, 27));
        txtPhone1.setText("");
        txtPhone1.setBounds(new Rectangle(547, 44, 111, 30));
        txtEmail.setText("");
        txtEmail.setBounds(new Rectangle(469, 182, 196, 36));
        lblRemark.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblRemark.setForeground(SystemColor.activeCaption);
        lblRemark.setText("��   ע");
        lblRemark.setBounds(new Rectangle(231, 146, 68, 29));
        txtAreaRe.setBorder(BorderFactory.createLoweredBevelBorder());
        txtAreaRe.setText("");
        txtAreaRe.setBounds(new Rectangle(235, 174, 214, 46));
        lblHomeNo.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblHomeNo.setForeground(SystemColor.activeCaption);
        lblHomeNo.setText("ס���绰");
        lblHomeNo.setBounds(new Rectangle(455, 5, 73, 29));
        lblPhone2.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblPhone2.setForeground(SystemColor.activeCaption);
        lblPhone2.setText("�ƶ��绰2");
        lblPhone2.setBounds(new Rectangle(458, 79, 84, 29));
        txtPhone2.setText("");
        txtPhone2.setBounds(new Rectangle(548, 83, 109, 30));
        lblPhone1.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblPhone1.setForeground(SystemColor.activeCaption);
        lblPhone1.setText("�ƶ��绰1");
        lblPhone1.setBounds(new Rectangle(457, 41, 85, 29));
        lblQQ.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblQQ.setForeground(SystemColor.activeCaption);
        lblQQ.setText("QQ  ��");
        lblQQ.setBounds(new Rectangle(466, 119, 70, 29));
        txtQQ.setText("");
        txtQQ.setBounds(new Rectangle(547, 120, 110, 30));
        btnUpPic.setText("�ϴ�ͷ��");
        btnUpPic.setBounds(new Rectangle(678, 150, 90, 30));
        txtHome.setText("");
        txtHome.setBounds(new Rectangle(546, 3, 111, 30));
        lblEmail.setFont(new java.awt.Font("����_GB2312", Font.PLAIN, 18));
        lblEmail.setForeground(SystemColor.activeCaption);
        lblEmail.setText("�����ʼ���ַ");
        lblEmail.setBounds(new Rectangle(476, 155, 115, 27));
        btnAdd.setBounds(new Rectangle(500, 228, 73, 30));
        btnAdd.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnAdd.setForeground(Color.BLUE);
        btnAdd.setText("����");

        btnSaveAmend.setBounds(new Rectangle(620, 228, 110, 30));
        btnSaveAmend.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnSaveAmend.setForeground(Color.BLUE);
        btnSaveAmend.setText("�����޸�");

        btnQuery.setBounds(new Rectangle(195, 228, 73, 30));
        btnQuery.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnQuery.setForeground(Color.BLUE);
        btnQuery.setText("��ѯ");
        btnShang.setBounds(new Rectangle(350, 228, 73, 30));
        btnShang.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnShang.setForeground(Color.blue);
        btnShang.setText("ɾ��");
        btnFresh.setBounds(new Rectangle(44, 228, 73, 30));
        btnFresh.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        btnFresh.setForeground(Color.blue);
        btnFresh.setText("ˢ��");
        lblTou.setEnabled(true);
        lblTou.setBorder(BorderFactory.createLineBorder(Color.black));
        lblTou.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
        lblTou.setDisabledIcon(null);
        lblTou.setLabelFor(this);
        lblTou.setText("");
        lblTou.setBounds(new Rectangle(675, 13, 103, 130));
        pnlInfo.setEnabled(false);
        pnlInfo.setLayout(null);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
                                                  HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.
                                                VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
        jScrollPane1.setBounds(new Rectangle(0, 266, 789, 275));
        pnlFamlily.setLayout(null);
        pnlFamlily.add(lblFamily);
        pnlFamlily.add(btnHuo);
        pnlInfo.add(lblTou);
        pnlInfo.add(lblCode);
        pnlInfo.add(lblBirth);
        pnlInfo.add(lblEducation);
        pnlInfo.add(cmbMarriage);
        pnlInfo.add(cmbBefore);
        pnlInfo.add(txtJoin);
        pnlInfo.add(cmbStrong);
        pnlInfo.add(lblTeam);
        pnlInfo.add(lblName);
        pnlInfo.add(lblGrade);
        pnlInfo.add(txtTeam);
        pnlInfo.add(txtName);
        pnlInfo.add(txtCode);
        pnlInfo.add(cmbGrade);
        pnlInfo.add(txtBirth);
        pnlInfo.add(lblMarriage);
        pnlInfo.add(lblBefor);
        pnlInfo.add(lblJoin);
        pnlInfo.add(lblStrong);
        pnlInfo.add(lblRemark);
        pnlInfo.add(txtAreaRe);
        pnlInfo.add(lblHomeNo);
        pnlInfo.add(lblPhone1);
        pnlInfo.add(lblPhone2);
        pnlInfo.add(lblEmail);
        pnlInfo.add(txtEmail);
        pnlInfo.add(txtHome);
        pnlInfo.add(txtPhone1);
        pnlInfo.add(txtPhone2);
        pnlInfo.add(btnFresh);
        pnlInfo.add(btnShang);
        pnlInfo.add(btnAdd);
        pnlInfo.add(btnQuery);
        pnlInfo.add(lblQQ);
        pnlInfo.add(txtQQ);
        pnlInfo.add(cmbEducation);
        pnlInfo.add(jScrollPane1);
        pnlInfo.add(btnUpPic);
        pnlInfo.add(btnSaveAmend);
        ImageIcon imgfamlily = new ImageIcon("image\\Team.jpg");
        lblFamily.setIcon(imgfamlily);
        ImageIcon imgPic = new ImageIcon("image\\NoPicture.png");
        lblTou.setIcon(imgPic);
        jScrollPane1.getViewport().add(tableTeamInfo);
        tableTeamInfo.setAutoResizeMode(tableTeamInfo.AUTO_RESIZE_OFF); //�ر��Զ�ƽ��
        dtm = new DefaultTableModel(Teamy, Teamx);
        tableTeamInfo.setModel(dtm);
    }

    String dir; //ͷ���·��


    JButton btnSaveAmend = new JButton();
    JButton btnUpPic = new JButton();
    JComboBox cmbEducation = new JComboBox();
    JComboBox cmbBefore = new JComboBox();
    JComboBox cmbMarriage = new JComboBox();
    JComboBox cmbGrade = new JComboBox();
    JComboBox cmbStrong = new JComboBox();
    JTabbedPane jTabbedPane1 = new JTabbedPane();
    JLabel lblFamily = new JLabel();
    JPanel pnlFamlily = new JPanel();
    JButton btnHuo = new JButton();
    JPanel pnlInfo = new JPanel();
    JLabel lblBefor = new JLabel();
    JLabel lblJoin = new JLabel();
    JLabel lblName = new JLabel();
    JLabel lblGrade = new JLabel();
    JLabel lblCode = new JLabel();
    JLabel lblMarriage = new JLabel();
    JLabel lblBirth = new JLabel();
    JLabel lblEducation = new JLabel();
    JLabel lblStrong = new JLabel();
    JLabel lblTeam = new JLabel();
    JTextField txtTeam = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtCode = new JTextField();
    JTextField txtJoin = new JTextField();
    JTextField txtBirth = new JTextField();
    TitledBorder titledBorder1 = new TitledBorder("");
    JTextField txtPhone1 = new JTextField();
    JTextField txtEmail = new JTextField();
    JLabel lblRemark = new JLabel();
    JTextArea txtAreaRe = new JTextArea();
    JLabel lblHomeNo = new JLabel();
    JLabel lblPhone2 = new JLabel();
    JLabel lblPhone1 = new JLabel();
    JLabel lblQQ = new JLabel();
    JTextField txtHome = new JTextField();
    JTextField txtPhone2 = new JTextField();
    JLabel lblEmail = new JLabel();
    JTextField txtQQ = new JTextField();
    JButton btnAdd = new JButton();
    JButton btnQuery = new JButton();
    JButton btnShang = new JButton();
    JButton btnFresh = new JButton();
    JLabel lblTou = new JLabel();

    //��ʾ���������Ϣ
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable tableTeamInfo = new JTable();
    Vector Teamx = new Vector();
    Vector Teamy = new Vector();
    Vector my = new Vector();

    DefaultTableModel dtm;

    //�ϴ�ͷ��
    FileDialog fd = new FileDialog(this);

    //�ص��о�����
    public void tableTeamInfo_mouseClicked(MouseEvent e) {
        int rowNum = tableTeamInfo.getSelectedRow(); //���ѡ�е��к�
        Vector Team = (Vector) Teamy.get(rowNum); //ȡ��ѡ���еĶ���
        this.txtTeam.setText(Team.get(0).toString());
        this.txtCode.setText(Team.get(1).toString());
        this.txtName.setText(Team.get(3).toString());
        this.cmbGrade.setSelectedItem(Team.get(2));
        this.txtBirth.setText(Team.get(4).toString()); //(����)��ѡ���еĵ�ֵ�ŵ��ı���ȥ
        this.cmbMarriage.setSelectedItem(Team.get(5));
        this.cmbEducation.setSelectedItem(Team.get(6));
        this.cmbBefore.setSelectedItem(Team.get(7));
        this.txtJoin.setText(Team.get(8).toString());
        this.cmbStrong.setSelectedItem(Team.get(9));
        this.txtHome.setText(Team.get(10).toString());
        this.txtPhone1.setText(Team.get(11).toString());
        this.txtPhone2.setText(Team.get(12).toString());
        this.txtQQ.setText(Team.get(13).toString());
        this.txtEmail.setText(Team.get(14).toString());
        this.txtAreaRe.setText(Team.get(15).toString());
//       System.out.println("============" + my.get(0).toString());
//        Vector vect = (Vector) my.get(rowNum);
//String imgPath= vect.get(16).toString();
//        ImageIcon imgTou = new ImageIcon(imgPath);
//        this.lblTou.setIcon(imgTou);
//        System.out.println("imgUrl===========" +imgPath);
        //������Ҫʹ�õı���������
        String edu = cmbEducation.getSelectedItem().toString();
        String before = cmbBefore.getSelectedItem().toString();
        String grade = cmbGrade.getSelectedItem().toString();
        String marriage = cmbMarriage.getSelectedItem().toString();
        String strong = cmbStrong.getSelectedItem().toString();
        picture();

    }
}
