import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @ClassName jProgressBar
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/17 14:57
 * @Version 1.0
 */
public class jProgressBar {
    Timer timer;

    public void init() {
        //创建对话框
        ProgressMonitor progressMonitor = new ProgressMonitor(null, "等待任物完成", "已完成:", 0, 100);
        //启动线程
        SubThread subThread = new SubThread(progressMonitor.getMaximum());
        new Thread(subThread).start();
        //监听
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressMonitor.setProgress(subThread.getValue());
                //单击取消
                boolean canceled = progressMonitor.isCanceled();
                if (canceled) {
                    timer.stop();
                    //程序退出
                    System.exit(0);
                }
            }
        });

        timer.start();
    }


    private class SubThread implements Runnable {
        private int maxvalue;
        private volatile int value = 0;

        public int getMaxvalue() {
            return maxvalue;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private SubThread(int maxvalue) {
            this.maxvalue = maxvalue;
        }

        @Override
        public void run() {
            while (value < maxvalue) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value++;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        new jProgressBar().init();
    }

}
