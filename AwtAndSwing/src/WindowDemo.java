import java.awt.*;

/**
 * @ClassName WindowDemo
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 8:21
 * @Version 1.0
 */
public class WindowDemo {
    public static void main(String[] args) {
        //创建一个窗口
        Frame frame=new Frame("测试窗口");
        //设置窗口位置和大小
        frame.setLocation(100,100);
        frame.setSize(500,300);//单位为像素
        //设置窗口可见
        frame.setVisible(true);
    }

}
