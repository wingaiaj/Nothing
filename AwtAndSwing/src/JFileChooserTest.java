import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName JFileChooserTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/16 9:14
 * @Version 1.0
 */
public class JFileChooserTest {
    //主窗口创建
    JFrame jFrame = new JFrame("文件选择测试");
    //位图
    BufferedImage image;
    //画布类
    public class drawI extends JPanel{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);
        }
    }
    //画布对象创建
    drawI di = new drawI();
    //菜单栏
    JMenuBar jMenuBar = new JMenuBar();
    //菜单
    JMenu file = new JMenu("文件");
    //菜单条
    JMenuItem openFile = new JMenuItem(new AbstractAction("打开") {
        @Override
        public void actionPerformed(ActionEvent e) {
                //创建文件选择器对象
                    JFileChooser jFileChooser = new JFileChooser();
                    //调用打开文件选择对话框
                    jFileChooser.showOpenDialog(jFrame);
                //获取用户查看的文件
            File selectedFile = jFileChooser.getSelectedFile();
                //给位图对象赋值
            try {
                image = ImageIO.read(selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                //重绘
            di.repaint();
        }
    });

    JMenuItem saveFile = new JMenuItem(new AbstractAction("保存") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //创建文件选择器
            JFileChooser jFileChooser = new JFileChooser();
            //显示保存文件对话框
            int i = jFileChooser.showSaveDialog(jFrame);
            //获取用户查看的文件
            File selectedFile = jFileChooser.getSelectedFile();
            //给位图赋值
            try {
                ImageIO.write(image,"JPEG",selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //重绘
                    di.repaint();
        }

    });




    public void init(){
    //画布大小
        di.setPreferredSize(new Dimension(500,500));
        //组装
        file.add(openFile);
        file.add(saveFile);
        jMenuBar.add(file);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(di);
        //窗口大小
        jFrame.setBounds(100,100,500,500);
        jFrame.pack();
        //设置窗口可见
        jFrame.setVisible(true);

    }
    public static void main(String[] args) {
        new JFileChooserTest().init();
    }
}
