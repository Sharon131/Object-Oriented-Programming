package agh.cs.lab5;

import org.junit.Test;

public class MapDirectionTest {

    @Test
    public void testNext(){
        System.out.println("Testing next() method in MapDirection class.");

        junit.framework.TestCase.assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
        junit.framework.TestCase.assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        junit.framework.TestCase.assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        junit.framework.TestCase.assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);

        System.out.println("Tests completed.");
    }

    @Test
    public void testPrevious(){
        System.out.println("Testing previous() method in MapDirection class.");

        junit.framework.TestCase.assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        junit.framework.TestCase.assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        junit.framework.TestCase.assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        junit.framework.TestCase.assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);

        System.out.println("Tests completed.");
    }
}
