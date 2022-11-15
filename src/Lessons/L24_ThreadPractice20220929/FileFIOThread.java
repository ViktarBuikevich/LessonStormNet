package Lessons.L24_ThreadPractice20220929;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileFIOThread implements Runnable {
    private File file;
    private String[] fam = {"Стремоус", "Асимович", "Прихач", "Люхта", "Новик", "Беленович", "Гаврильчик", "Пищ", "Куклик", "Янушко", "Иванов"};
    private String[] im = {"Степан", "Алина", "Адам", "Ева", "Виктор", "Николай", "Инга", "Валентина", "Степанида", "Игорь", "Олег", "Татьяна", "Александр", "Дмитрий"};
    private String[] ot = {"Степанович", "Адамович", "Евгеньевич", "Викторович", "Николаевич", "Валентинович", "Игоревич", "Олегович", "Александрович", "Дмитриевич"};

    private static final Random RANDOM = new Random();

    public FileFIOThread(File file) {
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
                        int randomF = RandomUtil.getRandom(fam.length);
                        int randomI = RandomUtil.getRandom(im.length);
                        int randomO = RandomUtil.getRandom(ot.length);
                        String fio = fam[randomF] + " " + im[randomI] + " " + ot[randomO];
                        fileWriter.append(fio);
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
