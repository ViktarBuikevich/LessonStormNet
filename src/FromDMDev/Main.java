package FromDMDev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s = "+7-777-654-12-34 reybvd 8-747-457-78-95 hcdjkgh bulbash77@gmail.com hjh 1797 gdtf1fvfgd2\tyeg\tviktar.buikevich@by.lactalis.com\n" +
                "+7-705-487-78-65\tfdytr +7-777-654-12-34\t vb@gstgfs.x342,8667n +3-75(29)7894787 +375(33)7894787 +375-29-8222328 asdq@mail.ru\n";
        Pattern p = Pattern.compile("(\\+7|8)-(705|777)-\\d{3}-\\d{2}-\\d\\d");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group()+" - "+m.start()+" - "+m.end());// Cannot resolve symbol "find"
        }
    }
}