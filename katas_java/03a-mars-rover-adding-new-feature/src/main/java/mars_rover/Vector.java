package mars_rover;

import java.util.Objects;

class Vector {
    private Coordinates coordinates;
    private Direction direction;
    private int movementDelta;

    Vector(Coordinates coordinates, Direction direction, int movementDelta) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.movementDelta = movementDelta;
    }

    public Vector turnRight() {
        this.direction = direction.turnRight();
        return this;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Vector turnLeft() {
        this.direction = direction.turnLeft();
        return this;
    }

    public Vector moveForward() {
        this.coordinates = this.direction.moveForward(coordinates, this.movementDelta);
        return this;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public Vector moveBackwards() {
        this.coordinates = this.direction.moveBackwards(coordinates, this.movementDelta);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return movementDelta == vector.movementDelta &&
                Objects.equals(coordinates, vector.coordinates) &&
                direction == vector.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction, movementDelta);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "coordinates=" + coordinates +
                ", direction=" + direction +
                ", movementDelta=" + movementDelta +
                '}';
    }
}
