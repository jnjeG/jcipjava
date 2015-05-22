package chap1;


import net.jcip.examples.Sequence;
import net.jcip.examples.UnsafeSequence;

public class Chap1_3_1 {
  public static void main(String[] args) {
//    runSafeSeq();
     runUnsafeSeq();
  }


  /**
   * run more until the final output is not 9
   */
  private static void runUnsafeSeq() {
    UnsafeSequence seq = new UnsafeSequence();

    UnsafeIncreTask task = new UnsafeIncreTask(seq);
    Thread t = new Thread(task);
    t.start();

    Thread t2 = new Thread(task);
    t2.start();
  }


  /**
   * 
   */
  private static void runSafeSeq() {
    Sequence seq = new Sequence();
    // UnsafeSequence seq = new UnsafeSequence();

    IncreTask task = new IncreTask(seq);
    Thread t = new Thread(task);
    t.start();

    Thread t2 = new Thread(task);
    t2.start();
  }

  public static class IncreTask implements Runnable {
    private Sequence seq;

    public IncreTask(Sequence seq) {
      super();
      this.seq = seq;
    }

    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        System.out.println(seq.getNext());
        try {
          Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

  }


  public static class UnsafeIncreTask implements Runnable {
    private UnsafeSequence seq;

    public UnsafeIncreTask(UnsafeSequence seq) {
      super();
      this.seq = seq;
    }

    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        System.out.println(seq.getNext());
        try {
          Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

  }
}
