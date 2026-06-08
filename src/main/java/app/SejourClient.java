package app;

import java.util.ArrayList;
import java.util.List;

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

  public void ajouterReservation(Reservation reservation) {
    this.reservations.add(reservation);
  }

  public String getClient() {
    return client;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }
}
