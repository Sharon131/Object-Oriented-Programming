package agh.cs.lab1;

public class World {

    public static void main(String[] args) {
        System.out.println("Start");
        Direction arguments[] = convert(args);
        run(arguments);
        System.out.println("Stop");
    }

    public static Direction[] convert(String[] args) {
        Direction[] enums = new Direction[args.length];

        for(int index = 0; index < args.length; index++){
            switch (args[index]) {
                case "f":
                    enums[index] = Direction.FORWARD;
                    break;
                case "b":
                    enums[index] = Direction.BACKWARD;
                    break;
                case "l":
                    enums[index] = Direction.LEFT;
                    break;
                case "r":
                    enums[index] = Direction.RIGHT;
                    break;
                default:
                    enums[index] = Direction.NOTKNOWN;
                    break;
            }
        }

        return enums;
    }


    public static void run(Direction[] args) {

        for(Direction argument : args){
            switch (argument) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skreca w lewo");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skreca w prawo");
                    break;
            }
        }

        for(Direction argument : args){
            System.out.print(argument);

            if (!argument.equals(args[args.length - 1])) {
                System.out.print(", ");
            }
        }

        System.out.print("\n");
    }
}

