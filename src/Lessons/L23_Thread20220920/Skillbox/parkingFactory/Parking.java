package Lessons.L23_Thread20220920.Skillbox.parkingFactory;

public class Parking {
    private int size= 500;
    private int carCount=0;
    public synchronized void in(int countTo){
        if (getFreeParkingSpaces()<countTo) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carCount=carCount+countTo;
        System.out.print("++ Добавили на парковку, в количестве: "+countTo);
        System.out.println(".\t Свободных мест: "+(getFreeParkingSpaces()));
        notify();
    }
    public synchronized void out(int countFrom){
        if (carCount<countFrom) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carCount=carCount-countFrom;
        System.out.print("-- Убрали с парковки в количестве: "+countFrom);
        System.out.println("! \t Свободных мест: "+(getFreeParkingSpaces()));
        notify();
    }

    public int getSize() {
        return size;
    }

    public int getCarCount() {
        return carCount;
    }
    public int getFreeParkingSpaces() {
        return size-carCount;
    }

}
