package app;

import java.time.LocalDate;

class Reservation {
  private LocalDate date;
  private String client;
  private String chambre;
  private int nombreDeNuits;

  public Reservation(LocalDate date, String client, String chambre, int nombreDeNuits) {
    this.date = date;
    this.client = client;
    this.chambre = chambre;
    this.nombreDeNuits = nombreDeNuits;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getClient() {
    return client;
  }

  public String getChambre() {
    return chambre;
  }

  public int getNombreDeNuits() {
    return nombreDeNuits;
  }
}
