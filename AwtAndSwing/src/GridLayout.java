import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

/**
 * @ClassName GridLayout
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 10:12
 * @Version 1.0
 */
public class GridLayout {
    public static void main(String[] args) {
        //创建frame 窗口
        Frame frame =new Frame("计算器");//frame默认的管理器是BorderLayout边界布局管理器
        //设置布局
         frame.setLayout(new BorderLayout());

        //添加文本 装在容器内
        Panel p1 =new Panel();
        p1.add(new TextField(30));
        //创建网格容器
        Panel p = new Panel();//panel默认的管理器是流式管理器 flowlayout
        p.setLayout(new java.awt.GridLayout(3,5,4,4));
        //添加容器
        for (int i = 0; i < 10; i++) {//0-9
            p.add(new JButton(String.valueOf(i)));
        }
        //手动添加
        p.add(new JButton("+"));
        p.add(new JButton("-"));
        p.add(new JButton("*"));
        p.add(new JButton("/"));
        p.add(new JButton("."));

        //往窗口添加容器
        frame.add(p1,BorderLayout.NORTH);
        frame.add(p,BorderLayout.CENTER);

        //设置最佳大小
        frame.pack();

        //设置窗口可见
        frame.setVisible(true);
    }
}
