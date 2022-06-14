import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

/**
 * @ClassName listenerDemo1
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/11 9:15
 * @Version 1.0
 */
public class listenerDemo1 {
    public static void main(String[] args) {
        //主窗体
        Frame frame = new Frame("监听测试");
        //下拉选择框
        Choice choice = new Choice();
        choice.add("测试1");
        choice.add("测试2");
        choice.add("测试3");
        //单行文本框
        TextField textField = new TextField(20);

        //监听文本内容变化
        textField.addTextListener(e -> {
            String text = textField.getText();
            System.out.println("当前文本框中的内容为"+text);
        });
        //监听下拉选择框中
        choice.addItemListener(e->{
            String item = choice.getItem(1);
            System.out.println("当前条目中的为"+item);
        });
        //监听容器中组件的添加
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println("frame中添加的"+child);

            }

            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });

        //装入水平box容器
        Box hBox = Box.createHorizontalBox();
        hBox.add(choice);
        hBox.add(textField);
        //添加到主窗口
        frame.add(hBox);

        //设置最佳大小
        frame.pack();
        //显示窗口
        frame.setVisible(true);
    }
}
