import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

/**
 * @ClassName renderTets
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/19 20:49
 * @Version 1.0
 */
public class renderTest {
    JFrame jFrame = new JFrame("测试");

    DefaultMutableTreeNode  ny = new DefaultMutableTreeNode("弄玉");
    DefaultMutableTreeNode  myFriend = new DefaultMutableTreeNode("我的好友");
    DefaultMutableTreeNode  lqz = new DefaultMutableTreeNode("李清照");
    DefaultMutableTreeNode  lb = new DefaultMutableTreeNode("李白");
    DefaultMutableTreeNode  sgl = new DefaultMutableTreeNode("苏格拉底");
    DefaultMutableTreeNode  ht = new DefaultMutableTreeNode("虎头");

    public void init() {
        myFriend.add(lqz);
        myFriend.add(ny);
        myFriend.add(lb);
        myFriend.add(sgl);
        myFriend.add(ht);
        JTree jTree = new JTree(myFriend);
        myRender myRender = new myRender();
        jTree.setCellRenderer(myRender);
        jFrame.add(new JScrollPane(jTree));

        jFrame.pack();
        jFrame.setVisible(true);
    }
public class myRender extends JPanel implements TreeCellRenderer {
    private ImageIcon icon;
    private String name;
    private Color background;
    private Color foreground;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        this.icon = new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\friend\\"+value+".gif");
        this.name = value.toString();
        this.background = hasFocus ? background : new Color(112, 115, 121);
        this.foreground = hasFocus ? new Color(212, 124, 225) : new Color(112, 115, 221);
        return this;
    }

    @Override
    public void paint(Graphics g) {
        int iconWidth = icon.getIconWidth();
        g.setColor(background);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(foreground);

        g.drawImage(this.icon.getImage(),getWidth()/2-iconWidth/2,10,null);
        g.setFont(new Font("StSong",Font.BOLD,18));
        g.drawString(this.name,getWidth()/2-name.length()*20/2,icon.getIconHeight()+30);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80,80);
    }
}

    public static void main(String[] args) {
    new renderTest().init();
    }
}
