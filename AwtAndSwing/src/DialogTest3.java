import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 * @ClassName DialogTest3
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/16 15:19
 * @Version 1.0
 */
public class DialogTest3 {
    //主窗体
    JFrame frame = new JFrame("测试OptionDialog");
    //文本域
    JTextArea jTextArea = new JTextArea(6,30);
    //按钮
    JButton jButton = new JButton(new AbstractAction("弹出选项对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = JOptionPane.showOptionDialog(frame, "请选择号码", "选择对话框"
                    , JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"大号", "中号", "小号"}, "大号");
            switch (i) {
                case 0:
                    jTextArea.append("大号");
                    break;
                case 1:
                    jTextArea.append("中号");
                    break;
                case 2:
                    jTextArea.append("小号");
                    break;
            }
        }
    });

    public void init(){
        frame.add(jTextArea);
        frame.add(jButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
       new DialogTest3().init();
    }
}
