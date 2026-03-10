import java.util.ArrayList;
import java.util.List;

enum Couleur {
    COEUR, CARREAU, TREFLE, PIQUE
}

enum Valeur {
    DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS
}

class Carte {
    private Valeur valeur;
    private Couleur couleur;

    public Carte(Valeur valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }
}

public class JeuDeCartes {
    public static void main(String[] args) {
        List<Carte> paquetDeCartes = new ArrayList<>();
        for (Couleur c : Couleur.values()) 
            for (Valeur v : Valeur.values()) 
                paquetDeCartes.add(new Carte(v, c));
        System.out.println("Nombre de cartes dans le paquet : "
            + paquetDeCartes.size());
        System.out.println("Première carte : " + paquetDeCartes.get(0));
        System.out.println("Dernière carte : " + paquetDeCartes.get(paquetDeCartes.size() - 1));
    }
}
