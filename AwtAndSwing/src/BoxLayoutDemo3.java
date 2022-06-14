import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

/**
 * @ClassName BoxLayoutDemo3
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 16:17
 * @Version 1.0
 */
public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        //创建窗口
        Frame frame = new Frame("测试窗口");
        //创建水平容器box
        Box hBox = Box.createHorizontalBox();
        //添加按钮 和分割
        hBox.add(new Button("水平按钮一"));
        hBox.add(Box.createHorizontalGlue());//该水平分割在两个方向上都可以拉伸 静态方法
        hBox.add(new Button("水平按钮二"));
        hBox.add(Box.createHorizontalStrut(30));//水平分割 方向固定 静态方法
        hBox.add(new Button("水平按钮三"));

        //添加到frame
        frame.add(hBox,BorderLayout.NORTH);//设置位置

        //创建垂直容器box
        Box vbox = Box.createVerticalBox();
        //添加按钮 和分割
        vbox.add(new Button("垂直按钮1"));
        vbox.add(Box.createVerticalGlue());//该垂直分割在两个方向上都可以拉伸 静态方法
        vbox.add(new Button("垂直按钮2"));
        vbox.add(Box.createVerticalStrut(30));//水平分割 方向固定 静态方法
        vbox.add(new Button("垂直按钮3"));
        //添加到frame
        frame.add(vbox, BorderLayout.CENTER);


        //设置最佳大小
        frame.pack();
        //设置可见
        frame.setVisible(true);
    }
}
