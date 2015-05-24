package chap3;


import net.jcip.examples.CountingSheep;
import net.jcip.examples.Sequence;
import net.jcip.examples.UnsafeSequence;

public class Chap3_1_4 {
  public static void main(String[] args) {
    CountingSheep cs  = new CountingSheep();
    CounterTask ct = new CounterTask(cs);
    ct.start();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    cs.asleep = true;
  }

  public static class CounterTask extends Thread{
    private CountingSheep cs ;
    
    public CounterTask(CountingSheep cs) {
      super();
      this.cs = cs;
    }


    @Override
    public void run() {
      cs.tryToSleep();
      System.out.println("sleeping");
    }
    
  }

}
