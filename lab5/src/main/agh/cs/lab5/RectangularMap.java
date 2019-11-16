package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private Vector2d upperRightCornerOfMap;
    private Vector2d lowerLeftCornerOfMap;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        upperRightCornerOfMap = new Vector2d(width, height);
        lowerLeftCornerOfMap = new Vector2d(0, 0);
    }

    @Override
    protected Vector2d[] getLowerLeftAndUpperRightCorner() {
        Vector2d[] Corners = {lowerLeftCornerOfMap, upperRightCornerOfMap};
        return Corners;
    }

    @Override
    protected List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        if (this.isOccupied(position)) return false;

        return position.precedes(upperRightCornerOfMap) && position.follows(lowerLeftCornerOfMap);
    }

    @Override
    public Object objectAt(Vector2d position) {

        for (Animal animal: animals) {
            if (animal.position.equals(position)){
                return animal;
            }
        }

        return null;
    }
}
