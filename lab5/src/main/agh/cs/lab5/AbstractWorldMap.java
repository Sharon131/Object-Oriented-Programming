package agh.cs.lab5;

import java.util.List;

abstract public class AbstractWorldMap implements IWorldMap {
    private MapVisualizer visualizer = new MapVisualizer(this);

    abstract protected Vector2d[] getLowerLeftAndUpperRightCorner();
    abstract protected List<Animal> getAnimals();

    public String toString (){
        Vector2d [] Corners = getLowerLeftAndUpperRightCorner();

        return visualizer.draw(Corners[0], Corners[1]);
    }

    @Override
    public boolean place(Animal animal) {

        if (this.objectAt(animal.getPosition()) instanceof Animal) {
            return false;
        }
        getAnimals().add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        List<Animal> animals = getAnimals();
        int numberOfAnimals = animals.size();

        for (int index = 0; index < directions.length; index++) {
            Animal animalOnMap = animals.get(index % numberOfAnimals);
            animalOnMap.move(directions[index]);
            animals.set(index % numberOfAnimals, animalOnMap);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (this.objectAt(position) != null);
    }
}
