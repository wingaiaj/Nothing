import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName ListTest2
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/18 9:22
 * @Version 1.0
 */
public class ListTest2 {
   //主窗体创建
    JFrame frame = new JFrame("测试ListModel");
    //列表框
  JList<BigDecimal> jList = new JList<>(new listModel(1,21,2));
    //下拉列表
    JComboBox<BigDecimal> jComboBox  = new JComboBox<>(new comboBoxModel(0.1,1.2,0.1));
    //标签
    JLabel jLabel = new JLabel("您选择的值是: ");
    //文本框
    JTextField jTextField = new JTextField();

    public void init() {
    //监听列表框
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<BigDecimal> selectedValuesList = jList.getSelectedValuesList();
                jTextField.setText("");
                for (BigDecimal bigDecimal : selectedValuesList) {
                    jTextField.setText(jTextField.getText()+bigDecimal.toString()+",");
                }
            }
        });
        //监听下拉选择框
        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = jComboBox.getSelectedItem();
                jTextField.setText(selectedItem.toString());

            }
        });
        //文本框
        jTextField.setColumns(10);
            //列表条目显示
        jList.setVisibleRowCount(4);
        //组装
        //水平box 中间
        Box hBox = Box.createHorizontalBox();
        hBox.add(new JScrollPane(jList));
        JPanel jPanel = new JPanel();
        jPanel.add(jComboBox);
        hBox.add(jPanel);
        frame.add(hBox);
        //下部
        JPanel jPanelBottom = new JPanel();
            jPanelBottom.add(jLabel);
            jPanelBottom.add(jTextField);
            frame.add(jPanelBottom, BorderLayout.SOUTH);
        //最佳大小
        frame.pack();

            //可见
        frame.setVisible(true);


}
    public static void main(String[] args) {
            new ListTest2().init();
    }
}
