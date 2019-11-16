package agh.cs.lab3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OptionParserTest {
    private Animal Elephant = new Animal();

    private static OptionParser parser = new OptionParser();
    private static String[] stringToConvert = {"r", "f", "f", "f"};

    @Test
    public void testParser(){
        MoveDirection[] movesToMake = parser.parse(stringToConvert);

        for (MoveDirection moveDirection : movesToMake) {
            Elephant.move(moveDirection);
        }

        assertEquals(Elephant.orientation, MapDirection.EAST);
        assertEquals(Elephant.position, new Vector2d(4, 2));
    }

}
