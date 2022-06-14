import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * @ClassName SimpleMenu
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/11 9:57
 * @Version 1.0
 */
public class SimpleMenu {
    //主窗口
    Frame frame = new Frame();
    //菜单条
     MenuBar menuBar = new MenuBar();
    //菜单组件
    Menu fileMenu =  new Menu("文件");
    Menu editMenu =  new Menu("编辑");
    Menu formatMenu =  new Menu("格式");
    //创建菜单项组件
    MenuItem autoRow =new MenuItem("自动换行");
    MenuItem copy =new MenuItem("复制");
    MenuItem paste =new MenuItem("粘贴");
    MenuItem notes =new MenuItem("注释",new MenuShortcut(KeyEvent.VK_Q,true));
    MenuItem cancel =new MenuItem("取消注释");
    //文本域
    TextArea textArea = new TextArea(6,40);

    //组装
    public void init(){
        //实现注释功能 监听注释
        notes.addActionListener(e->{
            textArea.append("您点击了菜单项"+e.getActionCommand()+"\n");
        });
        //关闭窗口监听
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //format添加菜单项组件
        formatMenu.add(notes);
        formatMenu.add(cancel);

        //editMenu添加菜单项组件
        editMenu.add(autoRow);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(formatMenu);//菜单项放入菜单

        //fileMenu添加菜单项组件

        //添加到菜单条
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        //添加至主窗口
        frame.setMenuBar(menuBar);
        frame.add(textArea, BorderLayout.CENTER);

        //设置最佳大下
        frame.pack();

        //设置可见
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new SimpleMenu().init();
    }
}
