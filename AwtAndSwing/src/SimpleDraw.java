import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName SimpleDraw
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/11 17:06
 * @Version 1.0
 */
public class SimpleDraw {
        //变量创建 用来判断绘制具体的图
    private final String rect = "Rect";
    private final String oval = "Oval";

    private String sign = "";

        //主窗口创建
        Frame frame = new Frame("绘图测试");

        //两个按钮的绘制
        JButton drawRect =new JButton("绘制矩形");
        JButton drawOval =new JButton("绘制圆形");

        //装按钮容器
        Panel panel = new Panel();

        //自定类 继承 canvas 重写 paint方法
    public class MyCanvas extends Canvas {
            @Override
            public void paint(Graphics g) {
                //设置画笔颜色 为黑色
                g.setColor(Color.black);
                //判断用户点击的按钮
                    //绘制矩形
                if (sign.equals(rect)) {
                    g.drawRect(100, 100, 200, 150);
                }
                    //绘制圆形
                else if (sign.equals(oval)) {
                    g.drawOval(100, 100, 200, 150);
                }
            }
        }

        //创建Canvas对象 调用方法
   MyCanvas myCanvas = new MyCanvas();

    //组装
    public void init(){
        //按钮1监听
        drawOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //给变量赋值判断图形
                sign = oval;

                //此方法 清除组件 调用了内部paint方法
                myCanvas.repaint();

            }
        });
        //按钮2监听
        drawRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //给变量赋值判断图形
                sign = rect;
                //此方法 清除组件 调用了内部paint方法
                myCanvas.repaint();

            }
        });
        //设置画布的大小
        myCanvas.setPreferredSize(new Dimension(500,300));
        //组装
            //按钮容器
        panel.add(drawRect);
        panel.add(drawOval);

       //画布
        frame.add(myCanvas);
        //按钮容器  指定位置
        frame.add(panel, BorderLayout.SOUTH);

        //设置主窗口最佳大小
        frame.pack();

        //设置主窗口为可见
    frame.setVisible(true);


    }
    public static void main(String[] args) {
            new SimpleDraw().init();
    }
}
