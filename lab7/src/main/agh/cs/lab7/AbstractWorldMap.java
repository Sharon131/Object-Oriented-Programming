package agh.cs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap {
    private MapVisualizer visualizer = new MapVisualizer(this);
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsByPositions = new HashMap<>();

    abstract protected Vector2d[] getLowerLeftAndUpperRightCorner();

    public String toString (){
        Vector2d [] Corners = getLowerLeftAndUpperRightCorner();

        return visualizer.draw(Corners[0], Corners[1]);
    }

    @Override
    public boolean place(Animal animal) {

        if (this.objectAt(animal.getPosition()) instanceof Animal) {
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied by another animal.");
        }
        animals.add(animal);
        animalsByPositions.putIfAbsent(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int numberOfAnimals = animals.size();

        for (int index = 0; index < directions.length; index++) {
            Animal animalOnMap = animals.get(index % numberOfAnimals);
            Vector2d positionOfAnimal = animalOnMap.getPosition();

            animalOnMap.move(directions[index]);
            animals.set(index % numberOfAnimals, animalOnMap);

            if(!positionOfAnimal.equals(animalOnMap.getPosition())){
                animalsByPositions.remove(positionOfAnimal);
                animalsByPositions.putIfAbsent(animalOnMap.getPosition(), animalOnMap);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (this.objectAt(position) != null);
    }
}
