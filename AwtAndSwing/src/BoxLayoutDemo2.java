import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

/**
 * @ClassName BoxLayoutDemo2
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 15:47
 * @Version 1.0
 */
public class BoxLayoutDemo2 {
    public static void main(String[] args) {
        //创建frame窗口
        Frame frame =new Frame();
        //创建水平box容器
        Box box1 = Box.createHorizontalBox();

        //向水平box容器中添加组件
        box1.add(new Button("水平按钮1"));
        box1.add(new Button("水平按钮2"));

        //创建垂直box容器
        Box box2 = Box.createVerticalBox();

        //向垂直box容器中添加组件
        box2.add(new Button("垂直按钮1"));
        box2.add(new Button("垂直按钮2"));

        //将两个box容器添加到frame中
        frame.add(box1);//为中间
        frame.add(box2, BorderLayout.SOUTH);//设置为南 避免覆盖

        //设置最佳大小
        frame.pack();

        //设置frame可见
        frame.setVisible(true);


//        Frame frame =new Frame("测试");
//
//        Panel p1 = new Panel();
//        BoxLayout boxLayout = new BoxLayout(p1,BoxLayout.X_AXIS);
//        p1.setLayout(boxLayout);
//        p1.add(new Button("水平按钮一"));
//        p1.add(new Button("水平按钮二"));
//
//        frame.add(p1);
//
//        Panel p2 = new Panel();
//        BoxLayout boxLayout1 = new BoxLayout(p2,BoxLayout.Y_AXIS);
//        p2.setLayout(boxLayout1);
//        p2.add(new Button("垂直按钮一"));
//        p2.add(new Button("垂直按钮二"));
//
//        frame.add(p2, BorderLayout.SOUTH);
//
//        frame.pack();
//        frame.setVisible(true);
    }
}
