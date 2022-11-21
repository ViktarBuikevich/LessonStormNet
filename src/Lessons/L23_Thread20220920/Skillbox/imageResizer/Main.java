package Lessons.L23_Thread20220920.Skillbox.imageResizer;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String srcFolder = "e:\\imageResizer\\src\\";
        String dscFolder = "e:\\imageResizer\\dst\\";
        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();
        Runtime runtime = Runtime.getRuntime();
        int nrOfProcessors = runtime.availableProcessors();
        System.out.println("Number of processors available to the Java Virtual Machine: " + nrOfProcessors);




    }
}
