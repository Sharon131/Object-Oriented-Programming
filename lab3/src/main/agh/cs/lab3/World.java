package agh.cs.lab3;

public class World {
    private static Animal someAnimal = new Animal();

    private static OptionParser parser = new OptionParser();
    private static String[] stringToConvert = {"r", "f", "f", "f"};
    private static MoveDirection[] movesToMake = parser.parse(stringToConvert);

    public static void main(String[] args) {
        System.out.println("Start");

        System.out.println(someAnimal.toString());

        for (MoveDirection direction: movesToMake){
            someAnimal.move(direction);
        }

        System.out.println(someAnimal.toString());

        System.out.println("Stop");
    }
}
