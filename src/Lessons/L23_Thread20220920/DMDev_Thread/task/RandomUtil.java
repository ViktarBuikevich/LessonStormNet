package Lessons.L23_Thread20220920.DMDev_Thread.task;

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

}
