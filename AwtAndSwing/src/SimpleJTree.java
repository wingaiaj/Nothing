import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName SimpleJTree
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/19 13:56
 * @Version 1.0
 */
public class SimpleJTree {
    JFrame jFrame = new JFrame("简单树");

        //创建对象代表节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode gd = new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode gx = new DefaultMutableTreeNode("广西");
        DefaultMutableTreeNode fs = new DefaultMutableTreeNode("佛山");
        DefaultMutableTreeNode st = new DefaultMutableTreeNode("汕头");
        DefaultMutableTreeNode nin = new DefaultMutableTreeNode("南宁");
        DefaultMutableTreeNode gl = new DefaultMutableTreeNode("桂林");

    public void init() {

        //组装节点
        gd.add(fs);
        gd.add(st);
        gx.add(nin);
        gx.add(gl);
        root.add(gd);
        root.add(gx);
        //创建树
        JTree tree = new JTree(root);

        //添加
        jFrame.add(new JScrollPane(tree));



        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleJTree().init();
    }
}
