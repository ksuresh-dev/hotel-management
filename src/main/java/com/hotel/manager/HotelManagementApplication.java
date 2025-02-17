package com.hotel.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HotelManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementApplication.class, args);
    }

}

// @Entity
// class Room {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String roomNumber;
//     private String type;
//     private String status;
//     private double price;
//     private int capacity;
//     public Room() {
//     }
//     public Room(String roomNumber, String type, String status, double price, int capacity) {
//         this.roomNumber = roomNumber;
//         this.type = type;
//         this.status = status;
//         this.price = price;
//         this.capacity = capacity;
//     }
//     // Getters and setters
//     public Long getId() {
//         return id;
//     }
//     public String getRoomNumber() {
//         return roomNumber;
//     }
//     public String getType() {
//         return type;
//     }
//     public String getStatus() {
//         return status;
//     }
//     public double getPrice() {
//         return price;
//     }
//     public int getCapacity() {
//         return capacity;
//     }
//     public void setRoomNumber(String roomNumber) {
//         this.roomNumber = roomNumber;
//     }
//     public void setType(String type) {
//         this.type = type;
//     }
//     public void setStatus(String status) {
//         this.status = status;
//     }
//     public void setPrice(double price) {
//         this.price = price;
//     }
//     public void setCapacity(int capacity) {
//         this.capacity = capacity;
//     }
// }
// interface RoomRepository extends JpaRepository<Room, Long> {
// }
@Service
class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
}

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rooms")
class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }
}
