package mars_rover;

import java.util.Objects;

public class Rover {

    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                rotateLeft();
            }

            if (command.equals("r")) {
                rotateRight();
            }

            if (command.equals("b")) {
                moveBackwards();
            }

            if (command.equals("f")) {
                moveForwards();
            }
        }
    }

    private void moveForwards() {
        int displacement = 1;
        move(displacement);
    }

    private void moveBackwards() {
        int displacement = -1;
        move(displacement);
    }

    private void move(int displacement) {
        if (facesNorth()) {
            this.coordinates = new Coordinates(coordinates.x(), coordinates.y() + displacement);
        } else if (facesSouth()) {
            this.coordinates = new Coordinates(coordinates.x(), coordinates.y() - displacement);
        } else if (facesWest()) {
            this.coordinates = new Coordinates(coordinates.x() - displacement, coordinates.y());
        } else {
            this.coordinates = new Coordinates(coordinates.x() + displacement, coordinates.y());
        }
    }

    private boolean facesNorth() {
        return direction.equals(Direction.N);
    }

    private void rotateRight() {
        this.direction = direction.rotateRight();
    }

    private boolean facesWest() {
        return direction.equals(Direction.W);
    }

    private boolean facesSouth() {
        return direction.equals(Direction.S);
    }

    private void rotateLeft() {
        this.direction = direction.rotateLeft();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return direction == rover.direction &&
                Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, coordinates);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", coordinates=" + coordinates +
                '}';
    }

}
