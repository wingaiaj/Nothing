import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @ClassName BallGame
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/12 8:10
 * @Version 1.0
 */
public class BallGame {

    //主窗体创建
    Frame frame = new Frame("Ballgame");


    //画布创建
    MyCanvas2 drawCanvas = new MyCanvas2();
    //窗体的宽高
    private final int width = 300;
    private final int height = 500;
    //球的位置
    public int ballX = 120;
    public int ballY = 50;
    //球的x速度
    private  int BallSeepedX = 10;
    //球的y速度
    private  int BallSeepedY = 5;
    //球的大小直径为16
    public final int ballSize = 16;
    //方块的位置
    public int blockX = 80;
    public int blockY = 400;
    //方块只能在x轴移动速度
    public int blockSeeped = 10;
    //方块的大小
    public final int blockWidth = 68;
    public final int blockHeight = 20;
    //游戏结束标识
    public boolean flag = false;
    //计时器创建
    Timer timer;

    public void init() {
//键盘监听控制方块x轴的移动
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获取玩家键盘的输入
                int keyCode = e.getKeyCode();
                //输入的是左
                if (keyCode == KeyEvent.VK_LEFT) {
                    //方块坐标左移
                    //设置边界
                    if (blockX >= 0) {
                        blockX -= blockSeeped;
                    }
                }   //输入的是右
                if (keyCode == KeyEvent.VK_RIGHT) {
                    //方块坐标右移
                    //设置边界
                    if (blockX < (width-blockWidth)) {
                        blockX += blockSeeped;
                    }
                }
            }
        };
//动作监听 设置小球的移动轨迹
        ActionListener actionListener = e -> {
            //如果小球碰到左右的边界 x速度负
                if(ballX <= 0||ballX >= width){
                    BallSeepedX = - BallSeepedX;
                }

            //如果小球超过 方块的 y坐标,并且不在方块所在范围内 游戏结束
                if(ballY > (blockY - ballSize) && (ballX < blockX || ballX > (blockX + blockWidth)) ){
                            flag = true;
                            drawCanvas.repaint();
                }

            //小球y超过 方块 但在方块x的范围内或者碰到上边界 y速度为负
           if(ballY <= 0 || (ballY >= (blockY - ballSize) && ballX > blockX && ballX <= (blockX + width))){
                        BallSeepedY = - BallSeepedY;
            }
            //速度增
                            ballX += BallSeepedX;
                            ballY += BallSeepedY;
             //绘制图形
            drawCanvas.repaint();
        };
        //设置窗口监听
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //计数器开始 时间为100毫秒
        timer = new Timer(100,actionListener);
        timer.start();
        //添加监听
        drawCanvas.addKeyListener(keyListener);
        frame.addKeyListener(keyListener);
        //容器画布大小
        drawCanvas.setSize(width,height);
        //组装容器
        frame.add(drawCanvas);
        //窗体大小
        frame.setBounds(200,200,width,height);
        //设置最佳大小
        frame.pack();
        //设置窗口可见
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new BallGame().init();
    }

    //画布绘制的图形
    class MyCanvas2 extends Canvas {
        @Override
        public void paint(Graphics g) {
            //绘制失败画面
            if (flag) {
                        //设置画笔
                g.setColor(SystemColor.blue);
                g.setFont(new Font("Timer",Font.BOLD,30));
                        //绘制文字
                g.drawString("游戏结束",100,230);
                        timer.stop();
            }
            else {
                //绘制填充圆形
                g.fillOval(ballX,ballY,ballSize,ballSize);
                //绘制填充方块
                g.fillRect(blockX,blockY,blockWidth,blockHeight);
            }
        }
    }
}