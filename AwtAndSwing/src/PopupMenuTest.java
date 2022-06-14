import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * @ClassName PopuMenuTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/11 11:07
 * @Version 1.0
 */
public class PopupMenuTest {
    //主窗口的创建
    Frame frame = new Frame("测试PopupMenuTest");
    //创建PopupMenu菜单组件
    PopupMenu popupMenu = new PopupMenu();
    //创建Menuitem菜单条目
    MenuItem notes = new MenuItem("注释");
    MenuItem cancelNotes = new MenuItem("取消注释");
    MenuItem copy = new MenuItem("复制");
    MenuItem save = new MenuItem("保存");
    //创建panel容器
    Panel panel = new Panel();
    //创建文本框
    TextArea textarea = new TextArea("这是一个测试");
    //组装
    public void init() {

        //监听事件
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                textarea.append("您输入的是" + actionCommand+"\n");
            }
        };
        //注册监听
        notes.addActionListener(actionListener);
        cancelNotes.addActionListener(actionListener);
        copy.addActionListener(actionListener);
        save.addActionListener(actionListener);

        //Menuitem菜单条目添加PopupMenu容器
        popupMenu.add(notes);
        popupMenu.add(cancelNotes);
        popupMenu.add(copy);
        popupMenu.add(save);

        //将PopupMenu添加到panel容器
        panel.add(popupMenu);
        //设置panel的大小
        panel.setPreferredSize(new Dimension(400, 300));
        //给panel设置监听 注册监听
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger) {
                    //显示popupmenu
                    popupMenu.show(panel, e.getX(), e.getY());
                }
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }
        });
        //添加文本域和panel
            frame.add(textarea, BorderLayout.CENTER);
            frame.add(panel,BorderLayout.SOUTH);

        //最佳大小
            frame.pack();
        //显示窗口
            frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PopupMenuTest().init();
    }
}
