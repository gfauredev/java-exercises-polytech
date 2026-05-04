package tp2.ex6.p2;

class Matiere {
  private String nom;
  private int coef;

  Matiere(String nom, int coef) {
    this.nom = nom;
    this.coef = coef;
  }

  void setNom(String nom) {
    this.nom = nom;
  }

  void setCoef(int coef) {
    this.coef = coef;
  }

  String getNom() {
    return this.nom;
  }

  int getCoef() {
    return this.coef;
  }
}
