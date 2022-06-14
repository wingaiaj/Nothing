import javax.swing.*;
import java.awt.*;

/**
 * @ClassName BoxLayoutDemo1
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 15:37
 * @Version 1.0
 */
public class BoxLayoutDemo1 {
    public static void main(String[] args) {
        //frame窗口
        Frame frame = new Frame("测试");
        //box布局管理        水平
        BoxLayout boxLayout = new BoxLayout(frame,BoxLayout.X_AXIS);
        //设置frame的布局管理为 box布局管理
        frame.setLayout(boxLayout);
        //添加按钮
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));
        //设置最佳大小
        frame.pack();
        //设置为可见
        frame.setVisible(true);
    }
}
