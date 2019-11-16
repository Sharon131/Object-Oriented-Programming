package agh.cs.lab7;

public class RectangularMap extends AbstractWorldMap {
    private Vector2d upperRightCornerOfMap;
    private Vector2d lowerLeftCornerOfMap;

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
    public boolean canMoveTo(Vector2d position) {

        if (this.isOccupied(position)) return false;

        return position.precedes(upperRightCornerOfMap) && position.follows(lowerLeftCornerOfMap);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalsByPositions.get(position);
    }
}
