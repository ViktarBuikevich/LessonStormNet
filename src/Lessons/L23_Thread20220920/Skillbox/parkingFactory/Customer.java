package Lessons.L23_Thread20220920.Skillbox.parkingFactory;

public class Customer extends Thread{
    private Parking parking;

    public Customer(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
//        super.run();
        int countCust =1000;
        while (countCust>0){
            int countFrom=(int)(1+Math.random()*10);
            parking.out(countFrom);
            countCust=countCust - countFrom;
        }
//        for (int i = 0; i < 1000; i++) {
//            int countFrom=(int)(1+Math.random()*10);
//            parking.out(countFrom);
//        }
    }
}
