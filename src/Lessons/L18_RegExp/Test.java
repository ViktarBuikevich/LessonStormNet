package Lessons.L18_RegExp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        // обрабатываем строку
        String pattern = "(?<=title\\=\\\"Cadillac ).*(?=\">)";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        String name;
        int year;
        String title;
     try {
        File file = Path.of("resources","regExp18.txt").toFile(); //new File("file.txt");
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = new String();
        do {
            line = reader.readLine();

            //
            Matcher m = r.matcher(line);

            if (m.find()) {

                //получаю название
                //считит
                // нашли

            } else {

            }


            System.out.println(line);

        }while (line != null);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

