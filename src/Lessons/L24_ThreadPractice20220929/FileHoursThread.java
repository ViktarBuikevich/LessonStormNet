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
                        int randomH = RandomUtil.getRandom(24);
                        int randomM = RandomUtil.getRandom(60);
                        //String hours = String.valueOf(System.out.format("%02d\n", random)); // непонятно но работает
                        String hh = "00" + randomH;
                        String mm = "00" + randomM;
                        String time= hh.substring(hh.length() - 2)+":"+mm.substring(mm.length() - 2);
                        fileWriter.append(time);
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

