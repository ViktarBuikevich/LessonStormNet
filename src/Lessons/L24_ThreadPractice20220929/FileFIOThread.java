package Lessons.L24_ThreadPractice20220929;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileFIOThread implements Runnable {
    private File file;
    private String[] fam = {"��������", "��������", "������", "�����", "�����", "���������", "����������", "���", "������", "������", "������"};
    private String[] im = {"������", "�����", "����", "���", "������", "�������", "����", "���������", "���������", "�����", "����", "�������", "���������", "�������"};
    private String[] ot = {"����������", "��������", "����������", "����������", "����������", "������������", "��������", "��������", "�������������", "����������"};

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
                    file.notifyAll(); // ��������� ����� ������������ FileVariableThread,
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
