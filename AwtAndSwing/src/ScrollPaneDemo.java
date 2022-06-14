import javax.swing.*;
import java.awt.*;

/**
 * @ClassName ScrollPaneDemo
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 8:59
 * @Version 1.0
 */
public class ScrollPaneDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口3");
        //创建一个ScrollPane对象以及其他容器，都不能独立存在，必须依附于Window存在
        ScrollPane sp =new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //往ScrollPane中添加内容
            sp.add(new TextField("测试文本"));
            sp.add(new JButton("这是一个按钮"));

        //把ScrollPane添加到window窗口中也就是frame中
        frame.add(sp);

        frame.setBounds(100,100,500,300);
        frame.setVisible(true);
    }
}
