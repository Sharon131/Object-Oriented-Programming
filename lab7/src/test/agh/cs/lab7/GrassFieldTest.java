package agh.cs.lab7;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertSame;

public class GrassFieldTest {
    private static AbstractWorldMap map = new GrassField(10);
    private static OptionParser parser = new OptionParser();

    private static String[] commandsForRun = {"l", "r", "f", "f", "r", "l", "f", "f"};

    @Before
    public void setup() {
        Animal Snail = new Animal(map);
        Animal Elephant = new Animal(map, new Vector2d(3, 2));

        map.place(Snail);
        map.place(Elephant);
    }

    @Test
    public void testToString(){
        System.out.println(map.toString());
    }

    @Test
    public void testCanMoveTo(){
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlace(){
        assertTrue(map.place(new Animal(map, new Vector2d(4, 4))));
        assertFalse(map.place(new Animal(map, new Vector2d(2, 2))));
    }

    @Test
    public void testRun(){
        MoveDirection[] directions = parser.parse(commandsForRun);

        map.run(directions);

        assertTrue(map.isOccupied(new Vector2d(1, 3 )));
        assertTrue(map.isOccupied(new Vector2d(4, 3 )) );
    }

    @Test
    public void testIsOccupied(){
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(10, 2)));
    }

    @Test
    public void testObjectAt(){
        Animal Raven = new Animal(map, new Vector2d(1, 1));
        map.place(Raven);

        assertNull(map.objectAt(new Vector2d(3, 3)));
        assertSame(map.objectAt(new Vector2d(1, 1)), Raven);
    }


}
