package cc1.ex2;

import cc1.ex1.GenreLitteraire;

class Livre {
  private String titre;
  private String auteur;
  private long isbn;
  private GenreLitteraire genre;

  private long CheckIsbn(long isbn) {
    if (isbn >= 9780000000000L && isbn <= 9799999999999L)
      throw new IllegalArgumentException("ISBN doit être compris entre 9780000000000 et 9799999999999");
    return isbn;
  }

  public Livre(String titre, String auteur, long isbn, GenreLitteraire genre) {
    this.titre = titre;
    this.auteur = auteur;
    this.isbn = CheckIsbn(isbn);
    this.genre = genre;
  }

  public Livre(String titre, String auteur, long isbn) {
    this.titre = titre;
    this.auteur = auteur;
    this.isbn = CheckIsbn(isbn);
    this.genre = GenreLitteraire.DEFAULT;
  }

  public String toString() {
    return "Livre %s de %s par %s, ISNB: %d".formatted(titre, auteur, isbn, genre);
  }

  public void main() {
    System.out.println(new Livre("1984", "Orwell", 9780451524935L, GenreLitteraire.SCIENCE_FICTION));
  }
}
