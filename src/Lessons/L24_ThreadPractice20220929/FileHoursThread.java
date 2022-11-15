package Lessons.L24_ThreadPractice20220929;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHoursThread implements Runnable {
       // private static final Random RANDOM = new Random();
    private File file;

    public FileHoursThread(File file) {
        this.file = file;
    }

    //public String CreateFileFIO(int index) {
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
                        int random = RandomUtil.getRandom(24);
                        //String hours = String.valueOf(System.out.format("%02d\n", random)); // непонятно но работает
                        String hours = "00" + random;
                        fileWriter.append(hours.substring(hours.length() - 2));
                        fileWriter.newLine();
                    }
                    fileWriter.close();
                    file.notifyAll(); // оповещаем наших потребителей FileVariableThread,
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

