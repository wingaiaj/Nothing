import javax.swing.*;
import java.awt.*;

/**
 * @ClassName BorderLayout
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 9:33
 * @Version 1.0
 */
public class BorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口6");
        //给frame设置borderLayout的布局管理器
        frame.setLayout(new java.awt.BorderLayout(30,10));
        //往frame的指定区域添加组件
            frame.add(new JButton("北侧按钮"), java.awt.BorderLayout.NORTH);//北侧区域
            frame.add(new JButton("南侧按钮"), java.awt.BorderLayout.SOUTH);//南侧区域
            frame.add(new JButton("东侧按钮"), java.awt.BorderLayout.EAST);//东侧区域
            frame.add(new JButton("西侧按钮"), java.awt.BorderLayout.WEST);//西侧区域
            frame.add(new JButton("中间按钮"), java.awt.BorderLayout.CENTER);//中间侧区域


        frame.pack();
    frame.setVisible(true);
    }
}
