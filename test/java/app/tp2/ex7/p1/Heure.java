package app.tp2.ex7.p1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HeureTest {
  @Test
  void testAvance12() {
    var h = new Heure(8, 14);
    System.out.println(h);
    h.avancerMinutes(12);
    System.out.println(h);
    assertEquals(h.getHeures(), 8);
    assertEquals(h.getMinutes(), 26);
  }
}
