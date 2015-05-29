package interrupt;

import java.util.concurrent.TimeUnit;
/**
 * http://www.ticmy.com/?p=31
 * @author chenjunjie
 *
 */
public class TestInterrupt3 {
    public static void main(String[] args) throws Exception {
        Thread t = new MyThread();
        t.start();
        TimeUnit.MICROSECONDS.sleep(5000);//如果不能看到处理过程中被中断的情形，可以启用这句再看看效果,可以修改该值去产生“处理过程被中断”的例子
        t.interrupt();
        System.out.println("已调用线程的interrupt方法");
    }
     
    static class MyThread extends Thread {
        public void run() {
            int num;
            try {
                num = longTimeRunningNonInterruptMethod(2, 0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("长时间任务运行结束,num=" + num);
            System.out.println("线程的中断状态:" + Thread.interrupted());
            System.out.println("线程重置中断状态后的当前状态:" + isInterrupted());
        }
         
        private static int longTimeRunningNonInterruptMethod(int count, int initNum) throws InterruptedException {
            if(interrupted()) {
                throw new InterruptedException("正式处理[前]线程已经被请求中断");
            }
            for(int i=0; i<count; i++) {
                for(int j=0; j<Integer.MAX_VALUE; j++) {
                    initNum ++;
                }
                //假如这就是一个合适的地方
                if(interrupted()) {
                    //回滚数据，清理操作等
                    throw new InterruptedException("线程正在处理[过程中]被中断");
                }
            }
            return initNum;
        }
    }
}