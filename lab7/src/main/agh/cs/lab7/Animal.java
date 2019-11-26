package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{
    public Vector2d position;
    public MapDirection orientation = MapDirection.NORTH;
    private AbstractWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public String toString(){
        String stringOrientation;
        switch (this.orientation) {
            case EAST:
                stringOrientation = ">";
                break;
            case WEST:
                stringOrientation = "<";
                break;
            case NORTH:
                stringOrientation = "^";
                break;
            case SOUTH:
                stringOrientation = "v";
                break;
            default:
                stringOrientation = ".";
                break;
        }
        return stringOrientation;
    }

    public Animal(AbstractWorldMap map) {
        this.map = map;
        position = new Vector2d(2,2);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.map = map;
        position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction){
        Vector2d oldPosition = this.position;
        if(direction == MoveDirection.RIGHT){
            orientation = orientation.next();
            return;
        }
        if(direction == MoveDirection.LEFT){
            orientation = orientation.previous();
            return;
        }
        if(direction == MoveDirection.FORWARD){
            if(map.canMoveTo(position.add(this.orientation.toUnitVector()))){
                position = position.add(this.orientation.toUnitVector());
                this.positionChanged(oldPosition, this.position);
            }
            return;
        }
        if(direction == MoveDirection.BACKWARD) {
            if(map.canMoveTo(position.subtract(this.orientation.toUnitVector()))) {
                position = position.subtract(this.orientation.toUnitVector());
                this.positionChanged(oldPosition, this.position);
            }
            return;
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}
