package app.tp2.ex7.p2;

public class CarteAJouer {
  public static enum Couleur {
    PIQUE, CŒUR, CARREAU, TREFLE
  }

  public static enum Valeur {
    DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI,
    AS;
  }

  private Couleur couleur;
  private Valeur valeur;

  public CarteAJouer(Couleur couleur, Valeur valeur) {
    this.couleur = couleur;
    this.valeur = valeur;
  }

  @Override
  public String toString() {
    return valeur + " de " + couleur;
  }

  static void main() {
    var c1 = new CarteAJouer(Couleur.PIQUE, Valeur.AS);
    var c2 = new CarteAJouer(Couleur.CŒUR, Valeur.DEUX);
    var c3 = new CarteAJouer(Couleur.CARREAU, Valeur.DAME);
    var c4 = new CarteAJouer(Couleur.TREFLE, Valeur.ROI);
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
  }

  public Couleur getCouleur() {
    return couleur;
  }

  public Valeur getValeur() {
    return valeur;
  }
}
