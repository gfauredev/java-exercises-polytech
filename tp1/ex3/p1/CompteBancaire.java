package tp1.ex3.p1;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@Setter
@Getter
class CompteBancaire {
  String numéro; // TODO Fixer à 12 chars
  String titulaire;
  int solde;
  final int découvertAutorisé;
}
