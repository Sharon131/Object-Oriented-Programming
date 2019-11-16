package agh.cs.lab6;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    @Override
    public String toString() {
        String toReturn = "";
        if (this==EAST){
            toReturn = "Wschód";
        }
        if (this==WEST){
            toReturn = "Zachód";
        }
        if (this==NORTH){
            toReturn = "Północ";
        }
        if (this==SOUTH) {
            toReturn = "Południe";
        }
        return toReturn;
    }

    public MapDirection next(){
        if(this==NORTH){
            return EAST;
        }
        if(this==WEST){
            return NORTH;
        }
        if (this==SOUTH){
            return WEST;
        }

        return SOUTH;
    }

    public MapDirection previous(){
        if(this==NORTH){
            return WEST;
        }
        if(this==WEST){
            return SOUTH;
        }
        if (this==SOUTH){
            return EAST;
        }

        return NORTH;
    }

    public Vector2d toUnitVector(){
        if(this==NORTH){
            return new Vector2d(0, 1);
        }
        if(this==WEST){
            return new Vector2d(-1, 0);
        }
        if (this==SOUTH){
            return new Vector2d(0, -1);
        }

        return new Vector2d(1, 0);
    }

}
