import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @ClassName DefaultModelTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/20 18:41
 * @Version 1.0
 */
public class DefaultModelTest {
    JFrame jFrame = new JFrame("测试默认JTableModel");
    private String[] title = {"姓名", "年龄", "性别"};
    private String[][] data = {
            {"嘉然", "20", "女"},
            {"向晚", "20", "女"},
            {"珈乐", "19", "女"},
            {"乃琳", "20", "女"},
            {"贝拉", "19", "女"}
    };

    //todo 定义集合
    Vector VTitle = new Vector();
    Vector<Vector> VData = new Vector<>();


    //按钮
    JButton addRowBtn = new JButton("添加一行");
    JButton addColumn = new JButton("添加一列");
    JButton delRowBtn = new JButton("删除一行");


    public void init() {
        //todo 数组装集合
        for (int i = 0; i < title.length; i++) {
            VTitle.add(title[i]);
        }

        for (int i = 0; i < data.length; i++) {
            Vector vector = new Vector();
            for (int j = 0; j < data[i].length; j++) {

                vector.add(data[i][j]);
            }
            VData.add(vector);
        }
      DefaultTableModel Model = new DefaultTableModel(VData,VTitle);
    JTable jTable = new JTable(Model);
        //添加行按钮监听
        addRowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.addRow(new String[]{"xx", "xx", "x"});
            }
        });
        //添加列按钮监听
        addColumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.addColumn("职业");
            }
        });
        //删除行按钮监听
        delRowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable.getSelectedRow();
                    Model.removeRow(selectedRow);
                }
        });
        JPanel jPanel = new JPanel();
        jPanel.add(addRowBtn);
        jPanel.add(addColumn);
        jPanel.add(delRowBtn);
        jFrame.add(new JScrollPane(jTable));
        jFrame.add(jPanel, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new DefaultModelTest().init();
    }
}
