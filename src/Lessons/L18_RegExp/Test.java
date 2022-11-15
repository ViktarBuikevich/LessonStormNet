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

        // ������������ ������
        String pattern = "(?<=title\\=\\\"Cadillac ).*(?=\">)";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        String name;
        int year;
        String title;
     try {
        File file = Path.of("resources","regExp18.txt").toFile(); //new File("file.txt");
        //������� ������ FileReader ��� ������� File
        FileReader fr = new FileReader(file);
        //������� BufferedReader � ������������� FileReader ��� ����������� ����������
        BufferedReader reader = new BufferedReader(fr);
        // ������� ������� ������ ������
        String line = new String();
        do {
            line = reader.readLine();

            //
            Matcher m = r.matcher(line);

            if (m.find()) {

                //������� ��������
                //������
                // �����

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

