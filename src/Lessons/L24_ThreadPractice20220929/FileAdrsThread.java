package Lessons.L24_ThreadPractice20220929;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAdrsThread implements Runnable {
    private  File file;
    private String[] adr = {"ул.Алаизы Ажэшка", "ул.Першамайская", "пер.Яблоневый", "заул.Солнечный", "ул.Газеты Наша Нива", "ул. Имя Кастуся Калиноускага", "ул.Машэрава", "пер.Туманность Андромеды"};
    //private static final Random RANDOM = new Random();


    public FileAdrsThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        synchronized (file) {
            while (true) {
                if (file.exists()) {
                    file.delete();
                }
                try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
                    long endTime = System.currentTimeMillis() + 1000;
                    while (System.currentTimeMillis() < endTime) {
                        int random = RandomUtil.getRandom(adr.length);
                        int min = 1;
                        int max = 10;
                        String strAdr = adr[random] + ", " + RandomUtil.getRandom(min, max);
                        fileWriter.append(strAdr);
                        fileWriter.newLine();
                    }
                    fileWriter.close();
                    file.notifyAll(); // оповещаем наших  потребителей FileVariableThread,
                    // что мы освободили объект после добавления в него элемента
                    // и с ним можно работать из других потоков
                    file.wait(100L); // ожидаем 100 милисекунд
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
