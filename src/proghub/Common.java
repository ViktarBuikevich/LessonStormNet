package proghub;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Common {

    static int Common(List<Integer> arr) {
        // массив int[] arr в поток: Arrays.stream(arr).
        // великолепный код тут
        //ver. 1
        Map<Integer, Integer> result = arr.stream().distinct().collect(Collectors.toMap(Function.identity(), token -> Collections.frequency(arr, token)));
        //ver. 2
        Map<Object, Long> counts = arr.stream()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
                .stream()
                .collect(groupingBy(Function.identity(), counting()));
        return  0;
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_FILE")));
        Scanner scanner = new Scanner(new FileReader(System.getenv("INPUT_FILE")));

        String a = scanner.nextLine();

        int result = Common(inputToArray(a));

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