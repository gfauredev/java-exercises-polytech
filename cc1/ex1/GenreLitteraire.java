package cc1.ex1;

public enum GenreLitteraire {
  POLICIER("Policier"),
  SCIENCE_FICTION("Science-fiction"),
  FANTASY("Fantasy"),
  HISTOIRE("Histoire"),
  PHILOSOPHIE("Philosophie"),
  DEFAULT("Non classé");

  public final String label;

  private GenreLitteraire(String label) {
    this.label = label;
  }
}
