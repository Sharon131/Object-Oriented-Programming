package agh.cs.lab6;

public class World {
    private static IWorldMap map = new GrassField(10);

    public static void main(String[] args) {
        try{
            MoveDirection[] directions = new OptionParser().parse(args);
            IWorldMap map = new RectangularMap(10, 5);
            map.place(new Animal(map));
            //map.place(new Animal(map));
            map.place(new Animal(map,new Vector2d(3,4)));
            map.run(directions);

            System.out.println(map.toString());
        } catch(IllegalArgumentException exception){
            System.out.println(exception);
            System.exit(1);
        }


    }
}
