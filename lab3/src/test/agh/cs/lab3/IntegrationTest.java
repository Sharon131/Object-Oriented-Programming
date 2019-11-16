package agh.cs.lab3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IntegrationTest {
    private static Animal Snail = new Animal();
    private static OptionParser parser = new OptionParser();

    private static String[] stringsToConvert1 = {"r", "f", "f", "f", "f", "l", "f", "f", "f", "f", "l", "f", "l", "f", "l", "r", "f", "r", "f", "r"};
    private static String[] stringsToConvert2 = {"b", "b", "b", "b", "b", "b", "q", "b", "b", "f", "l", "f", "f", "f", "f", "f", "f", "f"};

    @Test
    public void testAll(){
        MoveDirection[] movesToMake1 = parser.parse(stringsToConvert1);

        for (MoveDirection moveToMake : movesToMake1) {
            Snail.move(moveToMake);
        }

        assertEquals(Snail.orientation, MapDirection.NORTH);
        assertEquals(Snail.position, new Vector2d(2, 2));

        MoveDirection[] movesToMake2 = parser.parse(stringsToConvert2);

        for (MoveDirection moveToMake : movesToMake2) {
            Snail.move(moveToMake);
        }

        assertEquals(Snail.orientation, MapDirection.WEST);
        assertEquals(Snail.position, new Vector2d(-4, -3));
    }

}
