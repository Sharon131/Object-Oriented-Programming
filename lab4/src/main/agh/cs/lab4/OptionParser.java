package agh.cs.lab4;

public class OptionParser {

    public MoveDirection[] parse(String[] strings){
        MoveDirection[] arrayToReturn = new MoveDirection[strings.length];

        for (int index = 0; index < strings.length; index++){
            if (strings[index].equals("f") || strings[index].equals("forward")){
                arrayToReturn[index] = MoveDirection.FORWARD;
            } else if (strings[index].equals("b") || strings[index].equals("backward")){
                arrayToReturn[index] = MoveDirection.BACKWARD;
            } else if (strings[index].equals("r") || strings[index].equals("right")){
                arrayToReturn[index] = MoveDirection.RIGHT;
            } else if (strings[index].equals("l") || strings[index].equals("left")){
                arrayToReturn[index] = MoveDirection.LEFT;
            } else{
                arrayToReturn[index] = MoveDirection.NOTKNOWN;
            }
        }

        return arrayToReturn;
    }
}
