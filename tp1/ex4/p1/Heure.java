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
    if (h < 0 || h > 23)
      throw new IllegalArgumentException("Heure doit être entre 0 et 23!");
    this.h = (byte) h;
  }

  public void setMinutes(int m) {
    if (m < 0 || m > 59)
      throw new IllegalArgumentException("Minutes doit être entre 0 et 59!");
    this.m = (byte) m;
  }

  public void setHeuresMinutes(int h, int m) {
    if (h < 0 || h > 23)
      throw new IllegalArgumentException("Heure doit être entre 0 et 23");
    if (m < 0 || m > 59)
      throw new IllegalArgumentException("Minutes doit être entre 0 et 59!");
    this.h = (byte) h;
    this.m = (byte) m;
  }

  public void avancerMinutes(int m) {
    this.h = (byte) ((this.h + (this.m + m) / 60) % 24);
    this.m = (byte) ((this.m + m) % 60);
  }

  public void main() {
    var h = new Heure();
    h.setHeuresMinutes(15, 10);
    System.out.println(h);
    try {
      h.setHeuresMinutes(-34, 72);
    } catch (IllegalArgumentException e) {
      System.out.println("Erreur: " + e.getMessage());
    }
    System.out.println(h);
    h.setHeuresMinutes(23, 59);
    System.out.println(h);
    h.avancerMinutes(1);
    System.out.println(h);
    h.avancerMinutes(999);
    System.out.println(h);
    h.avancerMinutes(1235134624);
    System.out.println(h);
    System.out.println(h);
  }
}
