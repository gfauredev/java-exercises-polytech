package app;

class Chambre {
  public enum Type {
    SIMPLE,
    DOUBLE,
    SIMPLE_VUE_MER,
    DOUBLE_VUE_MER,
  }

  private String id;
  private Type type;
  private int prixParNuit;

  public Chambre(String id, Type type, int prixNuit) {
    this.id = id;
    this.type = type;
    this.prixParNuit = prixNuit;
  }

  public String getId() {
    return id;
  }

  public Type getType() {
    return type;
  }

  public int getPrixParNuit() {
    return prixParNuit;
  }
}
