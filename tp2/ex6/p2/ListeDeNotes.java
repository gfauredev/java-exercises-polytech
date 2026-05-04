package tp2.ex6.p2;

import java.util.ArrayList;
import java.util.List;

class ListeDeNotes {
  private List<Float> notes = new ArrayList<>();

  ListeDeNotes(List<Float> notes) {
    this.notes = notes;
  }

  void add(Float note) {
    notes.add(note);
  }

  void remove(Float note) {
    notes.remove(note);
  }

  void clear() {
    notes.clear();
  }

  Float get(int index) {
    return notes.get(index);
  }

  Float getMoyenne() {
    return (float) notes.stream().mapToDouble(Float::doubleValue)
        .average().orElse(0);
  }
}
