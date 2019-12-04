package ca.bcit.comp2522.labs.lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of text file");
        String input = in.nextLine();
        readFile(input);
    }

    static String readFile(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            String st;
            while((st = br.readLine()) != null) {

            }
        }
    }


}
