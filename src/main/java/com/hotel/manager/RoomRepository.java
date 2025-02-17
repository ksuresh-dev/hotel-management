package com.hotel.manager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByRoomType(RoomType roomType);

    List<Room> findByStatus(RoomStatus status);

    List<Room> findByPricePerNightBetween(BigDecimal min, BigDecimal max);

    Optional<Room> findByRoomNumber(String roomNumber);
}
