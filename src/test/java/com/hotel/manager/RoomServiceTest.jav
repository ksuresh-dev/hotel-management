@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void testAddRoom() {
        Room room = new Room("101", RoomType.SINGLE, new BigDecimal("50.00"), RoomStatus.AVAILABLE, 2);
        Room savedRoom = roomService.addRoom(room);
        assertNotNull(savedRoom);
    }
}
