package com.hotel.manager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(unique = true, nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType roomType;

    @Column(nullable = false)
    private double pricePerNight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomStatus status = RoomStatus.AVAILABLE;

    @Column(nullable = false)
    private int capacity;

    // Constructors, Getters, and Setters
    public Long getId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return roomType;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public double getPrice() {
        return pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }
}
