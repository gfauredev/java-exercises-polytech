package cc1.ex3;

import java.time.Duration;
import java.time.LocalDate;

class EmpruntLivre {
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
}
