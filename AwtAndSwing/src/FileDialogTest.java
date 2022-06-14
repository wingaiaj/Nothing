import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName FileDialogTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 19:47
 * @Version 1.0
 */
public class FileDialogTest {
    public static void main(String[] args) {
        //主窗体
        Frame frame =new Frame();
        //对话框
        FileDialog fileDialog1 = new FileDialog(frame,"测试fileDialog1",FileDialog.LOAD);
        FileDialog fileDialog2 = new FileDialog(frame,"测试fileDialog2",FileDialog.SAVE);
        //按钮 读取 存入
        JButton b1 = new JButton("打开文件");
        JButton b2 = new JButton("保存文件");
        //垂直box容器
        Box vBox = Box.createVerticalBox();
        vBox.add(b1);
        vBox.add(b2);
        //点击按钮事件
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileDialog1.setVisible(true);//代码会阻塞

                //获取选择的文件
                String directory = fileDialog1.getDirectory();
                String file = fileDialog1.getFile();
                System.out.println("打开的文件路径为"+directory);
                System.out.println("打开的文件名称为"+file);
            }
        });
        b2.addActionListener(
                e-> {

                    fileDialog2.setVisible(true);
                    String directory1= fileDialog2.getDirectory();
                    String file1 = fileDialog2.getFile();
                    System.out.println("打开的文件路径为"+directory1);
                    System.out.println("打开的文件名称为"+file1);
                });
        //添加到frame
        frame.add(vBox);

        //最佳大小
        frame.pack();
        //显示frame
        frame.setVisible(true);
    }
}
