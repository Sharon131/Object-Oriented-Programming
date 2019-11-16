package agh.cs.lab6;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other){
        if(this.x >= other.x && this.y >= other.y){
            return true;
        } else{
            return false;
        }
    }

    public Vector2d upperRight(Vector2d other){
        int temp_x = 0;
        int temp_y = 0;

        temp_x = Math.max(this.x, other.x);

        temp_y = Math.max(this.y, other.y);

        return new Vector2d(temp_x, temp_y);
    }

    public Vector2d lowerLeft(Vector2d other){
        int temp_x = 0;
        int temp_y = 0;

        if (this.x<=other.x){
            temp_x = this.x;
        } else{
            temp_x = other.x;
        }

        if (this.y<=other.y){
            temp_y = this.y;
        } else {
            temp_y = other.y;
        }

        return new Vector2d(temp_x, temp_y);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x, this.y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.x, this.y-other.y);
    }

    public boolean equals(Object other){
        if (other==this){
            return true;
        }
        if (!(other instanceof Vector2d)){
            return false;
        }
        Vector2d that = (Vector2d) other;

        return this.x == that.x && this.y == that.y;
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }
}
