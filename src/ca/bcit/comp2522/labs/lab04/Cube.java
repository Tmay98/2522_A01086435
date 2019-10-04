package ca.bcit.comp2522.labs.lab04;

import java.util.Objects;
import java.util.Random;

public class Cube {
    private int x;
    private int y;
    private int z;
    private double value;
    private Random rand;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        rand = new Random();
        this.value = rand.nextDouble();
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", value=" + value +
                ", rand=" + rand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return x == cube.x &&
                y == cube.y &&
                z == cube.z &&
                Double.compare(cube.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, value);
    }
}
