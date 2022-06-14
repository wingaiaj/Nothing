import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName Simple
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/19 16:11
 * @Version 1.0
 */
public class Simple {
    JFrame jFrame = new JFrame("简单编辑树");
    //创建按钮
    JButton addSiblingBtn = new JButton("添加兄弟节点");
    JButton addSonBtn = new JButton("添加子节点");
    JButton delBtn = new JButton("删除节点");
    JButton editBtn = new JButton("编辑当前节点");
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
        JTree jtree = new JTree(root);
        //添加
        jFrame.add(new JScrollPane(jtree));
        //让树可编辑
        jtree.setEditable(true);
        //获取树的model
        DefaultTreeModel model = (DefaultTreeModel) jtree.getModel();
        //add按钮设置监听
        addSiblingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前选中的节点路径
                DefaultMutableTreeNode lastSelectedPathComponent = (DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();
                //如果选中为空结束方法
                if (lastSelectedPathComponent == null) {
                    return;
                }
                //获取当前选中节点的父节点路径
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) lastSelectedPathComponent.getParent();
                //如果当前选中节点父节点为空 方法结束
                if (parent == null) {
                    return;
                }
                //创建新节点
                DefaultMutableTreeNode newPath = new DefaultMutableTreeNode("新节点");
                //model添加新节点 获取父索引
                int index = parent.getIndex(lastSelectedPathComponent);
                model.insertNodeInto(newPath, parent, index);
                //可见
                TreeNode[] pathToRoot = model.getPathToRoot(newPath);
                TreePath treePath = new TreePath(pathToRoot);
                jtree.scrollPathToVisible(treePath);

                //重绘
                jtree.updateUI();
            }
        });
        //添加子节点
        addSonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前选中对象 不为空
                DefaultMutableTreeNode lastSelectedPathComponent = (DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();
                if (lastSelectedPathComponent == null) {
                    return;
                }
                //新建节点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
                //当前选中节点添加
                lastSelectedPathComponent.add(newNode);

                //model 显示
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                jtree.scrollPathToVisible(treePath);
                //重绘ui
                jtree.updateUI();
            }
        });
        // 监听按钮删除子节点
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //当前选中节点
                DefaultMutableTreeNode lastSelectedPathComponent = (DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();
                //获取当前选中节点的父节点路径
                //删除子节点 从父路径开始删除 父节点不为空 选中节点不为空
                if (lastSelectedPathComponent != null && lastSelectedPathComponent.getParent() != null) {
                    model.removeNodeFromParent(lastSelectedPathComponent);
                }
            }
        });
        //编辑按钮监听
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreePath selectionPath = jtree.getSelectionPath();
                if (selectionPath != null) {
                    jtree.startEditingAtPath(selectionPath);
                }
            }
        });
        //添加按钮
        JPanel jPanel = new JPanel();
        jPanel.add(addSiblingBtn);
        jPanel.add(addSonBtn);
        jPanel.add(delBtn);
        jPanel.add(editBtn);
        jFrame.add(jPanel, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Simple().init();
    }
}
