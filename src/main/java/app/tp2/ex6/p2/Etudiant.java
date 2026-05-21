package tp2.ex6.p2;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Etudiant {
  private String nom;
  private Map<Matiere, ListeDeNotes> notes = new HashMap<>();

  Etudiant(String nom) {
    this.nom = nom;
  }

  String getNom() {
    return nom;
  }

  Map<Matiere, ListeDeNotes> getNotes() {
    return notes;
  }

  void addNotes(Matiere matiere, ListeDeNotes listeDeNotes) {
    notes.put(matiere, listeDeNotes);
  }

  ListeDeNotes getNotes(Matiere matiere) {
    return notes.get(matiere);
  }

  Float getMoyennePonderee() {
    // Moyenne des ListeDeNotes.getMoyenne() pondérées par Matiere.getCoef()
    final int totalCoefficients = notes.keySet().stream()
        .mapToInt(Matiere::getCoef)
        .sum();
    if (totalCoefficients == 0)
      return 0f;
    return (float) (notes.entrySet().stream()
        .mapToDouble(e -> e.getValue().getMoyenne() * e.getKey().getCoef())
        .sum() / totalCoefficients);
  }

  static void main() {
    var e = new Etudiant("Jean Dupont");
    var java = new Matiere("Java", 3);
    var cpp = new Matiere("C++", 2);
    e.addNotes(java,
        new ListeDeNotes(List.of(18f, 12f, 14f)));
    e.addNotes(cpp,
        new ListeDeNotes(List.of(8f, 12f, 10f)));
    System.out.println("Moyenne Java: " + e.getNotes(java).getMoyenne());
    System.out.println("Moyenne C++: " + e.getNotes(cpp).getMoyenne());
    System.out.println("Moyenne générale: " + e.getMoyennePonderee());
  }
}
