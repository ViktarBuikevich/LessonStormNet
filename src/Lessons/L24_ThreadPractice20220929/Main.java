package Lessons.L24_ThreadPractice20220929;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
1/ 3 ������ ������������ ���������� 3 �����.
������ - ���������� ��������� ���,
������ - ������,
������ - �����(� 24������� �������),
� ������� ����� ������� ��������, �� ��� ���, ���� ����� �� 2 ������ �� �������� ���� ������.
2/ ��������� ����� �� ��������� ������ ������� �� ������ 1,
������� ����� ���� (������ ��� ��� ����������� - ������� ����� ����, �������� ����������),
� ���� �������� ��� ��������� �������� �� 3 ������, ��������������� ������ � ������ 1.
3/ ��� ���� �����, ��������� ����� ����� �� ������� ����������. ���� ��������� ������� - ������� ��
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
