package unit.otherclasses;

import org.junit.Test;
import otherclasses.Room;

import static org.junit.Assert.*;


public class RoomTest {

    @Test
    public void testRoom() {
        Room room = new Room(12);
        assertEquals(12, room.getId());
        assertEquals(12, room.getId());
    }
}