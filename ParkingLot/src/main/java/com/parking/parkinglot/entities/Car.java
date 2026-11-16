package com.parking.parkinglot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)

    private Long id;

    @Column(name = "parking_spot")

    private String parkingSpot;

    @Column(name = "license_plate")

    private String licensePlate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)

    private User owner;

    public Car() {}

    public User getOwner() {return this.owner;}

    public void setOwner(User owner) {this.owner = owner;}

    public String getParkingSpot() {return this.parkingSpot;}

    public void setParkingSpot(String parkingSpot) {this.parkingSpot = parkingSpot;}

    public String getLicensePlate() {return this.licensePlate;}

    public void setLicensePlate(String licensePlate) {this.licensePlate = licensePlate;}

    public Long getId() {return this.id;}

    public void setId(Long id) {this.id = id;}
}