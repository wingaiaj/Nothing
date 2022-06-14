import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName JProgressBarTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/17 10:20
 * @Version 1.0
 */
public class JProgressBarTest {
    //主窗口创建
    JFrame frame = new JFrame("测试进度条");
    //单选按钮创建
    JCheckBox jCheckbox = new JCheckBox("不确定进度");
    JCheckBox jCheckBox2 = new JCheckBox("不绘制边框");

    //进度条创建
    JProgressBar jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
    //垂直盒子
    Box VBox = Box.createVerticalBox();
    //水平盒子
    Box HBox = Box.createHorizontalBox();


    public void init() {
        //组装
        VBox.add(jCheckbox);
        VBox.add(jCheckBox2);

        HBox.add(VBox);
        HBox.add(jProgressBar);
        frame.add(HBox);
        //按钮监听
        jCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = jCheckbox.isSelected();

                jProgressBar.setIndeterminate(selected);
                jProgressBar.setStringPainted(!selected);

            }
        });
        jCheckBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = jCheckBox2.isSelected();
                jProgressBar.setBorderPainted(selected);
                jProgressBar.setBorderPainted(!selected);

            }
        });
        //调用构造器传入最大值
            sunThread sunThread = new sunThread(jProgressBar.getMaximum());
           //开启子线程
            new Thread(sunThread).start();
            //计时器
            Timer timer =new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jProgressBar.setValue(sunThread.getValue());
                }
            });
                    timer.start();

            //进度条监听
        jProgressBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value1 = jProgressBar.getValue();
                if(value1 == sunThread.getMaxvalue()){
                    timer.stop();
                }
            }
        });


        //默认为 显示
        jProgressBar.setStringPainted(true);
        //绘制边框
        jProgressBar.setBorderPainted(true);
        //设置大小
        frame.pack();
        //设置窗口可见
        frame.setVisible(true);


    }
        class sunThread implements Runnable {
            private int maxvalue;

            public int getMaxvalue() {
                return maxvalue;
            }

            private volatile int value = 0;

            public sunThread(int maxvalue) {
                this.maxvalue = maxvalue;
            }

            public int getValue() {
                return value;
            }

            public void run() {
                while (value < maxvalue) {
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    value++;
                }
            }
        }

    public static void main(String[] args) {
        new JProgressBarTest().init();
    }
}
