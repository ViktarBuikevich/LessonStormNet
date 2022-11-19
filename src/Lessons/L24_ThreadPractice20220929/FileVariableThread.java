package Lessons.L24_ThreadPractice20220929;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
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
2/ ��������� ����� �� ��������� ������ ������� �� ������ 1,
������� ����� ���� (������ ��� ��� ����������� - ������� ����� ����, �������� ����������),
� ���� �������� ��� ��������� �������� �� 3 ������, ��������������� ������ � ������ 1.
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
                            fileFIO.notifyAll();// �����������
                            List<String> listAdr = Files.readAllLines(fileAdr.toPath());
                            fileAdr.delete();
                            fileAdr.notifyAll();// �����������
                            List<String> listHours = Files.readAllLines(fileHours.toPath());
                            fileHours.delete();
                            fileHours.notifyAll();// �����������
                            //TODO ��������� ��������� �������� ������
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        //�������� � ����� ���� variable.txt ��������� ��������

                    }
                }
            }
        }
        //��������� � list ���� ���� �������


//        // ���������� readAllLines � ����������
//        try (BufferedReader reader = new BufferedReader(path, cs)) {
//            List<String> result = new ArrayList<>();
//            for (;;) {
//                String line = reader.readLine();
//                if (line == null)
//                    break;
//                result.add(line);
//            }
    }
    private boolean writeTopFileVariable (List<String> listFIO, List<String> listAdr, List<String> listHours, String fileName){
        //List<FioAdrHour> listFAH = new ArrayList<>();
        FioAdrHour fah = new FioAdrHour();
        for (String elFio:listFIO) {
            for (String elAdr:listAdr) {
                for (String elHour:listHours) {
                   fah=new FioAdrHour(elFio, elAdr, elFio);

                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
                    {
                      //  Person p = new Person("Sam", 33, 178, true);

                        oos.writeObject(fah);
                    }
                    catch(Exception ex){

                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
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
