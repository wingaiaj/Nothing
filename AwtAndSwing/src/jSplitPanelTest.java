import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * @ClassName jSplitPanelTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/17 8:03
 * @Version 1.0
 */
public class jSplitPanelTest {
    //主窗体创建
    JFrame frame = new JFrame();
    //文本域创建
    TextArea textArea = new TextArea();
    //book类对象创建
    book b1 = new book("java自学宝典", "国内关于 Java 编程最全面的图书 \n 看得懂 ， 学得会",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\android.png"));
    book b2 = new book("轻量级的JAVAEE企业应用实战","SSM整合开发的经典图书，值的拥有",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\ee.png"));
    book b3 = new book("Android基础教程","全面介绍Android平台应用程序\n 开发的各方面知识",new ImageIcon("C:\\Users\\xpower\\Desktop\\AwtAndSwing\\image\\java.png"));
   book[] books = new book[]{b1,b2,b3};
    //列表框
    JList<book> list = new JList<>(books);
    //jLabel用来存放图像
    JLabel jLabel = new JLabel();


    public void init(){
        //添加监听
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                book selectedValue = list.getSelectedValue();
              jLabel.setIcon(selectedValue.getImage());
              textArea.setText(selectedValue.getDesc());

            }
        });

        jLabel.setPreferredSize(new Dimension(220,330));
        textArea.setPreferredSize(new Dimension(220,70));
        list.setPreferredSize(new Dimension(150,400));


        //垂直分割面板
        JSplitPane VSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jLabel,new JScrollPane(textArea));
        //打开一触即展特性
        VSplitPane.setOneTouchExpandable(true);

        //水平分割面板
            JSplitPane hSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,VSplitPane,list);

        //设置支持连续布局
                hSplit.setContinuousLayout(true);

            frame.add(hSplit);
            //窗口可关
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        frame.pack();
        //设置窗口可见
        frame.setVisible(true);
    }
    public static void main(String[] args) {
          new jSplitPanelTest().init();
    }
}
