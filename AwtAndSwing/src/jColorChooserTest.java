import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 * @ClassName JcolorChooserTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/16 9:06
 * @Version 1.0
 */
public class jColorChooserTest {
    //主窗体
    JFrame frame = new JFrame("测试颜色选择器");
    //文本域
    JTextArea jTextArea = new JTextArea("？？？",6,30);
    //按钮
    JButton jButton = new JButton(new AbstractAction("改变文本框的背景颜色") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //颜色选择器
            Color result = JColorChooser.showDialog(frame, "颜色选择器", Color.white);
            //设置文本域背景颜色
            jTextArea.setBackground(result);

        }
    });
    public void init(){
        //组装
        frame.add(jTextArea);
        frame.add(jButton, BorderLayout.SOUTH);
        //最佳大小
        frame.pack();
        //设置可见
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new jColorChooserTest().init();
    }
}
