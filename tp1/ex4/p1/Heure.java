package tp1.ex4.p1;

import java.time.LocalTime;

class Heure {
  private byte h;
  private byte m;

  public Heure(byte h, byte m) {
    this.h = h;
    this.m = m;
  }

  public Heure() {
    var t = LocalTime.now();
    this.h = (byte) t.getHour();
    this.m = (byte) t.getMinute();
  }

  public String toString() {
    return "%d:%d".formatted(h, m);
  }

  public int getHeures() {
    return h;
  }

  public int getMinutes() {
    return m;
  }

  public void setHeures(int h) {
    this.h = (byte) h;
  }

  public void setMinutes(int m) {
    this.m = (byte) m;
  }

  public void setHeuresMinutes(int h, int m) {
    this.h = (byte) h;
    this.m = (byte) m;
  }

  public void main() {
    var h = new Heure();
    // h.setHeuresMinutes(15, 10);
    System.out.println(h);
    h.setHeuresMinutes(-34, 72);
    System.out.println(h);
  }
}
