package app.tp2.ex7.p1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeureTest {
  Heure h;

  @BeforeEach
  void setHeure() {
    h = new Heure(8, 14);
  }

  @Test
  void testAvance12() {
    System.out.println("Test avance 12min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(12);
    System.out.println(h);
    assertEquals(h.getHeures(), 8);
    assertEquals(h.getMinutes(), 26);
  }

  @Test
  void testAvance51() {
    System.out.println("Test avance 51min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(51);
    System.out.println(h);
    assertEquals(h.getHeures(), 9);
    assertEquals(h.getMinutes(), 5);
  }

  @Test
  void testAvance73() {
    System.out.println("Test avance 73min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(73);
    System.out.println(h);
    assertEquals(h.getHeures(), 9);
    assertEquals(h.getMinutes(), 27);
  }

  @Test
  void testAvance125() {
    System.out.println("Test avance 125min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(125);
    System.out.println(h);
    assertEquals(h.getHeures(), 10);
    assertEquals(h.getMinutes(), 19);
  }

  @Test
  void testAvance303() {
    System.out.println("Test avance 303min");
    var h = new Heure(20, 4); // Shadow
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(303);
    System.out.println(h);
    assertEquals(h.getHeures(), 1);
    assertEquals(h.getMinutes(), 7);
  }

  @Test
  void testAvance1441() {
    System.out.println("Test avance 1441min");
    var h = new Heure(3, 56); // Shadow
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(1441);
    System.out.println(h);
    assertEquals(h.getHeures(), 3);
    assertEquals(h.getMinutes(), 57);
  }

  @Test
  void testRecule12() {
    System.out.println("Test recule 12min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(-12);
    System.out.println(h);
    assertEquals(h.getHeures(), 8);
    assertEquals(h.getMinutes(), 2);
  }

  @Test
  void testRecule16() {
    System.out.println("Test recule 16min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(-16);
    System.out.println(h);
    assertEquals(h.getHeures(), 7);
    assertEquals(h.getMinutes(), 58);
  }

  @Test
  void testRecule70() {
    System.out.println("Test recule 70min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(-70);
    System.out.println(h);
    assertEquals(h.getHeures(), 7);
    assertEquals(h.getMinutes(), 4);
  }

  @Test
  void testRecule121() {
    System.out.println("Test recule 121min");
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(-121);
    System.out.println(h);
    assertEquals(h.getHeures(), 6);
    assertEquals(h.getMinutes(), 13);
  }

  @Test
  void testRecule241() {
    System.out.println("Test recule 241min");
    var h = new Heure(3, 56); // Shadow
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(-241);
    System.out.println(h);
    assertEquals(h.getHeures(), 23);
    assertEquals(h.getMinutes(), 55);
  }

  @Test
  void testRecule1441() {
    System.out.println("Test recule 1441min");
    var h = new Heure(3, 56); // Shadow
    System.out.println("Heure reset à " + h);
    h.avancerMinutes(-1441);
    System.out.println(h);
    assertEquals(h.getHeures(), 3);
    assertEquals(h.getMinutes(), 55);
  }
}
