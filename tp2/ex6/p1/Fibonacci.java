package tp1.ex6.p1;

import java.util.ArrayList;
import java.util.Collections;

class Fibonacci {
  private ArrayList<Long> values = new ArrayList<>();

  public Fibonacci(int n) {
    for (int i = 0; i < n; i++)
      if (i <= 1)
        values.add((long) i);
      else
        values.add(values.get(i - 2) + values.get(i - 1));
  }

  public int indexOf(long n) {
    return values.indexOf(n);
  }

  public long get(int n) {
    return values.get(n);
  }

  public long even() {
    return values.stream().filter(n -> n % 2 == 0).count();
  }

  public long odd() {
    return values.stream().filter(n -> n % 2 == 1).count();
  }

  public void shuffle() {
    Collections.shuffle(values);
  }

  public static void main() {
    var fib = new Fibonacci(80);
    System.out.println("get(50):" + fib.get(50));
    System.out.println("indexOf(4182):" + fib.indexOf(4182));
    System.out.println("indexOf(832040):" + fib.indexOf(832040));
    System.out.println("get(40):" + fib.get(40));
    System.out.println("even:" + fib.even());
    System.out.println("odd:" + fib.odd());
    System.out.println("shuffle");
    fib.shuffle();
    System.out.println("indexOf(12586269025L):" + fib.indexOf(12586269025L));
  }
}
