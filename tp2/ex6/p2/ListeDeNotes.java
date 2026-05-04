package tp2.ex6.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListeDeNotes {
  private List<Float> notes = new ArrayList<>();

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

  Float getMean() {
    return (float) notes.stream().mapToDouble(Float::doubleValue)
        .average().orElse(0);
  }
}
