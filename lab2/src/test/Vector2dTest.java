import agh.cs.lab2.Vector2d;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class Vector2dTest {

    Vector2d testVector1 = new Vector2d(1, -1);
    Vector2d testVector2 = new Vector2d(2, 0);

    @Test
    public void testEquals(){
        System.out.println("Testing equals() method in Vector2d class.");

        assertTrue(testVector1.equals(new Vector2d(1, -1)));
        assertFalse(testVector1.equals(testVector2));

        System.out.println("Tests completed.");
    }

    @Test
    public void testToString(){
        System.out.println("Testing toString() method in Vector2d class.");

        assertTrue(testVector1.toString().equals("(1,-1)"));
        assertFalse(testVector1.toString().equals(testVector2.toString()));

        System.out.println("Tests completed.");
    }

    @Test
    public void testPrecedes(){
        System.out.println("Testing precedes() method in Vector2d class.");

        assertTrue(testVector1.precedes(testVector2));
        assertTrue(testVector1.precedes(new Vector2d(1, 1)));
        assertFalse(testVector2.precedes(testVector1));
        assertFalse(testVector1.precedes(new Vector2d(-1, -1)));

        System.out.println("Tests completed.");
    }

    @Test
    public void testFollows(){
        System.out.println("Testing follows() method in Vector2d class.");

        assertFalse(testVector1.follows(testVector2));
        assertFalse(testVector1.follows(new Vector2d(1, 1)));
        assertTrue(testVector2.follows(testVector1));
        assertTrue(testVector1.follows(new Vector2d(-1, -1)));

        System.out.println("Tests completed.");
    }

    @Test
    public void testUpperRight(){
        System.out.println("Testing upperRight() method in Vector2d class.");

        assertTrue(testVector1.upperRight(testVector2).equals(testVector2));
        assertFalse(testVector2.upperRight(testVector1).equals(testVector1));

        System.out.println("Tests completed.");
    }

    @Test
    public void testLowerLeft(){
        System.out.println("Testing lowerLeft() method in Vector2d class.");

        assertTrue(testVector1.lowerLeft(testVector2).equals(testVector1));
        assertFalse(testVector2.lowerLeft(testVector1).equals(testVector2));

        System.out.println("Tests completed.");
    }

    @Test
    public void testAdd(){
        System.out.println("Testing add() method in Vector2d class.");

        assertTrue(testVector1.add(testVector2).equals(new Vector2d(3, -1)));

        System.out.println("Tests completed.");
    }

    @Test
    public void testSubtract(){
        System.out.println("Testing subtract() method in Vector2d class.");

        assertTrue(testVector1.subtract(testVector2).equals(new Vector2d(-1, -1)));

        System.out.println("Tests completed.");
    }

    @Test
    public void testOpposite(){
        System.out.println("Testing opposite() method in Vector2d class.");

        assertTrue(testVector1.opposite().equals(new Vector2d(-1, 1)));

        System.out.println("Tests completed.");
    }
}
