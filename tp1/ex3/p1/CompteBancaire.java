package tp1.ex3.p1;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
class CompteBancaire {
  String numéro; // TODO Fixer à 12 chars
  String titulaire;
  int solde;
  final int découvertAutorisé;

  CompteBancaire(String numéro, String titulaire, int solde, int découvertAutorisé) {
    if (numéro.length() != 12) 
      throw new IllegalArgumentException("Le numéro doit comporter 12 caractères");
    this.numéro = numéro;
    if (titulaire == null || titulaire.isBlank())
      throw new IllegalArgumentException("Le titulaire ne peut pas être nul ou vide");
    this.titulaire = titulaire;
    if (solde <= 0)
      throw new IllegalArgumentException("Le solde ne peut pas être négatif");
    this.solde = solde;
    if (découvertAutorisé > 0)
      throw new IllegalArgumentException("Le découvert autorisé doit être négatif");
    this.découvertAutorisé = découvertAutorisé;
    System.out.printf("Compte bancaire créé : %s\n", this.toString());
  }

  String toString() {
    return String.format("CompteBancaire{numéro='%s', titulaire='%s', solde=%d, découvertAutorisé=%d}", numéro, titulaire, solde, découvertAutorisé);
  }

  public void deposer(float montant) {
    if (montant <= 0)
      throw new IllegalArgumentException("Le montant doit être positif");
    this.solde += montant;
    System.out.printf("Dépot de %f euros effectué sur le compte %s. Nouveau solde : %d euros.\n", montant, this.numéro, this.solde);
  }

  public void retirer(float montant) {
    if (montant <= 0)
      throw new IllegalArgumentException("Le montant doit être positif");
    if (this.solde - montant < this.découvertAutorisé)
      throw new IllegalArgumentException("Le montant dépasse le découvert autorisé");
    this.solde -= montant;
    System.out.printf("Retrait de %f euros effectué sur le compte %s. Nouveau solde : %d euros.\n", montant, this.numéro, this.solde);
  }

  public void virer(float montant, CompteBancaire compteCible) {
    if (montant <= 0)
      throw new IllegalArgumentException("Le montant doit être positif");
    if (this.solde - montant < this.découvertAutorisé)
      throw new IllegalArgumentException("Le montant dépasse le découvert autorisé");
    if (compteCible == null)
      throw new IllegalArgumentException("Le compte cible ne peut pas être nul");
    this.retirer(montant);
    compteCible.deposer(montant);
    System.out.printf("Virement de %f euros effectué du compte %s. Nouveau solde : %d euros.\n", montant, this.numéro, this.solde);
  }

  public void afficherSolde() {
    System.out.printf("Le solde du compte %s est de %d euros.\n", this.numéro, this.solde);
  }
}
