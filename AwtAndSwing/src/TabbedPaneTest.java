import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.File;

/**
 * @ClassName TabbedPaneTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/17 9:34
 * @Version 1.0
 */
public class TabbedPaneTest {
    //主窗体
    JFrame frame = new JFrame();
    //标签页
    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

    public void init() {
        //设置窗口大小
        frame.setBounds(400,400,400,400);
        //窗口大小不可变

        tabbedPane.addTab("用户管理", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\open.gif"), new JList<String>(new String[]{"用户一", "用户二", "用户三"}));
        tabbedPane.addTab("商品管理", new JList<String>(new String[]{"用户一", "用户二", "用户三"}));
        tabbedPane.addTab("订单管理", new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\open.gif"), new JList<String>(new String[]{"订单一", "订单二", "订单三"}));
        //设置索引为2的标签为默认选中
        tabbedPane.setSelectedIndex(1);
        //设置第一个标签为不可用
        tabbedPane.setEnabledAt(0, false);
        //设置监听 选中时弹出对话框
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //获取选中的标签菜单 索引
                int selectedIndex = tabbedPane.getSelectedIndex();
                //JOptionPanel 创建消息对话框
                JOptionPane.showMessageDialog(frame, "选中了第"+(selectedIndex+1)+"个标签" );
            }
        });
            //添加到主窗口
        frame.add(tabbedPane);

        //设置窗口大小
        frame.pack();
        //设置窗口可见
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TabbedPaneTest().init();
    }
}
