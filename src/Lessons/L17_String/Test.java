package Lessons.L17_String;

import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

    public static void main(String args[]) throws IOException {
        // регулярка для поиска строки с названием авто
        String strPatternName = "(?<=title\\=\\\"Cadillac ).*(?=\\\">.*\\<\\/a\\>\\n)";  //(?<=title\=\"Cadillac ).*(?=\">.*\<\/a\>\n)
        String strPatternYear = "(?<=\\<td\\>)\\d{4}(?=\\n)";
        String strPatternInfo = "(?<=\\<td\\>)\\d{4}(?=\\n)";
        // создаем паттерн поиска
        Pattern patternName = Pattern.compile(strPatternName);

        File fileIn= Path.of("resources", "regExp18.txt").toFile();
        FileReader fr =new FileReader(fileIn);
        BufferedReader br = new BufferedReader(fr);
        //StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //объявляем поисковик
        Matcher m;
        // строка в которую собираем сведения о найденном авто
        // model - calendar year introduced - vehicle description
        String strAuto = "";
        while (line !=null && line.substring(0,11)=="<td><a href="){
            // передаем строку для поиск регулирки в ней
            m = patternName.matcher(line);
            if (m.find()) {
                strAuto= "model: "+m.group(0);
                // далее поиск

            } else {
                System.out.println("NO MATCH");
            }

            // к следующей строке
            line = br.readLine();
        }

        writeToFile(strAuto);
        //считаем строку из regExp18.txt
//            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileIn))) {
//                String line = fileReader.lines()
//                        .collect(Collectors.joining("\n"));
//                System.out.println(line);
//            }
            //String line = "This order was placed for QT3000! OK?";




        // Now create matcher object.
        //Matcher m = r.matcher(line);

//        if (m.find()) {
//            System.out.println("Found value: " + m.group(0));
//            System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2));
//        } else {
//            System.out.println("NO MATCH");
//        }


    }

    private static void writeToFile(String strAuto) throws IOException {
        File fileOut= Path.of("resources", "auto.txt").toFile();
        FileWriter fw = new FileWriter(fileOut, true);
        try(BufferedWriter fileWriter = new BufferedWriter(fw)) {
//            String strAuto = "";
            ///подготовленную строку записываем в файл auto.txt
            fileWriter.append(strAuto);
            fileWriter.newLine();
        }
        fw.close();
    }
}

