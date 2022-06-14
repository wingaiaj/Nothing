import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

/**
 * @ClassName BasicComponentDemo
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/10 17:09
 * @Version 1.0
 */
public class BasicComponentDemo {
    //窗口frame
    Frame frame =new Frame("这里测试基本组件");
    //创建文本域
    TextArea textArea =new TextArea(5,20);
    //创建下拉列表框
     Choice colorChooser=new Choice();
    //创建复选框
   CheckboxGroup cbg = new CheckboxGroup();
     Checkbox isMan = new Checkbox("男",cbg,true);
     Checkbox isWoman= new Checkbox("女",cbg,false);
    //创建单选框
    Checkbox isMarried = new Checkbox("是否已婚");
    //文本输入框
    JTextField text =new JTextField(30);
    //按钮
      Button  ok = new Button("确认");
    //列表框
       List colorList = new List(6,true);
    //组装
    public void init() {
        //组装底部
        Box hBox1 = Box.createHorizontalBox();
        hBox1.add(text);
        hBox1.add(ok);
        //添加frame 底部
        frame.add(hBox1, BorderLayout.SOUTH);

        //组装左上
        Box hBox2 = Box.createHorizontalBox();
        colorChooser.add("红色");
        colorChooser.add("蓝色");
        colorChooser.add("绿色");
        hBox2.add(colorChooser);
        hBox2.add(isMan);
        hBox2.add(isWoman);
        hBox2.add(isMarried);

        Box vBox = Box.createVerticalBox();
        vBox.add(textArea);
        vBox.add(hBox2);

        frame.add(vBox, BorderLayout.CENTER);
        //组装左上 和 右
        colorList.add("红色");
        colorList.add("蓝色");
        colorList.add("绿色");
        Box hBox3 = Box.createHorizontalBox();
        hBox3.add(vBox);
        hBox3.add(colorList);


        frame.add(hBox3);
        //设置为可见
        frame.setVisible(true);
        //最佳大小
        frame.pack();
    }


    public static void main(String[] args) {
            BasicComponentDemo bcd = new BasicComponentDemo();
            bcd.init();
    }
}
