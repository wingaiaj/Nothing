import javax.swing.*;
import java.awt.*;

/**
 * @ClassName FlowLayoutDemo
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 9:21
 * @Version 1.0
 */
public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口5");
        //通过setLayout的方法去设置容器的布局管理器
       // frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        //frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,40,20));
        //添加多个按钮到frame中
        for (int i = 0; i < 100 ; i++) {
            frame.add(new JButton("按钮"+i));
        }
        //设置最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
