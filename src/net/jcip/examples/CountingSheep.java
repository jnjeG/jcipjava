package net.jcip.examples;

/**
 * CountingSheep
 * <p/>
 * Counting sheep
 *
 * @author Brian Goetz and Tim Peierls
 */
public class CountingSheep {
    public volatile boolean asleep;

    public void tryToSleep() {
        while (!asleep)
            countSomeSheep();
    }

    private void countSomeSheep() {
        // One, two, three...
      System.out.println("counting sheep...");
    }
}








