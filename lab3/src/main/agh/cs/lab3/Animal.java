package agh.cs.lab3;

public class Animal {
    public Vector2d position = new Vector2d(2,2);
    public MapDirection orientation = MapDirection.NORTH;

    public String toString(){
        return "(" + this.position.x + "," + this.position.y + ") " + this.orientation;
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
            switch(this.orientation){
                case NORTH:
                    if(position.y < 4){
                        position = position.add(new Vector2d(0, 1));
                    }
                    break;
                case SOUTH:
                    if(position.y > -4) {
                        position = position.add(new Vector2d(0, -1));
                    }
                    break;
                case EAST:
                    if(position.x < 4) {
                        position = position.add(new Vector2d(1, 0));
                    }
                    break;
                case WEST:
                    if(position.x > -4){
                        position = position.add(new Vector2d(-1, 0));
                    }
                    break;
                default:
                    break;
            }
            return;
        }
        if(direction == MoveDirection.BACKWARD) {
            switch(this.orientation){
                case NORTH:
                    if(position.y >-4){
                        position = position.add(new Vector2d(0, -1));
                    }
                    break;
                case SOUTH:
                    if(position.y < 4) {
                        position = position.add(new Vector2d(0, 1));
                    }
                    break;
                case EAST:
                    if(position.x > -4) {
                        position = position.add(new Vector2d(-1, 0));
                    }
                    break;
                case WEST:
                    if(position.x < 4){
                        position = position.add(new Vector2d(1, 0));
                    }
                    break;
                default:
                    break;
            }
            return;
        }
    }
}
