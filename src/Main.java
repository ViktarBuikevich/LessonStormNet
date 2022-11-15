import FromExamclouds.Box6;
import FromExamclouds.HeavyBox1;

public class Main {
    public static void main(String[] args) {

        Box6 b1 = new Box6(1, "b1");
        Box6 b2 = new Box6(2, "b2");
        Box6 b3 = new Box6(3, "b3");
        Box6 b4 = new Box6(4, "b4");
        Box6 b5 = new Box6(5, "b5");

        Box6[] ba= new Box6[]{b1, b2, b3};
        printArray(ba, "boxArray");
        HeavyBox1 hb1 = new HeavyBox1(1, "hb1",10);
        HeavyBox1 hb2 = new HeavyBox1(2, "hb2",11);
        HeavyBox1 hb3 = new HeavyBox1(3, "hb3",12);
        HeavyBox1 hb4 = new HeavyBox1(4, "hb4",13);
        HeavyBox1[] hba = new HeavyBox1[]{hb1,hb2,hb3,hb4};
        printArray(hba, "boxArray");
        System.out.println("_____________________________________");
        rightConversion(ba, hba);
        wrongConversion(ba, hba);
    }

    private static void rightConversion(Box6[] boxArray, HeavyBox1[] heavyBoxArray) {

        boxArray = heavyBoxArray;
        printArray(boxArray, "boxArray");
//        System.out.println(boxArray.toString());
        System.out.println("rightConversion - it is OK!");
    }

    private static void wrongConversion(Box6[] boxArray, HeavyBox1[] heavyBoxArray) {


        //ошибка времени выполнения
        heavyBoxArray = (HeavyBox1[]) boxArray;
        printArray(heavyBoxArray,"heavyBoxArray");
        //System.out.println(heavyBoxArray.toString());
        System.out.println("wrongConversion - it is OK!");
    }
    public static <T> void printArray(T[] arr, String title) {
        System.out.print(title+" [ ");
        for (T el:
             arr) {
            System.out.print(el.toString()+",");
        }
        System.out.println(" ]");
    }
}
