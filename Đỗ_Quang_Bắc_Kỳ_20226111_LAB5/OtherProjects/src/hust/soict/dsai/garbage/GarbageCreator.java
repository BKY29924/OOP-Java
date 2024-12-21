package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Viet\\Documents\\GitHub\\20241_OOP_LAB\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();

//        String outputString = "";
        StringBuilder outputString = new StringBuilder();
        for (byte b : inputBytes) {
//            outputString += (char) b;
        	outputString.append((char) b);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}