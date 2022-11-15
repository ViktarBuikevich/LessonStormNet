package proghub;
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.stream.Collectors;

public class Product {

    static int Product(List<Integer> arr) {
        // великолепный код тут
        //Integer:compare
        java.util.Collections.sort(arr);
        int max1=arr.get(0)*arr.get(1);
        int max= arr.get(arr.size() - 1) *arr.get(arr.size()-2);
        return max>=max1?max:max1;
    }

    public static void main(String[] args) throws IOException {
        String path=System.getenv("Path");
        String fName=System.getenv("OUTPUT_FILE");
        FileWriter fw = new FileWriter(fName);
        BufferedWriter outputWriter = new BufferedWriter(fw);
        Scanner scanner = new Scanner(new FileReader(System.getenv("INPUT_FILE")));

        String a = scanner.nextLine();

        int result = Product(inputToArray(a));
        System.out.println("Array: "+a);
        System.out.println("result: "+result);
        outputWriter.write(String.valueOf(result));

        outputWriter.close();
        scanner.close();
    }

    private static List<Integer> inputToArray(String input) {
        String[] items = input.split(" ");
        List<Integer> result = new ArrayList<Integer>();

        if(input.isEmpty()) {
            return result;
        }

        for(int i = 0; i < items.length; i++) {
            result.add(Integer.valueOf(items[i]));
        }

        return result;
    }
}