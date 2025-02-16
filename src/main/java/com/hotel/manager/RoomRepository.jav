@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    
    List<Room> findByRoomType(RoomType roomType);
    List<Room> findByStatus(RoomStatus status);
    List<Room> findByPricePerNightBetween(BigDecimal min, BigDecimal max);
    Optional<Room> findByRoomNumber(String roomNumber);
}
