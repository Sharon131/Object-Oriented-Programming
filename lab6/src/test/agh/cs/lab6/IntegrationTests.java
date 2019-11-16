package agh.cs.lab6;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class IntegrationTests {
    private static IWorldMap map = new RectangularMap(10, 5);
    private static OptionParser parser = new OptionParser();

    private static String[] commandsForCollisionAndBorders = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    private static String[] commandsForCollisions = {"r", "l", "f", "f"};
    private static String[] commandsForPlacingNewAnimal = {"f"};
    private static String[] commandsForTestingAllBorders = {"b", "l", "f", "r", "f", "f", "f", "f", "r", "f", "f", "f", "f"};

    @Test
    public  void testCollision(){
        Animal Snail = new Animal(map);
        Animal Elephant = new Animal(map, new Vector2d(3, 2));

        map.place(Snail);
        map.place(Elephant);

        MoveDirection[] movesToMake = parser.parse(commandsForCollisions);
        map.run(movesToMake);

        assertTrue(map.objectAt(new Vector2d(2, 2 )) == Snail);
        assertTrue(map.objectAt(new Vector2d(3, 2 )) == Elephant);
    }

    @Test
    public void testCollisionAndBorders(){
        Animal Snail = new Animal(map);
        Animal Elephant = new Animal(map, new Vector2d(3, 4));

        map.place(Snail);
        map.place(Elephant);

        MoveDirection[] movesToMake = parser.parse(commandsForCollisionAndBorders);

        map.run(movesToMake);

        assertTrue(map.objectAt(new Vector2d(2, 0)) == Snail);
        assertTrue(map.objectAt(new Vector2d(3, 5)) == Elephant);
        //assertTrue(Snail.position == new Vector2d(2, 0)); -> nie działa. Powinno?
    }

    @Test
    public void testAllBorders(){
        IWorldMap new_map = new RectangularMap(3, 3);
        Animal Ant = new Animal(new_map, new Vector2d(0,0));

        new_map.place(Ant);

        MoveDirection[] movesToMake = parser.parse(commandsForTestingAllBorders);

        new_map.run(movesToMake);

        assertTrue(new_map.objectAt(new Vector2d(3, 3 )) == Ant);
    }

    @Test
    public void testPlacingNewAnimal(){
        Animal Snail = new Animal(map);
        Animal Elephant = new Animal(map, new Vector2d(2, 3));

        map.place(Snail);

        MoveDirection[] movesToMake = parser.parse(commandsForPlacingNewAnimal);
        map.run(movesToMake);

        assertFalse(map.place(Elephant));
    }
}
