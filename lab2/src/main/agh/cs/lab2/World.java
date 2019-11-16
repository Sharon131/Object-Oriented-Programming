package agh.cs.lab2;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println("Add: " + position1.add(position2));
        System.out.println("Substract: " + position1.subtract(position2));
        System.out.println("ToString position1: " + position1.toString());
        System.out.println("Precedes: " + position1.precedes(position2));
        System.out.println("Follows: " + position1.follows(position2));
        System.out.println("UpperRight: " + position1.upperRight(position2));
        System.out.println("LowerLeft: " + position1.lowerLeft(position2));
        System.out.println("equals: " + position1.equals(position2));
        System.out.println("opposite position1: " + position1.opposite());


        System.out.println("Stop");
    }
}
