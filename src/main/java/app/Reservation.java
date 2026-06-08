package app;

import java.time.LocalDate;

class Reservation {
  private LocalDate date;
  private String client;
  private boolean reservee;
  private int nombreDeNuits;

  public Reservation(LocalDate date, String client, boolean reservee, int nombreDeNuits) {
    this.date = date;
    this.client = client;
    this.reservee = reservee;
    this.nombreDeNuits = nombreDeNuits;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getClient() {
    return client;
  }

  public boolean isReservee() {
    return reservee;
  }

  public int getNombreDeNuits() {
    return nombreDeNuits;
  }
}
