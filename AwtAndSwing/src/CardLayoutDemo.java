import com.sun.source.tree.CaseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName CradLayoutDemo
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 11:06
 * @Version 1.0
 */
public class CardLayoutDemo {
    public static void main(String[] args) {
        //创建frame 窗口
        Frame frame = new Frame("这里测试CardLayout");
        //创建panel容器
        Panel p = new Panel();
        //设置布局为cardLayout
        CardLayout cardLayout = new CardLayout();
        p.setLayout(cardLayout);
        //添加组件到容器
        String[] name = new String[]{"第一张", "第二张", "第三张", "第四张", "第五张"};
        for (int i = 0; i < name.length; i++) {
            p.add(name[i], new JButton(name[i]));
        }
        //将容器添加到frame
        frame.add(p);
        //创建panel容器 p2
        Panel p2 = new Panel();

        JButton b1 = new JButton("上一张");
        JButton b2 = new JButton("下一张");
        JButton b3 = new JButton("第一张");
        JButton b4 = new JButton("最后一张");
        JButton b5 = new JButton("第三张");

        //创建一个事件监听，监听按钮的点击动作
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();//这个字符串其实就是按钮上的文字
                switch (actionCommand) {
                    case "上一张":
                        cardLayout.previous(p);
                        break;
                    case "下一张":
                        cardLayout.next(p);
                        break;
                    case "第一张":
                        cardLayout.first(p);
                        break;
                    case "最后一张":
                        cardLayout.last(p);
                        break;
                    case "第三张":
                        cardLayout.show(p, "第三张");

                }
            }
        };
        //绑定事件监听和多个按钮
        b1.addActionListener(actionListener);
        b2.addActionListener(actionListener);
        b3.addActionListener(actionListener);
        b4.addActionListener(actionListener);
        b5.addActionListener(actionListener);
        //容器添加组件
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        //把p2容器添加到frame 南
        frame.add(p2, BorderLayout.SOUTH);

        //最佳大小
        frame.pack();

        //显示窗口
        frame.setVisible(true);
    }
}