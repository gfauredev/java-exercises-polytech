package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
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

  public static Map<String, SejourClient> lireCsv(Path fichierCsv) // , Map<String, Chambre> chambres)
      throws IOException, ParseException {
    try (Stream<String> lines = Files.lines(fichierCsv)) {
      return lines.map(line -> Arrays.asList(line.split(";")))
          .collect(Collectors.toMap(l -> l.get(1),
              l -> {
                // if (!chambres.containsKey(l.get(2)))
                // throw new ParseException("Échec compréhension CSV: chambre non reconnue", 0);
                return new SejourClient(l.get(1), List
                    .of(new Reservation(LocalDate.parse(l.get(0)), l.get(1),
                        l.get(2), Integer.parseInt(l.get(3)))));
              },
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
}
