import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 * @ClassName defaultListModel
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/18 10:57
 * @Version 1.0
 */
public class defaultListModel {
    //主窗体
    JFrame frame = new JFrame("测试defaultListModel");
    //列表框
    JList<String> list;
    //列表框model
    DefaultListModel<String> defaultListModel = new DefaultListModel<>();
    //文本框
    JTextField jTextField = new JTextField(10);
    //add按钮
    JButton addButton = new JButton(new AbstractAction("添加指定图书") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jTextField.getText().trim() != "" && !defaultListModel.contains(jTextField.getText())) {
                defaultListModel.addElement(jTextField.getText());
            }
        }
    });
    //remove按钮
    JButton delButton = new JButton(new AbstractAction("删除选中图书") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (list.getSelectedIndex() >= 0) {
                defaultListModel.remove(list.getSelectedIndex());
            }
        }
    });

    public void init() {
        //传入model
        list = new JList<>(defaultListModel);
        //列表可见为4
        list.setVisibleRowCount(4);
        //列表为单选
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //赋值强制存储列表项 必须有元素
        defaultListModel.addElement("java自学宝典");
        defaultListModel.addElement("轻量级javaEE企业应用实战");
        defaultListModel.addElement("Android基础教程");
        defaultListModel.addElement("jQuery实战教程");
        defaultListModel.addElement("SpringBoot企业级开发");
        //组装
        frame.add(new JScrollPane(list));
        JPanel jPanel = new JPanel();
        jPanel.add(jTextField);
        jPanel.add(addButton);
        jPanel.add(delButton);
        frame.add(jPanel, BorderLayout.SOUTH);

        //可关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //最佳大小
        frame.pack();
        //可见
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new defaultListModel().init();
    }
}
