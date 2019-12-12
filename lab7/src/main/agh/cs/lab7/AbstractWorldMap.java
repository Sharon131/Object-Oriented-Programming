package agh.cs.lab7;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    private MapVisualizer visualizer = new MapVisualizer(this);
    protected MapBoundary mapBoundaries = new MapBoundary();
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsByPositions = new HashMap<>();

    public String toString (){
        Vector2d lowerLeft = mapBoundaries.getLowerLeftCornerOfMap();
        Vector2d upperRight = mapBoundaries.getUpperRightCornerOfMap();

        return visualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public boolean place(Animal animal) {

        if (this.objectAt(animal.getPosition()) instanceof Animal) {
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied by another animal.");
        }
        animals.add(animal);
        animalsByPositions.putIfAbsent(animal.getPosition(), animal);
        animal.addObserver(this);
        mapBoundaries.addNewAnimal(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int numberOfAnimals = animals.size();

        for (int index = 0; index < directions.length; index++) {
            Animal animalOnMap = animals.get(index % numberOfAnimals);
            animalOnMap.move(directions[index]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (this.objectAt(position) != null);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animalOnMap = animalsByPositions.get(oldPosition);
        animalsByPositions.remove(oldPosition);
        animalsByPositions.putIfAbsent(animalOnMap.getPosition(), animalOnMap);
    }
}
