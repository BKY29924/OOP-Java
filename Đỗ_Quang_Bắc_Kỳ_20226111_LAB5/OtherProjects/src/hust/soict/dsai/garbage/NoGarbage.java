package hust.soict.dsai.garbage;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Viet\\Documents\\GitHub\\20241_OOP_LAB\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.exe";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime, endTime;

        startTime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder(); 
        for (byte b : inputBytes) {
            sb.append((char) b);
        }
        String outputString = sb.toString();

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}