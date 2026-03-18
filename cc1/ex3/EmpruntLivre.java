package cc1.ex3;

import java.time.Duration;
import java.time.LocalDate;

import cc1.ex2.Livre;

class EmpruntLivre {
  public Livre livre; // Ajouté bien que non précisé dans le sujet, fait plus sens
  public String emprunteur;
  public LocalDate date;
  public Duration duree;

  public EmpruntLivre(String emprunteur, LocalDate date, Duration duree) {
    this.emprunteur = emprunteur;
    this.date = date;
    this.duree = duree;
  }

  public EmpruntLivre(String emprunteur) {
    this.emprunteur = emprunteur;
    this.date = LocalDate.now();
    this.duree = Duration.ofDays(14);
  }

  public float calculerPenaliteRetard(int nombreJoursDeRetard) {
    // "inférieur à 2" correspond dans ce cas à "égal à 1" ; "inférieur ou égal" ?
    return nombreJoursDeRetard < 2 ? 0 : nombreJoursDeRetard * 0.5f;
  }

  public String toString() {
    return "%s emprunté par %s le %s pour %s".formatted(livre, emprunteur, date, duree);
  }
}
