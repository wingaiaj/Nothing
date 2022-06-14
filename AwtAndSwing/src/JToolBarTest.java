import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 * @ClassName JToolBarTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/15 15:19
 * @Version 1.0
 */
public class JToolBarTest {
        JFrame frame = new JFrame("测试工具条");
    JTextArea jTextArea = new JTextArea(6, 35);
        //声明工具条
    JToolBar jToolBar = new JToolBar();

    Action lastBut =new AbstractAction("上一首",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("上一首"+"\n");
        }
    };
    Action stopBut = new AbstractAction("暂停",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("暂停"+"\n");
        }
    };
    Action nextBut = new AbstractAction("下一首",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("下一首"+"\n");
        }
    };
    JButton but1 =new JButton(lastBut);
    JButton but2 =new JButton(stopBut);
    JButton but3 =new JButton(nextBut);
    JScrollPane jScrollPane = new JScrollPane(jTextArea);
    public void init(){
            //工具按钮添加
        jToolBar.add(but1);
        jToolBar.addSeparator();
        jToolBar.add(but2);
        jToolBar.addSeparator();
        jToolBar.add(but3);
        //主窗口添加
        frame.add(jToolBar, BorderLayout.NORTH);
        frame.add(jScrollPane);
        //设置窗口关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //设置大小
                frame.pack();
            //设置窗口可见
                frame.setVisible(true);
    }


    public static void main(String[] args) {
               new JToolBarTest().init();
    }
}
