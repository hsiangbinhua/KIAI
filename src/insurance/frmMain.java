package insurance;

import insurance.main;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar; //ʱ���
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FileDialog;
import javax.swing.border.*;


/**
 * <p>Title: ���մ�������Ϣ����ϵͳ</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company:��������ACCP T88�����С�� </p>
 *
 * @author not attributable    �鳤�����
 * @version 1.0
 */
public class frmMain extends JFrame implements ActionListener {
    public static String dirTou;
    FileDialog fd = new FileDialog(this);
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu mItemClient = new JMenu();
    JMenuItem mItemClientInfo = new JMenuItem();
    JMenuItem jMenuItem2 = new JMenuItem();
    JMenuItem jMenuItem3 = new JMenuItem();
    JMenu mItemProduct = new JMenu();
    JMenuItem mItemProM = new JMenuItem();
    JMenuItem jMenuItem5 = new JMenuItem();
    JMenu mItemPolicy = new JMenu();
    JMenuItem mItemContract = new JMenuItem();
    JMenu mItemTeam = new JMenu();
    JMenuItem jMenuItem8 = new JMenuItem();
    JMenuItem mTeamItemMy = new JMenuItem();
    JMenu mItemNote = new JMenu();
    JMenuItem mItemSp = new JMenuItem();
    JMenuItem mItemGo = new JMenuItem();
    JMenuItem jMenuItem13 = new JMenuItem();
    JMenu mItemSave = new JMenu();
    JMenu mItemHelp = new JMenu();
    JMenuItem jMenuItem14 = new JMenuItem();
    JMenuItem jMenuItem15 = new JMenuItem();
    JPanel jPanel1 = new JPanel();
    TitledBorder titledBorder1 = new TitledBorder("");
    JLabel lblTou = new JLabel();
    JLabel lblUser = new JLabel();
    JButton btnCPw = new JButton();
    JLabel lblBgpicture = new JLabel();
    TitledBorder titledBorder2 = new TitledBorder("");
    JLabel lblTitle = new JLabel();
    JButton lblJisuan = new JButton();
    JButton lblBug = new JButton();
    JButton lblLi = new JButton();
    JButton lblNote = new JButton();
    JButton btnUserMan = new JButton();
    JLabel lblThisTime = new JLabel();
    JMenuItem mItemOccu = new JMenuItem();
    JLabel lblwecome = new JLabel();
    JLabel lblwellbg = new JLabel();
    Timer tt;
    String admin;
    JMenuItem getback = new JMenuItem();
    JMenuItem putout = new JMenuItem();
    //---------------------------------------
    JMenuItem menuItemComeback = new JMenuItem();
    JMenuItem menuItemPrint = new JMenuItem();
    //---------------------------------------
    JMenuItem jMenuItem6 = new JMenuItem();
    JMenuItem jMenuItem9 = new JMenuItem();
    private Object th;
    JMenuItem menuItemVerion = new JMenuItem();
    public frmMain() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    /////
    
    public void actionPerformed(ActionEvent th) {
        if (th.getSource() == jMenuItem15) {
            try {
                Runtime.getRuntime().exec("qq/msimn.exe");
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
        if (th.getSource() == jMenuItem14) { //�����ĵ�
            try {
                Runtime.getRuntime().exec("hh.exe  help.chm");
            } catch (IOException ex2) {
            }
        }
        
    }
    
    
    ////////
    
    //��ȡ�û����������ֺ��û�������ʾ
    public void name() {
        String str = "select * from User_form ";
        try {
            ResultSet rs = main.stmt.executeQuery(str);
            rs.next();
            String admin = rs.getString(1);
            lblwecome.setText("��ӭ" + admin + " ������Ϣ����ϵͳ �������");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(str);
        System.out.println(admin);
    }
    
//��ʾ����ͷ��
    public void picture() {
        String picture =
                "select picture from User_form where 1=1";
        try {
            ResultSet rs = main.stmt.executeQuery(picture);
            if (rs.next()) {
                dirTou = rs.getString(1);
            }
            ImageIcon imgTou = new ImageIcon(dirTou);
            lblTou.setIcon(imgTou);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void jbInit() throws Exception {
        name(); //������Ļ
        picture(); //ͷ��
        tt = new Timer(1, new ActionListener() { //��ǩ���Ұڶ��¼�
            public void actionPerformed(ActionEvent e) {
                lblwecome.setLocation(lblwecome.getX() - 2, lblwecome.getY());
                if (lblwecome.getX() <= 0 - lblwecome.getWidth()) {
                    lblwecome.setLocation(jPanel1.getWidth(),
                            lblwecome.getY());
                }
            }
        });
        tt.start();
        
        //******�� ******�� *****�� **** ��**********//
        menuItemComeback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmDataCenter ft = new frmDataCenter();
                ft.setUndecorated(true);
                ft.setSize(800, 600);
                ft.setLocationRelativeTo(null);
                ft.setVisible(true);
            }
        });
        /*�Ŷӹ�����*/
        mTeamItemMy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmTeam ft = new frmTeam();
                ft.setUndecorated(true);
                ft.setSize(800, 600);
                ft.setLocationRelativeTo(null);
                ft.setVisible(true);
            }
        });
        
