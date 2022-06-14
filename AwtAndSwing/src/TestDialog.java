import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 * @ClassName TestDialog
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/16 10:54
 * @Version 1.0
 */
public class TestDialog {
    //主窗口
    JFrame frame = new JFrame("测试消息对话框");
    //文本域
    JTextArea jTextArea = new JTextArea(6, 30);
    //按钮
    JButton okButton = new JButton(new AbstractAction("弹出消息对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, jTextArea.getText(), "消息对话框", JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\female.png"));
        }
    });


    public void init() {
        //组装

        frame.add(jTextArea);
        frame.add(okButton, BorderLayout.SOUTH);

        //设置窗口关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置最佳大小
        frame.pack();
        //设置为可见
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TestDialog().init();
    }
}
