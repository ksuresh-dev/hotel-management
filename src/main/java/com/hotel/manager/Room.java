package com.hotel.manager;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("roomType") // ✅ Ensures JSON property maps to this field
    private RoomType roomType;

    @Column(nullable = false)
    @JsonProperty("price") // ✅ Maps JSON "price" to pricePerNight
    private double pricePerNight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @JsonProperty("roomStatus") // ✅ Maps JSON "roomStatus" to this field
    private RoomStatus status = RoomStatus.AVAILABLE;

    @Column(nullable = false)
    private int capacity;

    // ✅ Default constructor (required for JSON deserialization)
    public Room() {
    }

    // ✅ Parameterized constructor
    public Room(String roomNumber, RoomType roomType, double pricePerNight, RoomStatus status, int capacity) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.status = status;
        this.capacity = capacity;
    }

    // ✅ Getters
    public Long getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return pricePerNight;
    }

    public RoomStatus getRoomStatus() {
        return status;
    }

    public int getCapacity() {
        return capacity;
    }

    // ✅ Setters (Needed for JSON to Java Object conversion)
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setRoomStatus(RoomStatus status) {
        this.status = status;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