        //�ͻ���Ϣ������
        mItemClientInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameClient fc = new frameClient();
                fc.setUndecorated(true);
                fc.setSize(800, 600);
                fc.setLocationRelativeTo(null);
                fc.setVisible(true);
            }
        });
        //���������ҵ��ͳ��
        mItemContract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmContract fcontract = new frmContract();
                fcontract.setUndecorated(true);
                fcontract.setSize(800, 600);
                fcontract.setLocationRelativeTo(null);
                fcontract.setVisible(true);
            }
        });
        
        //ְҵ�����ѯ����
        mItemOccu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmOccu fo = new frmOccu();
                fo.setUndecorated(true);
                fo.setSize(500, 380);
                fo.setLocationRelativeTo(null);
                fo.setVisible(true);
            }
        });
        
        /*���ջ���*/
        mItemSp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmspeech ff = new frmspeech();
                ff.setSize(500, 380);
                ff.setLocationRelativeTo(null);
                ff.setVisible(true);
            }
        });
        /*�ݷ��г�*/
        mItemGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmGo fgo = new frmGo();
                fgo.setUndecorated(true); //ȥ��������
                fgo.setSize(720, 480);
                fgo.setLocationRelativeTo(null);
                fgo.setVisible(true);
            }
        });
        /*��Ʒ�����¼�*/
        mItemProM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmProduct Product = new frmProduct();
                Product.setSize(800, 600);
                Product.setUndecorated(true);
                Product.setLocationRelativeTo(null);
                Product.setVisible(true);
            }
        });
        /*�û����ð�ť�¼�*/
        btnUserMan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmManager fma = new frmManager();
                fma.setUndecorated(true); //ȥ��������
                fma.setSize(600, 445);
                fma.setLocationRelativeTo(null);
                fma.setVisible(true);
            }
        });
        /*�ϴ�ͷ���¼�*/
        btnCPw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fd.setMode(FileDialog.LOAD);
                fd.show();
                dirTou = fd.getDirectory() + fd.getFile();
                ImageIcon imgTou = new ImageIcon(dirTou);
                lblTou.setIcon(imgTou);
                String upload = "update User_form set picture='" + dirTou +
                        "' where 1=1";
                try {
                    main.stmt.execute(upload);
                    System.out.println(upload);
                    JOptionPane.showMessageDialog(null, "�� �� �� ����");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        //��ݰ�ťͼ��
        ImageIcon imgJisuan = new ImageIcon("image\\������.png");
        ImageIcon imgLi = new ImageIcon("image\\������.png");
        ImageIcon imgNote = new ImageIcon("image\\ְҵ��־.png");
        ImageIcon imgBug = new ImageIcon("image\\ϵͳ����Ͷ��.png");
        
        lblJisuan.setBorder(BorderFactory.createLineBorder(Color.black));
        lblJisuan.setText("");
        lblJisuan.setBounds(new Rectangle(83, 284, 88, 77));
        lblBug.setBorder(BorderFactory.createLineBorder(Color.black));
        lblBug.setBounds(new Rectangle(0, 361, 84, 93));
        lblLi.setBorder(BorderFactory.createLineBorder(Color.black));
        lblLi.setBounds(new Rectangle(84, 360, 87, 94));
        lblNote.setBorder(BorderFactory.createLineBorder(Color.black));
        lblNote.setBounds(new Rectangle(0, 283, 85, 78));
        ////
        lblJisuan.setIcon(imgJisuan);
        lblJisuan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblJisuan_actionPerformed(e);
            }
        });
        
        lblLi.setIcon(imgLi);
        lblLi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblLi_actionPerformed(e);
            }
        });
        
        lblNote.setIcon(imgNote);
        lblNote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNote_actionPerformed(e);
            }
        });
        lblBug.setIcon(imgBug);
        lblBug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblBug_actionPerformed(e);
            }
        });
        ///////
        
        
        /*����*/
        lblwecome.setBackground(Color.magenta);
        lblwecome.setFont(new java.awt.Font("������κ", Font.PLAIN, 20));
        lblwecome.setForeground(Color.green);
        
        lblwecome.setBounds(new Rectangle(0, 0, 352, 36));
        ImageIcon imgyou = new ImageIcon("image\\well.jpg");
        lblwellbg.setIcon(imgyou);
        lblwellbg.setBounds(new Rectangle(0, 0, 352, 36));
        
        ImageIcon img = new ImageIcon("image\\main.jpg");
        lblBgpicture.setIcon(img);
        lblBgpicture.setLabelFor(this);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(jMenuBar1);
        this.setResizable(false);
        this.setTitle("���մ�������Ϣ����ϵͳV1.0");
        mItemClient.setText("�ͻ���Ϣ");
        mItemClientInfo.setText("�ͻ���Ϣ����");
        jMenuItem2.setText("�ͻ��ݷ�");
        jMenuItem3.setText("VIP�ͻ�");
        mItemProduct.setText(" ������Ϣ");
        mItemProM.setText("���ղ�Ʒ����");
        jMenuItem5.setText("����������");
        mItemPolicy.setText(" ������Ϣ");
        mItemContract.setText(" �����ۺϹ���");
        mItemTeam.setText(" �Ŷӹ���");
        jMenuItem8.setText(" ��������ѯ");
        
        mTeamItemMy.setText("�ҵ��Ŷ�");
        mItemNote.setText(" ְҵ��־");
        mItemGo.setText("�� �ݷ��г�");
        jMenuItem13.setText("���Ŷ�������");
        mItemSave.setActionCommand(" ");
        mItemSave.setText(" ���ݴ�������");
        mItemHelp.setText(" ����");
        jMenuItem14.setText(" ϵͳ����");
        jMenuItem15.setText(" ��ϵ����");
        jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
        jPanel1.setBounds(new Rectangle(0, 0, 167, 266));
        jPanel1.setLayout(null);
        lblTou.setFont(new java.awt.Font("����", Font.PLAIN, 15));
        lblTou.setForeground(Color.green);
        lblTou.setText("����û���ϴ�����ͷ��");
        lblTou.setBounds(new Rectangle(3, 39, 158, 171));
        lblUser.setFont(new java.awt.Font("�����п�", Font.PLAIN, 18));
        lblUser.setForeground(Color.blue);
        lblUser.setText("��¼״̬������");
        lblUser.setBounds(new Rectangle(16, 208, 142, 30));
        btnCPw.setBounds(new Rectangle(3, 239, 94, 24));
        btnCPw.setFont(new java.awt.Font("��������", Font.PLAIN, 17));
        btnCPw.setForeground(Color.magenta);
        btnCPw.setBorder(BorderFactory.createEtchedBorder());
        btnCPw.setText("����ͷ��...");
        lblBgpicture.setBackground(Color.white);
        lblBgpicture.setEnabled(true);
        lblBgpicture.setBorder(BorderFactory.createLineBorder(Color.black));
        lblBgpicture.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
        lblBgpicture.setOpaque(true);
        lblBgpicture.setDisabledIcon(null);
        lblBgpicture.setDisplayedMnemonic('0');
        lblBgpicture.setText("");
        lblBgpicture.setVerticalAlignment(SwingConstants.CENTER);
        lblBgpicture.setBounds(new Rectangle(170, 0, 630, 602));
        lblTitle.setFont(new java.awt.Font("��������", Font.PLAIN, 55));
        lblTitle.setForeground(UIManager.getColor(
                "InternalFrame.activeTitleBackground"));
        lblTitle.setText("���մ�������Ϣ����ϵͳ");
        lblTitle.setBounds(new Rectangle(175, 1, 623, 68));
        mItemSp.setActionCommand(" ���ջ���");
        mItemSp.setText("�� ���ջ���");
        btnUserMan.setBounds(new Rectangle(17, 459, 124, 39));
        btnUserMan.setFont(new java.awt.Font("��������", Font.PLAIN, 20));
        btnUserMan.setText("�û�����");
        lblThisTime.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
        lblThisTime.setText("ϵͳʱ�䣺");
        lblThisTime.setBounds(new Rectangle(0, 524, 167, 27));
