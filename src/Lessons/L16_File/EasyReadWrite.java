package Lessons.L16_File;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyReadWrite {

    public static void main(String[] args) throws IOException {
        File fileOut = Path.of("resources", "output.txt").toFile();
        /// очистим выходной файл
        try {
            FileWriter fstream = new FileWriter(fileOut);// конструктор с одним параметром - для перезаписи
            BufferedWriter out = new BufferedWriter(fstream); //  создаём буферезированный поток
            out.write(""); // очищаем, перезаписав поверх пустую строку
            out.close(); // закрываем
        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }

        /// read
        File fileIn = Path.of("resources", "regExp18.txt").toFile();
        String str = new String();
        String strRowTab = new String();
        String strNameAuto = new String();
        String strYearAuto = new String();
        String strDescriptAuto = new String();
        String strAuto = "";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileIn))) {
            str = fileReader.lines().collect(Collectors.joining("\n"));
            //System.out.println(strRowTab);
            fileReader.close();
        }
        String strPatternRowTab = "<tr>\\n<td>(.+?)</tr>"; // <tr>\n<td>(.+?)</tr>
        System.out.println("strPatternRowTab = " + strPatternRowTab);
        String strPatternName = "(?<=title\\=\\\"Cadillac )(.*)(?=\\\">.*\\<\\/a\\>\\n)"; // (?<=title\=\"Cadillac )(.*)(?=\">.*\<\/a\>\n)
        System.out.println("strPatternName = " + strPatternName);
        String strPatternYear = "(?<=\\<td\\>)\\d{4}(?=\\n)"; // (?<=\<td\>)\d{4}(?=\n)
        System.out.println("strPatternYear = " + strPatternYear);
        String strPatternCell = "<td>(.+?)\\n</td>"; // <td>(.+?)\n</td>
        System.out.println("strPatternCell = " + strPatternCell);
        System.out.println("__________auto______________");
        Pattern patternRowTab = Pattern.compile(strPatternRowTab, Pattern.DOTALL | Pattern.MULTILINE);
        //Pattern patternRowTab = Pattern.compile(strPatternRowTab, Pattern.MULTILINE);
        Pattern patternName = Pattern.compile(strPatternName, Pattern.MULTILINE);
        Pattern patternYear = Pattern.compile(strPatternYear, Pattern.MULTILINE);
        Pattern patternCell = Pattern.compile(strPatternCell, Pattern.MULTILINE);

        Matcher m = patternRowTab.matcher(str);
        Matcher mName;
        Matcher mYear;
        Matcher mCell; // для перебора ячеек таблицы

        while (m.find()) {
            strAuto = "";
            strRowTab = m.group(0); // получили строку для анализа
            mName = patternName.matcher(strRowTab);
            if (mName.find()) {
                strNameAuto = mName.group(0);
            } else {
                continue;
            }
            mYear = patternYear.matcher(strRowTab);
            if (mYear.find()) {
                strYearAuto = mYear.group(0);
            } else {
                strYearAuto = "????";
            }
            /// описание всегда последнее поле в строке strRowTab
            mCell = patternCell.matcher(strRowTab);
            strDescriptAuto = "none";
            while (mCell.find()) {
                strDescriptAuto = mCell.group(0);
            } // пробегаем по всем последняя всегда описание
            strDescriptAuto = strDescriptAuto.replaceAll("\\<.*?>", ""); // чистим от тегов
            strAuto = " model - '" + strNameAuto + "', calendar year introduced - " + strYearAuto + ", vehicle description: " + strDescriptAuto;
            System.out.println(strAuto);
            writeToFile(strAuto);
        }
    }

    private static void writeToFile(String strAuto) throws IOException {
        File fileOut = Path.of("resources", "auto.txt").toFile();
        FileWriter fw = new FileWriter(fileOut, true);
        try (BufferedWriter fileWriter = new BufferedWriter(fw)) {

            ///подготовленную строку записываем в файл auto.txt
            fileWriter.append(strAuto);
//            fileWriter.newLine();
        }
        fw.close();
    }
}
