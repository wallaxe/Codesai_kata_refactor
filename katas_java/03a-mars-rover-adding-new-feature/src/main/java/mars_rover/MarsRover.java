package mars_rover;

import java.util.Objects;

public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
    private Vector vector;

    public MarsRover(int x, int y, String direction) {
        this.vector = new Vector(new Coordinates(x, y), Direction.parse(direction), MOVEMENT_DELTA);
    }

    public void receive(String commandsSequence) {
        for (String command : commandsSequence.split("")) {
            executeCommand(command);
        }
    }

    private void executeCommand(String command) {
        String commandRepresentation = command;
        //Command command = createCommand(commandRepresentation);
        //vector = command.execute(vector);


        if (command.equals("r")) {
            vector.turnRight();
        } else if (command.equals("l")) {
            vector.turnLeft();
        } else if (command.equals("f")) {
            vector.moveForward();
        } else if (command.equals("b")) {
            vector.moveBackwards();
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return Objects.equals(vector, marsRover.vector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "vector=" + vector +
                '}';
    }
}
