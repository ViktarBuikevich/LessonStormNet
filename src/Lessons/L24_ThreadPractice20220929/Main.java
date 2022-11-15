package Lessons.L24_ThreadPractice20220929;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
1/ 3 потока одновременно генерируют 3 файла.
Первый - генерирует случайные ФИО,
второй - адреса,
третье - время(в 24часовом формате),
в течении одной секунды работает, до тех пор, пока поток из 2 пункта не закончит свою работу.
2/ Отдельный поток по окончанию работы потоков из пункта 1,
создает новый файл (каждый раз как запускается - создать новый файл, сохранив предыдущие),
в файл записать все возможные вариации из 3 файлов, сгенерированных файлов в пункте 1.
3/ Еще один поток, проверяет новые файлы на наличие дубликатов. Если дубликаты найдены - удалить их
 */
public class Main {
    public static void main(String[] args) {
        String fileNameAdr = "adrs" + ".txt";
        File fileAdr = Path.of("resources", fileNameAdr).toFile();

        String fileNameFIO = "fio" + ".txt";
        File fileFIO = Path.of("resources", fileNameFIO).toFile();

        String fileNameHours = "hours" + ".txt";
        File fileHours = Path.of("resources", fileNameHours).toFile();

//        String fileNameHours = "hours" + ".txt";
//        File fileHours = Path.of("resources", fileNameHours).toFile();


        ExecutorService executor = Executors.newFixedThreadPool(3);
        Thread fioThread =new Thread(new FileFIOThread(fileFIO));
        Thread adrsThread =new Thread(new FileAdrsThread(fileAdr));
        Thread hoursThread =new Thread(new FileHoursThread(fileHours));

        executor.execute(fioThread);
        executor.execute(adrsThread);
        executor.execute(hoursThread);


        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
