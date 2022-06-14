import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName ReadAnSaveImage
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/13 15:35
 * @Version 1.0
 */
public class ReadAnSaveImage {
    //创建主窗体
        Frame frame =new Frame("测试ImageIO");
    //高和宽
    private final int width = 500;
    private final int height = 300;
    //创建位图
    BufferedImage image ;


    //创建画布
     drawCvs dc = new drawCvs();
    //创建菜单栏
    MenuBar menuBar = new MenuBar();
    //创建菜单组件
    Menu file = new Menu("文件");
    //创建菜单条目
    MenuItem open = new MenuItem("打开");
    MenuItem save = new MenuItem("另存为");


    public  void init(){

        //设置监听事件
    open.addActionListener(e -> {
        //打开一个文件对话框
        FileDialog fileDialog = new FileDialog(frame,"打开图片",FileDialog.LOAD);
        //设置可见
        fileDialog.setVisible(true);
        //获取路径
        String directory = fileDialog.getDirectory();
        //获取文件名称
        String file = fileDialog.getFile();
        try {
            image = ImageIO.read(new File(directory, file));
            dc.repaint();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    });

    save.addActionListener(e -> {
        FileDialog sDialog = new FileDialog(frame,"另存为",FileDialog.SAVE);
        //设置对话框可见
        sDialog.setVisible(true);
        //获取路径
        String dir = sDialog.getDirectory();
        String filename = sDialog.getFile();
        try {
            ImageIO.write(image,"JPEG",new File(dir,filename));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });



//窗口监听退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }
        });

        //组装
        dc.setPreferredSize(new Dimension(width,height));
        file.add(open);
        file.add(save);
        menuBar.add(file);
        frame.setMenuBar(menuBar);
        frame.add(dc);
        //设置窗口大小
        frame.setBounds(300,300,width,height);
        //设置最佳大小
        frame.pack();
        //设置主窗口可见
        frame.setVisible(true);
    }


    private class drawCvs extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);
        }
    }

    public static void main(String[] args) {
            new ReadAnSaveImage().init();
    }
}
