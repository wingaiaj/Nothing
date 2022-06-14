import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 * @ClassName ConfirmDialogTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/16 14:30
 * @Version 1.0
 */
public class ConfirmDialogTest {
    //主窗体
    JFrame frame = new JFrame();
    //文本域
    JTextArea jTextArea = new JTextArea(6,30);
    //按钮
    JButton jButton = new JButton(new AbstractAction("弹出确认对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = jTextArea.getText();
            jTextArea.append("\n");
            int result = JOptionPane.showConfirmDialog(frame, text, "确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                jTextArea.append("用户点击了 是 按钮\n");
            }
            if (result == JOptionPane.NO_OPTION) {
                jTextArea.append("用户点击了 否 按钮\n");
            }
//            if (result == JOptionPane.OK_OPTION) {
//                jTextArea.append("用户点击了 确认 按钮\n");
//            }
            if (result == JOptionPane.CANCEL_OPTION) {
                jTextArea.append("用户点击了 取消 按钮\n");
            }
        }
    });

    public void init(){
        frame.add(jButton, BorderLayout.SOUTH);
        frame.add(jTextArea);

        //关闭窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //最佳大小
        frame.pack();
        //可见
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new ConfirmDialogTest().init();
    }
}
