import agh.cs.lab2.MapDirection;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MapDirectionTest {

    @Test
    public void testNext(){
        System.out.println("Testing next() method in MapDirection class.");

        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);

        System.out.println("Tests completed.");
    }

    @Test
    public void testPrevious(){
        System.out.println("Testing previous() method in MapDirection class.");

        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);

        System.out.println("Tests completed.");
    }
}
