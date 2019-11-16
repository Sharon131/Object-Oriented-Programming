package agh.cs.lab7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private IWorldMap map = new RectangularMap(4, 4);
    private Animal someAnimal = new Animal(map);

    @Test
    public void testToString(){
        assertEquals("^", someAnimal.toString());
    }

    @Test
    public void testOrientation(){
        someAnimal.move(MoveDirection.RIGHT);
        assertEquals(someAnimal.orientation, MapDirection.EAST);
        someAnimal.move(MoveDirection.LEFT);
        assertEquals(someAnimal.orientation, MapDirection.NORTH);
    }

    @Test
    public void testPosition(){
        someAnimal.move(MoveDirection.FORWARD);
        assertEquals(someAnimal.position, new Vector2d(2, 3));

        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, 2));
    }

    /*@Test
    public void testMapRange(){
        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, 1));
        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, 0));
        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, -1));
        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, -2));
        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, -3));
        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, -4));
        someAnimal.move(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, -4));

        someAnimal.move(MoveDirection.RIGHT);
        someAnimal.move(MoveDirection.FORWARD);
        assertEquals(someAnimal.position, new Vector2d(3, -4));
        someAnimal.move(MoveDirection.FORWARD);
        assertEquals(someAnimal.position, new Vector2d(4, -4));
        someAnimal.move(MoveDirection.FORWARD);
        assertEquals(someAnimal.position, new Vector2d(4, -4));
    }*/

}
