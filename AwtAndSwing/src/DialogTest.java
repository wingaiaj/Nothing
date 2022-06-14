import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName DialogTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 18:49
 * @Version 1.0
 */
public class DialogTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试Dialog");
        //创建两个Dialog对话框，一个模式的，一个非模式的
        Dialog d1 = new Dialog(frame, "模式对话框", true);

        //设置Dialog对话框大小位置
        d1.setBounds(20, 30, 300, 200);

        //创建按钮
        JButton b1 = new JButton("打开模式对话框");
        JButton b2 = new JButton("确定");
        //创建文本
        TextField text = new TextField(20);
        //创建垂直box容器
        Box vBox = Box.createVerticalBox();
        vBox.add(text);
        vBox.add(b2);
        //添加到Dialog中
        d1.add(vBox);
        d1.pack();
        //给这两个按钮添加点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });


        frame.add(b1);

        frame.pack();

        frame.setVisible(true);
    }
}
