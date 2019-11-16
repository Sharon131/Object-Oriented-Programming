package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private Vector2d upperRightCornerOfMap;
    private Vector2d lowerLeftCornerOfMap;
    private List<Animal> animals = new ArrayList<>();
    private MapVisualizer visualizer = new MapVisualizer(this);

    public RectangularMap(int width, int height) {
        upperRightCornerOfMap = new Vector2d(width, height);
        lowerLeftCornerOfMap = new Vector2d(0, 0);
    }

    public String toString () {
        return visualizer.draw(lowerLeftCornerOfMap, upperRightCornerOfMap);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        if (this.isOccupied(position)) return false;

        return position.precedes(upperRightCornerOfMap) && position.follows(lowerLeftCornerOfMap);
    }

    @Override
    public boolean place(Animal animal) {

        if (this.isOccupied(animal.position)) {
                return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int numberOfAnimals = animals.size();

        for (int index = 0; index < directions.length; index++) {
            Animal animalOnMap = animals.get(index % numberOfAnimals);
            animalOnMap.move(directions[index]);
            animals.set(index % numberOfAnimals, animalOnMap);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.position.equals(position)) {
                return true;
            }
        }
        return false;
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
