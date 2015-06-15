package chap12;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierAutoReset {

    private static class PartTask implements Runnable {
        private CyclicBarrier barrier;

        public PartTask(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " 正在公共屏障点等待.....");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " 已正常离开屏障点......");
            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
        final int parties = 5;
        final CyclicBarrier barrier = new CyclicBarrier(parties, new Runnable() {
            @Override
            public void run() {
                System.out.println("Ha ha, all done , my turn!");
            }
        });
        for (int i = 0; i < parties; i++) {
            Thread t = new Thread(new PartTask(barrier), "parties " + (i + 1));
            t.start();
        }
        
        Thread.sleep(5000);
        System.out.println("-------------------------------------------");
        //run code under here, then it can prove CyclicBarrier will auto reset after run await().
        for (int i = 0; i < parties; i++) {
          Thread t = new Thread(new PartTask(barrier), "parties " + (i + 1));
          t.start();
        }
        
    }

}