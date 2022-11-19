package Lessons.L24_ThreadPractice20220929;

import java.io.Serializable;

public class FioAdrHour implements Serializable {
    private String fio;
    private String adr;
    private String hour;

    public FioAdrHour() {
    }

    public FioAdrHour(String fio, String adr, String hour) {
        this.fio = fio;
        this.adr = adr;
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FioAdrHour)) return false;

        FioAdrHour that = (FioAdrHour) o;

        //if (Hour != that.Hour) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;
        return adr != null ? adr.equals(that.adr) : that.adr == null;
    }

    public String getFio() {
        return fio;
    }

    public String getAdr() {
        return adr;
    }

    public String getHour() {
        return hour;
    }
//    @Override
//    public int hashCode() {
//        int result = fio != null ? fio.hashCode() : 0;
//        result = 31 * result + (adr != null ? adr.hashCode() : 0);
//        result = 31 * result + hour;
//        return result;
//    }
}
