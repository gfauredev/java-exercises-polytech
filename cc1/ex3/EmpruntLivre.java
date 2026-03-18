package cc1.ex3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.FormatStyle;

import cc1.ex2.Livre;
import cc1.ex1.GenreLitteraire;

class EmpruntLivre {
  private Livre livre; // Ajouté bien que non précisé dans le sujet, fait plus sens
  private String emprunteur;
  private LocalDate date;
  private Duration duree;

  public EmpruntLivre() {
  }

  public EmpruntLivre(Livre livre, String emprunteur, LocalDate date, Duration duree) {
    this.livre = livre;
    this.emprunteur = emprunteur;
    this.date = date;
    this.duree = duree;
  }

  public EmpruntLivre(Livre livre, String emprunteur) {
    this.livre = livre;
    this.emprunteur = emprunteur;
    this.date = LocalDate.now();
    this.duree = Duration.ofDays(14);
  }

  public float calculerPenaliteRetard(int nombreJoursDeRetard) {
    // "inférieur à 2" correspond dans ce cas à "égal à 1" ; "inférieur ou égal" ?
    return nombreJoursDeRetard < 2 ? 0 : nombreJoursDeRetard * 0.5f;
  }

  public String toString() {
    return "%s emprunté par %s le %s pour %s".formatted(livre, emprunteur,
        date.format(java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)), duree);
  }

  public void main() {
    var l1 = new Livre("Harry Pottech", "BDE Polytech", 9781123581321L, GenreLitteraire.FANTASY);
    var l2 = new Livre("1984", "Georges Orwell", 9780451524935L, GenreLitteraire.SCIENCE_FICTION);
    System.out.println(l1);
    System.out.println(l2);
    System.out.println();
    var e1 = new EmpruntLivre(l1, "Sarah Connor");
    var e2 = new EmpruntLivre(l2, "Jean Bon");
    System.out.println(e1);
    System.out.println(e2);
    System.out.println(e2);
  }
}
