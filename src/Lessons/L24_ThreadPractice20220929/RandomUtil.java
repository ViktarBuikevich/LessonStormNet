package Lessons.L24_ThreadPractice20220929;

import java.util.Random;

final class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final  int DEFAULT_BOUND =10;

    private RandomUtil() {
    }
    public static int getRandom(){
        return RANDOM.nextInt(DEFAULT_BOUND);
    }
    public static int getRandom(int bound){
        return RANDOM.nextInt(bound);
    }
    public static int getRandom(int min, int max){
        max =max - min + 1; // правая граница включительно
        return RANDOM.nextInt(max) + min ;
    }
//
//    public static int rnd(int min, int max)
//    {
//        max =max - min + 1;
//        return (int) (Math.random() * ++max) + min;
//    }
}
