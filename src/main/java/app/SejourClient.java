package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SejourClient {
  private String client;
  private List<Reservation> reservations;

  public SejourClient(String client) {
    this.client = client;
    this.reservations = new ArrayList<>();
  }

  public SejourClient(String client, List<Reservation> reservations) {
    this.client = client;
    this.reservations = reservations;
  }

  public SejourClient ajouterReservation(Reservation reservation) {
    this.reservations.add(reservation);
    return this;
  }

  public String getClient() {
    return client;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public String toString() {
    String str = "Séjours pour " + this.client + " :" + System.lineSeparator() + System.lineSeparator();
    for (Reservation resa : reservations)
      str += "- [" + resa.getDate() + "] x nuit(s) en chambre " + resa.getChambre() + System.lineSeparator();
    return str;
  }

  public String recap(Map<String, Chambre> chambres) {
    String str = "Séjours pour " + this.client + " :" + System.lineSeparator() + System.lineSeparator();
    Map<LocalDate, List<Reservation>> resasParDate = new HashMap<>();
    int totalHT = 0;
    for (Reservation resa : this.reservations) {
      if (resasParDate.containsKey(resa.getDate()))
        resasParDate.get(resa.getDate()).add(resa);
      else
        resasParDate.put(resa.getDate(), List.of(resa));
    }
    for (var date_resa : resasParDate.entrySet()) {
      Map<Chambre.Type, List<Reservation>> resasParType = new HashMap<>();
      for (Reservation resa : date_resa.getValue()) {
        var chambre = chambres.get(resa.getChambre());
        if (resasParType.containsKey(chambre.getType()))
          resasParType.get(chambre.getType()).add(resa);
        else
          resasParType.put(chambre.getType(), List.of(resa));
      }
      for (var type_resa : resasParType.entrySet()) {
        var chambre = chambres.get(type_resa.getValue().get(0).getChambre());
        str += "- [" + type_resa.getValue().get(0).getDate() + "] " + type_resa.getValue().size()
            + " nuit(s) en chambre "
            + type_resa.getKey().libelle
            + " @ " + chambre.getPrixParNuit() + "€ = " + chambre.getPrixParNuit() * type_resa.getValue().size()
            + "€HT"
            + System.lineSeparator();
        totalHT += chambre.getPrixParNuit() * type_resa.getValue().size();
      }
    }
    return str + System.lineSeparator() +
        "Total HT: " + totalHT + "€" + System.lineSeparator() +
        "TVA (10%): " + totalHT * .1 + "€" + System.lineSeparator() +
        "Total TTC: " + totalHT + totalHT * .1 + "€" + System.lineSeparator();
  }

  public static Map<String, SejourClient> lireCsv(Path fichierCsv, Map<String, Chambre> chambres)
      throws IOException, ParseException {
    var map = new HashMap<String, SejourClient>();
    try (BufferedReader br = new BufferedReader(new FileReader(fichierCsv.toString()))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] col = line.split(";");
        if (!chambres.containsKey(col[2]))
          throw new ParseException("Échec compréhension CSV: chambre non reconnue", 0);
        var resa = new Reservation(LocalDate.parse(col[0]), col[1], col[2], Integer.parseInt(col[3]));
        if (map.containsKey(col[1]))
          map.get(col[1]).ajouterReservation(resa);
        else
          map.put(col[1], new SejourClient(col[1], List.of(resa)));
      }
    } catch (IOException err) {
      System.out.println("Échec lecture CSV: fichier innexistant, innaccessible…");
      throw err;
    } catch (DateTimeParseException err) {
      throw new ParseException("Échec compréhension CSV: date malformée", 0);
    } catch (NumberFormatException err) {
      throw new ParseException("Échec compréhension CSV: colonne 4 ne ressemble pas à un nombre", 0);
    } catch (IndexOutOfBoundsException err) {
      throw new ParseException("Échec compréhension CSV: 4 colonnes attendues, moins rencontrées", 0);
    }
    return map;
  }

  // Ancienne méthode en fonctionnel pur, sans vérification chambres
  public static Map<String, SejourClient> lireCsv(Path fichierCsv)
      throws IOException, ParseException {
    try (Stream<String> lines = Files.lines(fichierCsv)) {
      return lines.map(line -> Arrays.asList(line.split(";")))
          .collect(Collectors.toMap(l -> l.get(1),
              l -> new SejourClient(l.get(1), List
                  .of(new Reservation(LocalDate.parse(l.get(0)), l.get(1),
                      l.get(2), Integer.parseInt(l.get(3))))),
              (l1, l2) -> l1.ajouterReservation(l2.getReservations().get(0))));
    } catch (IOException err) {
      System.out.println("Échec lecture CSV: fichier innexistant, innaccessible…");
      throw err;
    } catch (DateTimeParseException err) {
      throw new ParseException("Échec compréhension CSV: date malformée", 0);
    } catch (NumberFormatException err) {
      throw new ParseException("Échec compréhension CSV: colonne 4 ne ressemble pas à un nombre", 0);
    } catch (IndexOutOfBoundsException err) {
      throw new ParseException("Échec compréhension CSV: 4 colonnes attendues, moins rencontrées", 0);
    }
  }

  public static void main() {

  }
}
