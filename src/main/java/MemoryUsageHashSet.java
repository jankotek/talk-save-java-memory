import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * Measures memory consumption of HashSet
 */
public class MemoryUsageHashSet {

  private static Set<Integer> ref;

  public static void main(String[] args) {

    System.out.println("MEMORY USAGE (HashSet int)\n\n");
    System.out.println("KEYS;MB");

    int max = 10000000;
    for (int i = 100; i <= max; i *= 10) {

      // Benchmark
      final int cnt = i;
      NanoBench nanoBench = NanoBench.create();
      nanoBench.memoryOnly().warmUps(2).measurements(10).measure(String.format("Measure memory for %d keys", i), new Runnable() {
        @Override
        public void run() {
          Random setRandom = new Random(4532);
          ref = new HashSet<Integer>(cnt);
          while (ref.size() < cnt) {
            ref.add(setRandom.nextInt(Integer.MAX_VALUE));
          }
        }
      });

      double bytes = nanoBench.getMemoryBytes() / (1024.0 * 1024.0);
    }
  }
}