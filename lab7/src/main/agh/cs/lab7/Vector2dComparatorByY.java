package agh.cs.lab7;

import java.util.Comparator;

public class Vector2dComparatorByY implements Comparator {

    @Override
    public int compare(Object object1, Object object2) {
        if(!(object1 instanceof Vector2d && object2 instanceof Vector2d)){
            throw new ClassCastException("One of object is not instance of Vector2d");
        }
        Vector2d vector1 = (Vector2d)object1;
        Vector2d vector2 = (Vector2d)object2;

        if(vector1.y == vector2.y && vector1.x == vector2.x){
            return 0;
        }
        if(vector1.y == vector2.y && vector1.x < vector2.x){
            return -1;
        }
        if(vector1.y == vector2.y && vector1.x > vector2.x){
            return 1;
        }
        if(vector1.y < vector2.y){
            return -1;
        }

        return 1;
    }
}
