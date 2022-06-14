import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * @ClassName extendsDefalutCellTreecRender
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/19 19:27
 * @Version 1.0
 */
public class extendsDefaultCellTreeRender {
    JFrame jFrame = new JFrame("根据节点类自定义图标");
    //创建节点
    DefaultMutableTreeNode databaseHome = new DefaultMutableTreeNode(new DataNode("数据库导航", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\root.gif")));
    DefaultMutableTreeNode database_sal = new DefaultMutableTreeNode(new DataNode("公司工资数据库", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\database.gif")));
    DefaultMutableTreeNode database_cus = new DefaultMutableTreeNode(new DataNode("公司客户数据库", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\database.gif")));
    DefaultMutableTreeNode tb_emp = new DefaultMutableTreeNode(new DataNode("员工表", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\table.gif")));
    DefaultMutableTreeNode tb_grd = new DefaultMutableTreeNode(new DataNode("考勤表", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\table.gif")));
    DefaultMutableTreeNode tb_phe = new DefaultMutableTreeNode(new DataNode("联系方式表", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\table.gif")));
    DefaultMutableTreeNode primary_id = new DefaultMutableTreeNode(new DataNode("员工ID", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\index.gif")));
    DefaultMutableTreeNode column_name = new DefaultMutableTreeNode(new DataNode("姓名", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\column.gif")));
    DefaultMutableTreeNode column_gender = new DefaultMutableTreeNode(new DataNode("性别", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\database\\column.gif")));

    //自定义类
    private class DataNode {
        public DataNode(String name, Icon image) {
            this.name = name;
            this.image = image;
        }

        public String name;
        public Icon image;

    }

    //自定义类继承
    private class myrender extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            DataNode userObject = (DataNode) node.getUserObject();
            setText(userObject.name);
            setIcon(userObject.image);

            return this;
        }
    }


    public void init() {
        tb_phe.add(primary_id);
        tb_phe.add(column_name);
        tb_phe.add(column_gender);
        database_sal.add(tb_emp);
        database_sal.add(tb_grd);
        database_cus.add(tb_phe);
        databaseHome.add(database_sal);
        databaseHome.add(database_cus);
        JTree jTree = new JTree(databaseHome);
        jTree.setCellRenderer(new myrender());
        jFrame.add(new JScrollPane(jTree));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);


    }

    public static void main(String[] args) {
        new extendsDefaultCellTreeRender().init();
    }
}
