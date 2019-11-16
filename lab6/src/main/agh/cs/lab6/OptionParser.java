package agh.cs.lab6;

public class OptionParser {
    private String[] possibleArguments = {"f", "forward", "b", "backward", "r", "right", "l", "left"};

    private boolean isLegalArgument(String command){

        for(String arg: possibleArguments){
            if(command.equals(arg)){
                return true;
            }
        }
        return false;
    }

    public MoveDirection[] parse(String[] strings){
        MoveDirection[] arrayToReturn = new MoveDirection[strings.length];

        for (int index = 0; index < strings.length; index++){
            if(!isLegalArgument(strings[index])){
                throw new IllegalArgumentException(strings[index] + " is not legal move specification");
            }

            if (strings[index].equals("f") || strings[index].equals("forward")){
                arrayToReturn[index] = MoveDirection.FORWARD;
            } else if (strings[index].equals("b") || strings[index].equals("backward")){
                arrayToReturn[index] = MoveDirection.BACKWARD;
            } else if (strings[index].equals("r") || strings[index].equals("right")){
                arrayToReturn[index] = MoveDirection.RIGHT;
            } else if (strings[index].equals("l") || strings[index].equals("left")){
                arrayToReturn[index] = MoveDirection.LEFT;
            } else{
                throw new IllegalArgumentException(strings[index] + " is not legal move specification");
            }
        }

        return arrayToReturn;
    }
}
