package tp1.ex2.p1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Jeu52Cartes {
    private final List<CarteAJouer> cartes = Arrays.stream(
            CarteAJouer.Valeur.values()).flatMap(
            v -> Arrays.stream(CarteAJouer.Couleur.values())
                    .map(c -> new CarteAJouer(c, v))).toList();

    @Override
    public String toString() {
        return cartes.stream().map(c -> c.toString() + System.lineSeparator())
                .collect(Collectors.joining());
    }

    public CarteAJouer getCarte(CarteAJouer.Couleur couleur, CarteAJouer.Valeur valeur) {
        return cartes.stream().filter(c -> c.getValeur() == valeur)
                .filter(c -> c.getCouleur() == couleur).toList().getFirst();
    }
}
