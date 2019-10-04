package ca.bcit.comp2522.labs.lab04;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class DataCube {
    private Cube[][][] data;
    private Random rand;

    public DataCube(int length, int width, int height) {
        this.data = new Cube[length][width][height];
        this.rand = new Random();
    }

    public void populate(int cubes) {
        for (int i = 0; i < cubes; i++) {
            int length = rand.nextInt(data.length);
            int width = rand.nextInt(data[0].length);
            int height = rand.nextInt(data[0][0].length);
            Cube newCube = new Cube(length, width, height);
            data[length][width][height] = newCube;
        }
    }

    public double sum() {
        double sum = 0.0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length; k++) {
                    if (data[i][j][k] != null) {
                        sum += data[i][j][k].getValue();
                    }
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "DataCube{" +
                "data=" + Arrays.toString(data) +
                ", rand=" + rand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataCube dataCube = (DataCube) o;
        return Arrays.equals(data, dataCube.data) &&
                Objects.equals(rand, dataCube.rand);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rand);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
