package com.example.assessment.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idDestination;

    @Column(nullable = false)
    private String desCountry;

    @Column(nullable = false)
    private String desLocation;

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public String getDesCountry() {
        return desCountry;
    }

    public void setDesCountry(String desCountry) {
        this.desCountry = desCountry;
    }

    public String getDesLocation() {
        return desLocation;
    }

    public void setDesLocation(String desLocation) {
        this.desLocation = desLocation;
    }
}
