package Lessons.L24_ThreadPractice20220929;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAdrsThread implements Runnable {
    private  File file;
    private String[] adr = {"��.������ ������", "��.������������", "���.���������", "����.���������", "��.������ ���� ����", "��. ��� ������� ������������", "��.��������", "���.���������� ���������"};
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
                    file.notifyAll(); // ��������� �����  ������������ FileVariableThread,
                    // ��� �� ���������� ������ ����� ���������� � ���� ��������
                    // � � ��� ����� �������� �� ������ �������
                    file.wait(100L); // ������� 100 ����������
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
