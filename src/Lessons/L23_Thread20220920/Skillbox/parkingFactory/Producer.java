package Lessons.L23_Thread20220920.Skillbox.parkingFactory;

public class Producer extends Thread{
    private Parking parking;

    public Producer(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        super.run();
        int countProd =1100;
        while (countProd>0){
            int countTo=(int)(1+Math.random()*10);
            parking.in(countTo);
            countProd=countProd - countTo;
        }

//
//        for (int i = 0; i < 1000; i++) {
//            int countTo=(int)(1+Math.random()*10);
//                parking.in(countTo);
//        }
    }
}
