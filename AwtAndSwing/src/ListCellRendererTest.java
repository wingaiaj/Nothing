import javax.swing.*;
import java.awt.*;

/**
 * @ClassName ListCellRendererTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/18 19:25
 * @Version 1.0
 */
public class ListCellRendererTest {
    //主窗口
    JFrame frame = new JFrame("好友列表");
    String[] Friend = new String[]{"李清照", "苏格拉底", "李白", "弄玉", "虎头"};
    JList jList = new JList(Friend);

    public void init(){
        jList.setCellRenderer(new Randerer());
        frame.add(jList);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
//创建cellRenderer类
    private class Randerer extends  JPanel implements ListCellRenderer {
    //定义成员变量
    private ImageIcon icon;
    private String name;
    //定义文本域
    private JTextArea text;
    //背景色
    private Color background;
    //前景色
    private Color foreground;
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //给成员变量赋值
        this.name = value.toString();
        this.icon = new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\friend\\"+this.name+".gif");
      this.text = new JTextArea("这个好友是"+name);
        //是否选中
        this.background = isSelected? list.getSelectionBackground():list.getBackground();
        this.foreground = isSelected? list.getSelectionForeground():list.getForeground();

        //返回组件 所以继承JPanel类
        return this;
    }
//绘制组件
    @Override
    public void paint(Graphics g) {
    //图像的宽
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        g.setColor(background);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(foreground);
    //头像绘制
        g.drawImage(icon.getImage(),getWidth()/2-iconWidth/2,10,null);
        //绘制名字
        //设置字体
        g.setFont(new Font("Sanserif",Font.BOLD,18));
        g.drawString(this.name,getWidth()/2-name.length()*10,30+iconHeight);

    }
//设置面版大小

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(60,80);
    }
}


    public static void main(String[] args) {
    new ListCellRendererTest().init();
    }
}
