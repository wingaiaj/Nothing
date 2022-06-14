import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName declaredTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/20 16:56
 * @Version 1.0
 */
public class declaredTest {
    JFrame jFrame = new JFrame("JTableModelTest");
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
        myTableModel myTableModel = new myTableModel();
    //按钮设置
    JButton jButton = new JButton("显示信息");

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


        //JTable
        JTable jTable = new JTable(VData,VTitle);
        jTable.setModel(myTableModel);
        //按钮监听
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedColumn = jTable.getSelectedColumn();
                int selectedRow = jTable.getSelectedRow();
                String columnName = myTableModel.getColumnName(selectedColumn);
                Object valueAt = myTableModel.getValueAt(selectedRow,selectedColumn);
                System.out.println("当前选中列名为: "+columnName);
                System.out.println("当前选中名为: "+valueAt);
                System.out.println("当前选中列为: "+selectedColumn);
                System.out.println("当前选中行为: "+selectedRow);

            }
        });
        //添加
        jFrame.add(new JScrollPane(jTable));
        jFrame.add(jButton, BorderLayout.SOUTH);
        //可关
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小
        jFrame.pack();
        //可见
        jFrame.setVisible(true);
    }
        private class myTableModel extends AbstractTableModel {
            @Override
            public int getRowCount() {
                return VData.size();
            }

            @Override
            public int getColumnCount() {
                return VTitle.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return VData.get(rowIndex).get(columnIndex);
            }

            @Override
            public String getColumnName(int column) {

                return VTitle.get(column).toString();
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }
        }
    public static void main(String[] args) {
            new declaredTest().init();
    }
}
