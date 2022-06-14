import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName EventDome1
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/11 8:43
 * @Version 1.0
 */
public class EventDome1 {
    public static void main(String[] args) {
        //主窗口
        Frame  frame = new Frame("EventDome1测试");
        //文本框
        TextField textField = new TextField(30);
        //一个按钮
        JButton  b1 = new JButton("确定");

        //添加事件监听
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              textField.setText("hello,world");
            }
        });


        //添加到frame
        frame.add(textField, BorderLayout.NORTH);
        frame.add(b1);

        //最佳大小
        frame.pack();
        //显示可见
        frame.setVisible(true);

    }
}
