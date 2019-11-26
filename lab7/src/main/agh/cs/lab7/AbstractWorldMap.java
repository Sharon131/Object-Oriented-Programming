package agh.cs.lab7;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    private MapVisualizer visualizer = new MapVisualizer(this);
    protected MapBoundary mapBoundaries = new MapBoundary();
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsByPositions = new HashMap<>();

    public String toString (){
        Vector2d [] Corners = getLowerLeftAndUpperRightCorner();

        return visualizer.draw(Corners[0], Corners[1]);
    }

    protected Vector2d[] getLowerLeftAndUpperRightCorner(){
        Vector2d lowerLeft = new Vector2d(mapBoundaries.getMinX(), mapBoundaries.getMinY());
        Vector2d upperRight = new Vector2d(mapBoundaries.getMaxX(), mapBoundaries.getMaxY());
        Vector2d[] Corners = {lowerLeft, upperRight};
        return Corners;
    }

    @Override
    public boolean place(Animal animal) {

        if (this.objectAt(animal.getPosition()) instanceof Animal) {
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied by another animal.");
        }
        animals.add(animal);
        animalsByPositions.putIfAbsent(animal.getPosition(), animal);
        animal.addObserver(this);
        animal.addObserver(mapBoundaries);
        mapBoundaries.addNewPosition(animal.getPosition());
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
