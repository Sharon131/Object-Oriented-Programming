package agh.cs.lab4;

public class Animal {
    public Vector2d position;
    public MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;

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

    public Animal(IWorldMap map) {
        this.map = map;
        position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        position = initialPosition;
    }

    Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction){
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
            }
            return;
        }
        if(direction == MoveDirection.BACKWARD) {
            if(map.canMoveTo(position.subtract(this.orientation.toUnitVector()))) {
                position = position.subtract(this.orientation.toUnitVector());
            }
            return;
        }
    }
}
