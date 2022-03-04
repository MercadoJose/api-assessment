package com.example.assessment.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idFlight;

    @Column(nullable = false)
    private String airline;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private Date departureDate;

    @Column
    private Date arrivalDate;

    @ManyToOne
    @JoinColumn(name = "id_destination", nullable = false)
    private Destination idDestination;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

    public Long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Long idFlight) {
        this.idFlight = idFlight;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Destination getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Destination idDestination) {
        this.idDestination = idDestination;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
