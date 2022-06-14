import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

/**
 * @ClassName JTableTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/20 16:14
 * @Version 1.0
 */
public class JTableTest {
    JFrame frame = new JFrame("JTable测试");
    String[] arr = {"姓名", "年龄", "性别"};
    String[][] arr2 = {
            {"虎头", "12", "男"},
            {"我", "32", "男"},
            {"你", "44", "男"},
            {"他", "55", "女"},
            {"nobody", "21", "男"},
            {"nobody2", "34", "女"}
    };
    JTable jTable = new JTable(arr2, arr);

    public void init() {
            //todo 设置选择模式

//              jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//无限制
//              jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//单个连续范围
              jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单个

                //todo 设置列的大小
        TableColumn column = jTable.getColumn(arr[0]);
        column.setMinWidth(40);
        TableColumn column1 = jTable.getColumn(arr[2]);
        column1.setMaxWidth(50);
        frame.add(new JScrollPane(jTable));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JTableTest().init();
    }
}
