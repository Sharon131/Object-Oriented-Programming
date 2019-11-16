package agh.cs.lab7;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private List<Grass> grasses = new ArrayList<>();
    private Random rand = new Random();

    public GrassField(int NumberOfGrassFields){
        for(int i=0; i < NumberOfGrassFields; i++){
            int square = (int) sqrt(NumberOfGrassFields*10);
            Vector2d position = new Vector2d(rand.nextInt(square), rand.nextInt(square));

            if(this.isOccupied(position)){
                position = position.add(new Vector2d(rand.nextInt(square), rand.nextInt(square)));
            }

            grasses.add(new Grass(position));
        }
    }

    @Override
    protected Vector2d[] getLowerLeftAndUpperRightCorner() {
        Vector2d[] Corners = {null, null};

        Vector2d[] maxAndMinAnimalPos = maxAndMinAnimalPosition();
        Vector2d[] maxAndMinGrassPos = maxAndMinGrassPosition();

        if(maxAndMinAnimalPos[1].precedes(maxAndMinGrassPos[1])){
            Corners[0] = maxAndMinAnimalPos[1];
        } else {
            Corners[0] = maxAndMinGrassPos[1];
        }

        if(maxAndMinAnimalPos[0].follows(maxAndMinGrassPos[0])) {
            Corners[1] = maxAndMinAnimalPos[0];
        } else {
            Corners[1] = maxAndMinGrassPos[0];
        }

        return Corners;
    }

    private Vector2d[] maxAndMinAnimalPosition(){
        Vector2d[] maxAndMinPosition = {new Vector2d(0, 0), new Vector2d(0, 0)};

        for (Animal animal: animals) {
            if (animal.position.follows(maxAndMinPosition[0])){
                maxAndMinPosition[0] = animal.getPosition();
            }

            if (animal.position.precedes(maxAndMinPosition[1])){
                maxAndMinPosition[1] = animal.getPosition();
            }
        }
        return maxAndMinPosition;
    }

    private Vector2d[] maxAndMinGrassPosition(){
        Vector2d[] maxAndMinPosition = {new Vector2d(0, 0), new Vector2d(0, 0)};

        for (Grass grass: grasses) {
            if (grass.position.follows(maxAndMinPosition[0])){
                maxAndMinPosition[0] = grass.getPosition();
            }

            if (grass.position.precedes(maxAndMinPosition[1])){
                maxAndMinPosition[1] = grass.getPosition();
            }
        }
        return maxAndMinPosition;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(this.objectAt(position) instanceof Animal));
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object =  animalsByPositions.get(position);
        if(object != null)      return object;

        for (Grass grass: grasses) {
            if (grass.getPosition().equals(position)){
                return grass;
            }
        }

        return null;
    }
}
