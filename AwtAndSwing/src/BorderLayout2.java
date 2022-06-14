import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

/**
 * @ClassName BorderLayout
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 9:33
 * @Version 1.0
 */
public class BorderLayout2 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口6");
        //给frame设置borderLayout的布局管理器
        frame.setLayout(new java.awt.BorderLayout(30,10));
        //往frame的指定区域添加组件

            frame.add(new JButton("北侧按钮"), java.awt.BorderLayout.NORTH);//北侧区域

        frame.add(new JButton("南侧按钮"), java.awt.BorderLayout.SOUTH);//南侧区域
        //    frame.add(new JButton("中间按钮"), java.awt.BorderLayout.CENTER);//中间侧区域

            //frame.add(new TextField("测试文本框"));

        // 当某个区域 不添加内容时 这个区域不会空出来 会被中间区域所占

        //当向一个区域添加 两个组件时 后面的组件覆盖之前组件  需要把组件都添加至容器中 实现一个区域组件不覆盖
        Panel p = new Panel();

        //默认添加在中间
        p.add(new JButton("中间按钮"), BorderLayout.CENTER);
        p.add(new TextField("测试文本框"));

        //添加容器
        frame.add(p);

        frame.pack();

    frame.setVisible(true);
    }
}
