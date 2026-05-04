package tp2.ex6.p2;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    var moyenne = 0f;
    notes.entrySet().stream().forEach(e -> {
      for (int i = 0; i <= e.getKey().getCoef(); i++) {
        moyenne += e.getValue().getMoyenne() * e.getKey().getCoef();
      }

    });
    return moyenne;
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
