import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/17 16:30
 * @Version 1.0
 */
public class ListTest {
    //主窗口创建
    JFrame frame = new JFrame("列表框测试");
    //book数组
    String book[] = new String[]{"java自学宝典", "轻量级javaEE企业应用实战", "Android基础教程", "jQuery实战教程", "SpringBoot企业级开发"};
    //列表框
    JList jList = new JList(book);
    //下拉选择框
    JComboBox jComboBox = new JComboBox(book);
    //LayoutPanel
    JPanel LayoutPanel = new JPanel();
    //selectPanel
    JPanel selectPanel = new JPanel();
    //layout按钮组
    ButtonGroup layButtonGroup = new ButtonGroup();
    //select按钮组
    ButtonGroup selectButtonGroup = new ButtonGroup();
    //文本域
    JTextArea jTextArea = new JTextArea(4, 6);
    //标签
    JLabel jLabel = new JLabel("您最喜欢的图书:");

    public void layoutButton2method(String name, int type) {
        //设置panel的边框
        LayoutPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选项布局"));
        //创建单选按钮
        JRadioButton jRadioButton = new JRadioButton(name);
        //添加到layoutPanel
        LayoutPanel.add(jRadioButton);
        //添加的为第一个按钮
        if (layButtonGroup.getButtonCount() == 0) {
            jRadioButton.setSelected(true);
        }
        //添加到按钮组
        layButtonGroup.add(jRadioButton);
        //添加监听
        jRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jList.setLayoutOrientation(type);
            }
        });
    }

    public void selectButton2method(String name, int type) {
        //设置panel的边框
        selectPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选择模式"));
        //创建单选按钮
        JRadioButton jRadioButton = new JRadioButton(name);
        //添加到layoutPanel
        selectPanel.add(jRadioButton);
        //添加的为第一个按钮
        if (selectButtonGroup.getButtonCount() == 0) {
            jRadioButton.setSelected(true);
        }
        //添加到按钮组
        selectButtonGroup.add(jRadioButton);
        //添加监听
        jRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jList.setSelectionMode(type);
            }
        });
    }

    public void init() {
        //创建按钮
        layoutButton2method("纵向滚动", JList.VERTICAL);
        layoutButton2method("纵向换行", JList.VERTICAL_WRAP);
        layoutButton2method("横向换行", JList.VERTICAL_WRAP);
        selectButton2method("无限制", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        selectButton2method("单选", ListSelectionModel.SINGLE_SELECTION);
        selectButton2method("单范围", ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //显示3行
        jList.setVisibleRowCount(3);
        //默认选择3-5行
        jList.setSelectionInterval(2, 4);
        //监听
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<String> selectedValuesList = jList.getSelectedValuesList();
                jTextArea.setText("");
                for (String s : selectedValuesList) {
                    jTextArea.append(s + "\n");
                }
            }
        });
        //监听下拉列表框
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = jComboBox.getSelectedItem();

                jTextArea.append(selectedItem.toString()+"\n");
            }
        });

        //垂直box组装
        Box vLeftBox = Box.createVerticalBox();
        vLeftBox.add(new JScrollPane(jList));
        vLeftBox.add(LayoutPanel);
        vLeftBox.add(selectPanel);
        //水平box组装
        Box hCenterBox = Box.createHorizontalBox();
        hCenterBox.add(vLeftBox);
        JPanel jPanel = new JPanel();
        jPanel.add(jComboBox);
        hCenterBox.add(jPanel);
        //文本域和标签组装底部
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(jLabel);
        verticalBox.add(jTextArea);

        frame.add(hCenterBox);
        frame.add(verticalBox, BorderLayout.SOUTH);
        //主窗口大小
        frame.pack();
        //主窗口可见
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new ListTest().init();
    }
}
