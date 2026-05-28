package app.tp2.ex7.p2;

import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarteAJouerTest {
  @Test
  void testCarte1() {
    assertDoesNotThrow(() -> new CarteAJouer(CarteAJouer.Couleur.PIQUE, CarteAJouer.Valeur.AS));
  }

  @Test
  void testCarte2() {
    assertDoesNotThrow(() -> new CarteAJouer(CarteAJouer.Couleur.CŒUR, CarteAJouer.Valeur.DEUX));
  }
}
