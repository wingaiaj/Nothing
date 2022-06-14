import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @ClassName SwingComponentDemo
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/14 16:16
 * @Version 1.0
 */
public class SwingComponentDemo {
    //主窗体
    JFrame frame = new JFrame("测试swing的基本组件");
    //菜单栏
    JMenuBar jMenuBar = new JMenuBar();
    //菜单
    JMenu fileMenu = new JMenu("菜单");
    JMenu editMenu = new JMenu("编辑");
    JMenu formatMenu = new JMenu("格式");
    //菜单条目
    JMenuItem autoItem = new JMenuItem("自动换行");
    JMenuItem copyItem = new JMenuItem("复制",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\copy.png"));
    JMenuItem pasteItem = new JMenuItem("粘贴",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\paste.png"));
    JMenuItem notesItem = new JMenuItem("注释");
    JMenuItem cancelItem = new JMenuItem("取消注释");
    //文本域
    JTextArea jTextArea = new JTextArea(8, 40);
    //下拉选择框
    JComboBox<String> jComboBox = new JComboBox<>();
    //选择相关组件
    JCheckBox marryCheck = new JCheckBox("是否已婚？", false);
    String color[] = new String[]{"红色", "绿色", "蓝色"};
    //列表框
    JList<String> jList = new JList<String>(color);
    //单选按钮
    // 按钮组
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton man = new JRadioButton("男", false);
    JRadioButton woman = new JRadioButton("女", true);

    //容器
    JPanel jPanel = new JPanel();

    //文本框
    JTextField jTextField = new JTextField(25);
    //带图标的按钮
    JButton ok = new JButton("确定",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\ok.png"));
    //组装底部容器
    JPanel j = new JPanel();
    //JPopupMenu右击菜单创建
    JPopupMenu jPopupMenu = new JPopupMenu();
    //定义五个单选按钮菜单选项,用于组合风格按钮，形成单选按钮
    //单选按钮组
    ButtonGroup flavorGroup = new ButtonGroup();
    //五个单选按钮菜单条目组件
    JRadioButtonMenuItem j1 = new JRadioButtonMenuItem("Metal 风格", true);
    JRadioButtonMenuItem j2 = new JRadioButtonMenuItem("Nimbus 风格", true);
    JRadioButtonMenuItem j3 = new JRadioButtonMenuItem("Windows 风格", true);
    JRadioButtonMenuItem j4 = new JRadioButtonMenuItem("Windows 经典风格", true);
    JRadioButtonMenuItem j5 = new JRadioButtonMenuItem("Motif 风格", true);


    public void init() {
        //组装右击菜单
        flavorGroup.add(j1);
        flavorGroup.add(j2);
        flavorGroup.add(j3);
        flavorGroup.add(j4);
        flavorGroup.add(j5);

        jPopupMenu.add(j1);
        jPopupMenu.add(j2);
        jPopupMenu.add(j3);
        jPopupMenu.add(j4);
        jPopupMenu.add(j5);

        jTextArea.add(jPopupMenu);

        //设置鼠标监听 右击释放 显示右击菜单
        jTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger) {
                    jPopupMenu.show(jTextArea, e.getX(), e.getY());
                }
            }
        });
        //设置按钮监听
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        };
        j1.addActionListener(actionListener);
        j2.addActionListener(actionListener);
        j3.addActionListener(actionListener);
        j4.addActionListener(actionListener);
        j5.addActionListener(actionListener);

        //组装菜单栏
        formatMenu.add(notesItem);
        formatMenu.add(cancelItem);
        editMenu.add(autoItem);
        editMenu.addSeparator();
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(formatMenu);
        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);
        frame.setJMenuBar(jMenuBar);

        jComboBox.addItem("红色");
        jComboBox.addItem("绿色");
        jComboBox.addItem("蓝色");
        buttonGroup.add(man);
        buttonGroup.add(woman);
        //组装底部容器
        j.add(jTextField);
        j.add(ok);
        //组装中间
        jPanel.add(jComboBox);
        jPanel.add(man);
        jPanel.add(woman);
        jPanel.add(marryCheck);
        //垂直box装文本域和中间部分
        Box vBox = Box.createVerticalBox();
        vBox.add(jTextArea);
        vBox.add(jPanel);
        //水平盒子组装右边是垂直容器左边的列表框
        Box hBox = Box.createHorizontalBox();
        hBox.add(vBox);
        hBox.add(jList);

        frame.add(hBox);
        frame.add(j, BorderLayout.SOUTH);

        //不用监听窗口 此方法可以直接关闭窗口
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //最佳大小
        frame.pack();
        //主窗体可见
        frame.setVisible(true);

    }

    //定义一个方法，用于改变界面风格
    private void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }
        //更新f窗口内顶级容器以及所有组件的UI
        SwingUtilities.updateComponentTreeUI(frame.getContentPane());
        //更新mb菜单条及每部所有组件UI
        SwingUtilities.updateComponentTreeUI(jMenuBar);
        //更新右键菜单及内部所有菜单项的UI
        SwingUtilities.updateComponentTreeUI(jPopupMenu);

    }

    public static void main(String[] args) {
        new SwingComponentDemo().init();
    }
}

