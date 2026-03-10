package tp1.ex2.p1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarteAJouer {
    public enum Couleur {
        PIQUE, CŒUR, CARREAU, TREFLE
    }

    public enum Valeur {
        DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI,
        AS;
    }

    private Couleur couleur;
    private Valeur valeur;

    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }

    static void main() {
        var c1 = new CarteAJouer(Couleur.PIQUE, Valeur.AS);
        var c2 = new CarteAJouer(Couleur.CŒUR, Valeur.DEUX);
        var c3 = new CarteAJouer(Couleur.CARREAU, Valeur.DAME);
        var c4 = new CarteAJouer(Couleur.TREFLE, Valeur.ROI);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}
