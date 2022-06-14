import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * @ClassName simpleselectionandlisetener
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/19 17:22
 * @Version 1.0
 */
public class simpleselectionandlisetener {
    JFrame jFrame = new JFrame("测试树");

    //定义几个初始结点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");
    //文本域创建
    JTextArea jTextArea = new JTextArea();

    //
    public void init() {
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);
        //创建树
        JTree jTree = new JTree(root);
        //获取selectionModel
        TreeSelectionModel selectionModel = jTree.getSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);//单选
        //对数添加监听
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath newLeadSelectionPath = e.getNewLeadSelectionPath();
                jTextArea.append(newLeadSelectionPath.toString()+"\n");
            }
        });
        //组装
        //水平盒子
        Box hBox = Box.createHorizontalBox();
        hBox.add(new JScrollPane(jTree));
        hBox.add(new JScrollPane(jTextArea));

        jFrame.add(hBox);
        //可关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //最佳大小
        jFrame.pack();
        //显示
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
            new simpleselectionandlisetener().init();
    }
}