////------------------------------------------------
        lblThisTime.setFont(new java.awt.Font("Dialog", Font.PLAIN, 13));
        Calendar c = Calendar.getInstance();
        lblThisTime.setText("ϵͳ���ڣ�" +
                c.get(Calendar.YEAR) + "��" +
                (c.get(Calendar.MONTH) + 1) + "��" +
                c.get(Calendar.DATE) + "��");
        lblThisTime.setBounds(new Rectangle(0, 524, 171, 26));
///////-------------------------------------------------------
        mItemOccu.setText("ְҵ�����ѯ");
        getback.setText(" �һ�ɾ��������");
        putout.setActionCommand(" ");
        putout.setText(" �������ݱ���");
        jMenuItem6.setText(" ");
        jMenuItem9.setText(" ��ҵ��ͳ��");
        menuItemComeback.setText("�һض�ʧ������");
        menuItemPrint.setText("��ӡ���ݱ��");
        menuItemVerion.setText(" �汾��Ϣ");
        
        jMenuBar1.add(mItemClient);
        jMenuBar1.add(mItemProduct);
        jMenuBar1.add(mItemPolicy);
        jMenuBar1.add(mItemTeam);
        jMenuBar1.add(mItemNote);
        jMenuBar1.add(mItemSave);
        jMenuBar1.add(mItemHelp);
        mItemClient.add(mItemClientInfo);
        mItemClient.add(jMenuItem2);
        mItemClient.add(jMenuItem3);
        mItemClient.add(mItemOccu);
        mItemProduct.add(mItemProM);
        mItemProduct.add(jMenuItem5);
        mItemPolicy.add(mItemContract);
        mItemPolicy.add(jMenuItem8);
        mItemPolicy.add(jMenuItem9);
        mItemTeam.add(mTeamItemMy);
        mItemTeam.add(jMenuItem13);
        mItemNote.add(mItemSp);
        mItemNote.add(mItemGo);
        mItemHelp.add(jMenuItem14);
        mItemHelp.add(jMenuItem15);
        mItemHelp.add(menuItemVerion);
        this.getContentPane().add(jPanel1);
        this.getContentPane().add(lblTitle);
        this.getContentPane().add(lblBgpicture);
        this.getContentPane().add(lblNote);
        this.getContentPane().add(lblJisuan);
        this.getContentPane().add(lblBug);
        this.getContentPane().add(lblLi);
        this.getContentPane().add(lblThisTime);
        this.getContentPane().add(btnUserMan);
        jPanel1.add(btnCPw);
        jPanel1.add(lblTou);
        jPanel1.add(lblUser);
        jPanel1.add(lblwecome);
        jPanel1.add(lblwellbg);
//        mItemSave.add(getback);
//        mItemSave.add(putout);
        //---------------
        mItemSave.add(menuItemComeback);
        mItemSave.add(menuItemPrint);
        mItemSave.add(jMenuItem6);
        
        jMenuItem15.addActionListener(this);
        jMenuItem14.addActionListener(this);
        
    }
    
//ͼ���ݷ�ʽ���÷���
    public void lblJisuan_actionPerformed(ActionEvent e) {
        if (e.getSource() == lblJisuan) { //���ü�����
            try {
                Runtime run = Runtime.getRuntime();
                run.exec("ww.exe");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void lblLi_actionPerformed(ActionEvent e) {
        if (e.getSource() == lblLi) { //����������
            try {
                Runtime.getRuntime().exec("ee.exe");
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
        
    }
    
    public void lblBug_actionPerformed(ActionEvent e) { //�ʼ�
        if (e.getSource() == lblBug) {
            try {
                Runtime.getRuntime().exec("qq/msimn.exe");
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }
    
    public void lblNote_actionPerformed(ActionEvent e) { //���±�
        if (e.getSource() == lblNote) {
            try {
                Runtime.getRuntime().exec("ji.exe");
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
        
    }
}
