package FromDMDev.serializableDmDev;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class SerializationDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "student.out");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))
    }

}
