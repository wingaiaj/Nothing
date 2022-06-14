import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

/**
 * @ClassName PanelDemo
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 8:27
 * @Version 1.0
 */
public class PanelDemo {
    public static void main(String[] args) {
        //创建window对象,因为，panel以及其他容器，都不能独立存在，必须依附于Window存在
        Frame frame =new Frame("测试窗口二");
        //创建一个Panel对象 先创建window对象
        Panel panel = new Panel( );
        //创建一个文本框和一个按钮，并且把他们放入到panel容器中
        panel.add(new TextField("文本测试"));
        panel.add(new JButton("测试按钮"));
        //把panel放入window中
        frame.add(panel);
        //设置window的大小和位置
        //frame.setLocation(100,100);
        //frame.setSize(500,500);
            //此方法同时设置位置与大小
        frame.setBounds(100,100,500,300);
        //让window为可见
        frame.setVisible(true);

    }
}
