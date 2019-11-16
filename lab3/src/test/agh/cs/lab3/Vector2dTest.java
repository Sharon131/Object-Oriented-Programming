package agh.cs.lab3;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {

    private Vector2d testVector1 = new Vector2d(1, -1);
    private Vector2d testVector2 = new Vector2d(2, 0);

    @Test
    public void testEquals(){
        System.out.println("Testing equals() method in Vector2d class.");

        assertEquals(testVector1, new Vector2d(1, -1));
        assertNotEquals(testVector1, testVector2);
    }

    @Test
    public void testToString(){
        System.out.println("Testing toString() method in Vector2d class.");

        assertEquals("(1,-1)", testVector1.toString());
        assertNotEquals(testVector1.toString(), testVector2.toString());
    }

    @Test
    public void testPrecedes(){
        System.out.println("Testing precedes() method in Vector2d class.");

        junit.framework.TestCase.assertTrue(testVector1.precedes(testVector2));
        junit.framework.TestCase.assertTrue(testVector1.precedes(new Vector2d(1, 1)));
        junit.framework.TestCase.assertFalse(testVector2.precedes(testVector1));
        junit.framework.TestCase.assertFalse(testVector1.precedes(new Vector2d(-1, -1)));
    }

    @Test
    public void testFollows(){
        System.out.println("Testing follows() method in Vector2d class.");

        junit.framework.TestCase.assertFalse(testVector1.follows(testVector2));
        junit.framework.TestCase.assertFalse(testVector1.follows(new Vector2d(1, 1)));
        junit.framework.TestCase.assertTrue(testVector2.follows(testVector1));
        junit.framework.TestCase.assertTrue(testVector1.follows(new Vector2d(-1, -1)));
    }

    @Test
    public void testUpperRight(){
        System.out.println("Testing upperRight() method in Vector2d class.");

        assertEquals(testVector1.upperRight(testVector2), testVector2);
        assertNotEquals(testVector2.upperRight(testVector1), testVector1);
    }

    @Test
    public void testLowerLeft(){
        System.out.println("Testing lowerLeft() method in Vector2d class.");

        assertEquals(testVector1.lowerLeft(testVector2), testVector1);
        assertNotEquals(testVector2.lowerLeft(testVector1), testVector2);
    }

    @Test
    public void testAdd(){
        System.out.println("Testing add() method in Vector2d class.");

        TestCase.assertEquals(testVector1.add(testVector2), new Vector2d(3, -1));
    }

    @Test
    public void testSubtract(){
        System.out.println("Testing subtract() method in Vector2d class.");

        TestCase.assertEquals(testVector1.subtract(testVector2), new Vector2d(-1, -1));
    }

    @Test
    public void testOpposite(){
        System.out.println("Testing opposite() method in Vector2d class.");

        TestCase.assertEquals(testVector1.opposite(), new Vector2d(-1, 1));
    }
}
