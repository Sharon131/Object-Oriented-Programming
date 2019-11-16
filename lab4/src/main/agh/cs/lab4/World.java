package agh.cs.lab4;

public class World {
    private static IWorldMap map = new RectangularMap(10, 5);
    private static Animal someAnimal = new Animal(map);

    private static OptionParser parser = new OptionParser();
    private static String[] stringToConvert = {"r", "f", "f", "f"};
    private static MoveDirection[] movesToMake = parser.parse(stringToConvert);

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);

        System.out.println(map.toString());
    }
}
