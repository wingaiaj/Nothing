import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Set;

/**
 * @ClassName HandDraw
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/12 19:28
 * @Version 1.0
 */
public class HandDraw {
    //主窗口创建
    Frame frame = new Frame("绘画测试");
    //高宽度
    private final int width = 500;
    private final int height = 300;
    //创建位图
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    //获取
    Graphics g = bufferedImage.getGraphics();
    //画布创建
    DrawCanvas drawCanvas = new DrawCanvas();

    //右击菜单容器创建
    PopupMenu colorChoice = new PopupMenu();
    //菜单条目创建
    MenuItem redItem = new MenuItem("红色");
    MenuItem greenItem = new MenuItem("绿色");
    MenuItem blueItem = new MenuItem("蓝色");
    //颜色变量
    public Color recolor = Color.black;
    //
    private int prex = -1;
    private int prey = -1;

    //组装和逻辑
    public void init() {
        //菜单条目监听
        ActionListener menuItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取事件源的字符
                String actionCommand = e.getActionCommand();
                //判断用户点击那个menuitem 并更改recolor变量 改变画笔颜色
                switch (actionCommand) {
                    case "红色":
                        recolor = Color.red;
                        break;
                    case "绿色":
                        recolor = Color.green;
                        break;
                    case "蓝色":
                        recolor = Color.blue;
                }

            }
        };
        //菜单条目注册监听
        redItem.addActionListener(menuItemListener);
        greenItem.addActionListener(menuItemListener);
        blueItem.addActionListener(menuItemListener);

        //右击菜单容器添加菜单条目
        colorChoice.add(redItem);
        colorChoice.add(greenItem);
        colorChoice.add(blueItem);

        drawCanvas.add(colorChoice);
        //设置鼠标监听 右击释放鼠标时 显示右击菜单
        drawCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if(popupTrigger){
                    colorChoice.show(drawCanvas,e.getX(),e.getY());
                }
                prey = -1;
                prex = -1;
            }
        });
        //鼠标拖动绘制
        drawCanvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (prex > 0 && prey > 0) {
                    g.setColor(recolor);
                    g.drawLine(prex, prey, e.getX(), e.getY());
                }

                    prex = e.getX();
                    prey = e.getY();

                drawCanvas.repaint();
            }
        });
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        drawCanvas.setPreferredSize(new Dimension(width,height));
        frame.add(drawCanvas);
        frame.pack();
        frame.setVisible(true);

    }

    public class DrawCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //相当于在位图上完成绘制 借用画布的方法 显示出来
            g.drawImage(bufferedImage, 0, 0, null);

        }
    }

    public static void main(String[] args) {
        new HandDraw().init();
    }

}

