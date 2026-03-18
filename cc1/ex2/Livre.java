package cc1.ex2;

import cc1.ex1.GenreLitteraire;

public class Livre {
  private String titre;
  private long isbn;
  private GenreLitteraire genre;
  // QUESTION 6
  // Pour que l’auteur d’un livre soit représenté par une classe Auteur,
  // il faudrait commencer par la créer, dans un fichier distinct Auteur.java
  //
  // Pour obtenir le même niveau de fonctionnalité qu’actuellement, il faudrait à
  // minima que cette classe dispose d’un attribut `String nom` et d’une
  // redéfinition de toString() qui le retourne.
  //
  // Il faudrait aussi évidemment que cette classe dispose d’un contructeur pour
  // pouvoir créer des auteurs avec leurs informations.
  private String auteur;

  private long CheckIsbn(long isbn) {
    if (isbn < 9780000000000L && isbn > 9799999999999L)
      throw new IllegalArgumentException("ISBN doit être compris entre 9780000000000 et 9799999999999");
    return isbn;
  }

  public Livre() {
  }

  public Livre(String titre, String auteur, long isbn, GenreLitteraire genre) throws IllegalArgumentException {
    this.titre = titre;
    this.auteur = auteur;
    this.isbn = CheckIsbn(isbn);
    this.genre = genre;
  }

  public Livre(String titre, String auteur, long isbn) throws IllegalArgumentException {
    this.titre = titre;
    this.auteur = auteur;
    this.isbn = CheckIsbn(isbn);
    this.genre = GenreLitteraire.DEFAULT;
  }

  public String toString() {
    return "Livre %s de %s par %s (ISNB %d)".formatted(titre, genre.label, auteur, isbn);
  }

  public void main() {
    var livre = new Livre("1984", "Orwell", 9780451524935L, GenreLitteraire.SCIENCE_FICTION);
    System.out.println(livre);
  }
}
