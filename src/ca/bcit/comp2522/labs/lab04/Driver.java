package ca.bcit.comp2522.labs.lab04;

public class Driver {
    public static void main(String[] args) {
        DataCube dataCube = new DataCube(10, 20, 30);
        dataCube.populate(3000);
        System.out.println("Total value is: " + dataCube.sum());
    }
}
