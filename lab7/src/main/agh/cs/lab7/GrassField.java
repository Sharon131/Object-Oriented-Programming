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

            Grass grass = new Grass(position);
            grasses.add(grass);
            mapBoundaries.addNewGrass(grass);
        }
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
