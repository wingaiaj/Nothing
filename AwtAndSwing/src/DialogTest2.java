import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 * @ClassName DialogTest2
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/16 14:54
 * @Version 1.0
 */
public class DialogTest2 {
    //主窗体创建
    JFrame frame = new JFrame("测试文本输入对话框");
    //文本域
    JTextArea textArea = new JTextArea(6,30);
    //按钮
    JButton button = new JButton(new AbstractAction("弹出输入对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = JOptionPane.showInputDialog(frame, "", "输入对话框", JOptionPane.YES_NO_CANCEL_OPTION, null, new String[]{"22", "65", "55", "58"}, "a");
                    if(o != null){
                        textArea.append(o.toString());
                    }
            //            String s = JOptionPane.showInputDialog(frame, "请输入银行卡号", "输入对话框", JOptionPane.INFORMATION_MESSAGE);
//            if(s != null){
//                textArea.append(s);
//            }

        }
    });
    public void init(){
            //组装
                frame.add(textArea);
                frame.add(button, BorderLayout.SOUTH);
        //大小
                frame.pack();
        //可见
                frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DialogTest2().init();
    }
}
