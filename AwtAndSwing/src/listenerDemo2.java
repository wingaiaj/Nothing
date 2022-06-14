import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName listenerDemo2
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/11 9:38
 * @Version 1.0
 */
public class listenerDemo2 {
    public static void main(String[] args) {
        //创建主窗口
        Frame frame = new Frame("listenerDemo2测试");
        //设置主窗口大小
        frame.setBounds(200,200,500,300);
       //设置主窗口监听
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序
                System.exit(0);
            }
        });


        //设置最佳大小
        frame.pack();
        //设置窗口可见
        frame.setVisible(true);
    }
}
