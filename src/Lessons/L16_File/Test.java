package Lessons.L16_File;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {
        //File file = new File("resources/test.txt");
        File file =Path.of("resources","test.txt").toFile();
//        try (FileInputStream inputStream = new FileInputStream(file)) {
//            byte[] bytes = inputStream.readAllBytes();
//            String strVal =new String(bytes);
//
//            System.out.println(strVal);
//            System.out.println("Косяк!");
//        }
//++++++++++++
       try(BufferedReader fileReader = new BufferedReader(new FileReader(file))){
           String collect = fileReader.lines().collect(Collectors.joining("\n"));
           System.out.println(collect);
       };
//++++++++++++

//        File file = new File("C:\\JavaPRJ\\StormNet\\src\\test.txt");
//        try {
//            FileInputStream input =new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        char[] info =new char[256];
//        FileReader fileReader = new FileReader("C:\\JavaPRJ\\StormNet\\src\\test.txt");
//        fileReader.read(info);
//        System.out.println(Arrays.toString(info));
//        fileReader.close();


//        String strIn;
//        Scanner in = new Scanner(System.in);
//        FileWriter fileWriter =new FileWriter("C:\\JavaPRJ\\StormNet\\src\\test.txt");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Enter string N"+i+":");
//            strIn = in.next();
//            fileWriter.write(strIn+"\n");
//        }
//        fileWriter.close();


    }
}
