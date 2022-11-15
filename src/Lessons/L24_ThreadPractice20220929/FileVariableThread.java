package Lessons.L24_ThreadPractice20220929;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class FileVariableThread implements Runnable {
    private File fileFIO;
    private File fileAdr;
    private File fileHours;

    public FileVariableThread(File fileFIO, File fileAdr, File fileHours) {
        this.fileFIO = fileFIO;
        this.fileAdr = fileAdr;
        this.fileHours = fileHours;
    }

/*
2/ Отдельный поток по окончанию работы потоков из пункта 1,
создает новый файл (каждый раз как запускается - создать новый файл, сохранив предыдущие),
в файл записать все возможные вариации из 3 файлов, сгенерированных файлов в пункте 1.
 */

    @Override
    public void run() {
        synchronized (fileFIO){
            synchronized (fileAdr){
                synchronized (fileHours){
                    while (true){
                        try {
                            List<String> listFIO = Files.readAllLines(fileFIO.toPath());
                            fileFIO.delete();
                            fileFIO.notifyAll();// освобождаем
                            List<String> listAdr = Files.readAllLines(fileAdr.toPath());
                            fileAdr.delete();
                            fileAdr.notifyAll();// освобождаем
                            List<String> listHours = Files.readAllLines(fileHours.toPath());
                            fileHours.delete();
                            fileHours.notifyAll();// освобождаем
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        //собираем в новый файл variable.txt возможные варианты

                    }
                }
            }
        }
        //Считываем в list весь файл целиком


//        // реализация readAllLines в исходниках
//        try (BufferedReader reader = new BufferedReader(path, cs)) {
//            List<String> result = new ArrayList<>();
//            for (;;) {
//                String line = reader.readLine();
//                if (line == null)
//                    break;
//                result.add(line);
//            }
    }
//    private List<String> File2Array(File file){
//        //String fileName = "e:\\test.txt";
//        List<String> list = new ArrayList<>();
//
//        try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
//            String str;
//            list = br.lines().collect(Collectors.toList());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

}
