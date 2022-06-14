import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.GridLayout;

/**
 * @ClassName BorderTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/14 18:58
 * @Version 1.0
 */
public class BorderTest {
    //创建主窗口
    JFrame frame = new JFrame("测试边框");

    public void init(){
        //组装视图
        //设置主窗体的布局为网格布局
            frame.setLayout(new GridLayout(2,4));
        //填充不同的jPanel组件
        //创建BevelBorder
        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.red, Color.green, Color.blue, Color.gray);
                frame.add(getJPanel(bevelBorder,"BevelBorder"));
        //创建LineBorder
        Border lineBorder = BorderFactory.createLineBorder(Color.orange, 10);
                frame.add(getJPanel(lineBorder,"LineBorder"));
         //创建EmptyBorder
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 5, 20, 10);
                frame.add(getJPanel(emptyBorder,"EmptyBorder"));
          //创建EtchedBorder
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.red,Color.green);
                frame.add(getJPanel(etchedBorder,"EtchedBorder"));
          //创建TitledBorder
        TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.orange,10),"测试标题",TitledBorder.LEFT,TitledBorder.BELOW_BOTTOM);
                frame.add(getJPanel(titledBorder,"TitledBorder "));
           //创建MatteBorder
        MatteBorder matteBorder = new MatteBorder(10,5,20,10,Color.green);
                frame.add(getJPanel(matteBorder,"MatteBorder"));
           //创建CompoundBorder
        CompoundBorder compoundBorder = new CompoundBorder(new LineBorder(Color.red,10),titledBorder);
                 frame.add(getJPanel(compoundBorder,"CompoundBorder "));
        //设置最佳大小设置可见
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //此方法用来设置不同边框的jPanel
    public JPanel getJPanel(Border border,String name){
        JPanel jPanel = new JPanel();
        jPanel.add(new Label(name));
        jPanel.setBorder(border);
        return jPanel;
    }
    public static void main(String[] args) {
            new BorderTest().init();
    }
}
