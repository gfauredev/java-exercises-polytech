package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Chambre {
  public enum Type {
    SIMPLE("Simple"),
    DOUBLE("Double"),
    SIMPLE_VUE_MER("Simple Vue Mer"),
    DOUBLE_VUE_MER("Double Vue Mer");

    public final String libelle;

    Type(String libelle) {
      this.libelle = libelle;
    }
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

  public static Map<String, Chambre> lireCsv(Path fichierCsv)
      throws IOException, ParseException {
    try (Stream<String> lines = Files.lines(fichierCsv)) {
      return lines.map(line -> Arrays.asList(line.split(";")))
          .collect(Collectors.toMap(l -> l.get(0),
              l -> new Chambre(l.get(0), Type.valueOf(l.get(1)),
                  Integer.parseInt(l.get(2)))));
    } catch (IOException err) {
      System.out.println("Échec lecture CSV: fichier innexistant, innaccessible…");
      throw err;
    } catch (NumberFormatException err) {
      throw new ParseException("Échec compréhension CSV: colonne 3 ne ressemble pas à un nombre", 0);
    } catch (IllegalArgumentException err) {
      throw new ParseException("Échec compréhension CSV: colonne 2 ne ressemble pas à un type de chambre", 0);
    } catch (IndexOutOfBoundsException err) {
      throw new ParseException("Échec compréhension CSV: 3 colonnes attendues, moins rencontrées", 0);
    }
  }
}
