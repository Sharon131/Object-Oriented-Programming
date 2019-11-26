package agh.cs.lab7;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    private TreeSet<Vector2d> positionsByX = new TreeSet<>(new Vector2dComparatorByX());
    private TreeSet<Vector2d> positionsByY = new TreeSet<>(new Vector2dComparatorByY());

    public void addNewPosition(Vector2d position){
        positionsByX.add(position);
        positionsByY.add(position);
    }

    public int getMinX(){
        return positionsByX.first().x;
    }

    public int getMaxX(){
        return positionsByX.last().x;
    }

    public int getMinY(){
        return positionsByY.first().y;
    }

    public int getMaxY(){
        return positionsByY.last().y;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(oldPosition.x != newPosition.x){
            positionsByX.remove(oldPosition);
            positionsByX.add(newPosition);
        }

        if(oldPosition.y != newPosition.y){
            positionsByY.remove(oldPosition);
            positionsByY.add(newPosition);
        }
    }
}
