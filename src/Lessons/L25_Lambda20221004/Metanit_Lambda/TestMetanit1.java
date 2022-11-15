package Lessons.L25_Lambda20221004.Metanit_Lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

// функциональный интерфейс
@FunctionalInterface
interface Expression{
    boolean isEqual(int n);
}
// класс, в котором определены методы
class ExpressionHelper{
    static boolean isEven(int n){
        return n%2 == 0;
    }

    static boolean isPositive(int n){
        return n > 0;
    }
}
public class TestMetanit1 {

    public static void main(String[] args) {
        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println("Сумма четных = "+sum(nums, ExpressionHelper::isEven));

        Expression expr = ExpressionHelper::isPositive;
        System.out.println("Сумма положительных = "+sum(nums, expr));

        Expression exprCompare = nn->ExpressionHelper.isEven(nn)&&ExpressionHelper.isPositive(nn);
        System.out.println("Сумма четных, положительных = " + sum(nums, exprCompare));


        ///ExsamClouds
        Predicate<Integer> prd = n->n>0;
        Integer i = -10;
        prd.test(i+50);
        System.out.println("prd.test(i) = "+prd.test(i));
        System.out.println("prd.test(i+11) = "+prd.test(i+11));

        ////Consumer
        String hello = "HeLlO";
        Consumer<String> print = str -> System.out.println(str);
        print.accept(hello);
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept(hello);
        Consumer<String> printLowerCase = str -> System.out.println(str.toLowerCase());
        print.andThen(printUpperCase).andThen(printLowerCase).accept("Hello World");

        ////Function
        Function<String, String> f1 = s -> s + "1";
        Function<String, String> f2 = s -> s + "2";
        Function<String, String> f3 = s -> s + "3";
        Function<String, String> f4 = s -> s + "4";
        System.out.println(f1.andThen(f2).compose(f3).compose(f4).apply("Compose"));    // Compose4312
        System.out.println(f1.andThen(f2).andThen(f3).apply("AndThen"));                // AndThen123

        //Статический метод identity() интерф. Function
        Function<String, String> f5 = Function.identity();
        System.out.println(f5.apply("Some Value"));                                     // Some Value

        //Напишите лямбда выражение, которое использует функциональный интерфейс Function для преобразования объекта Exam в String:
        Function<Exam, String> f6 = exam -> exam.toString();
        Exam exam= new Exam("Name1", "0.1a");
        System.out.println(f6.apply(exam)); //Exam{name='Name1', version='0.1a'}

        Function<Integer, String> f7 = integer -> {
            String res = "Ноль";
            if (integer > 0) {
                res = "positive";
            } else if (integer < 0) {
                res = "negative";
            }
            return res;
        };
        System.out.println(f7.apply(-1));
        System.out.println(f7.apply(1));
        System.out.println(f7.apply(0));

        /// UnaryOperator наследует Function
        /// используется если Если аргумент и возвращаемое значение одного типа.
        UnaryOperator<String> uo = String::toUpperCase; // преобразуем строку к верхнему регистру
        System.out.println(uo.apply("Ocpjp 8"));

        /// Methods Referens -- ссылка на метод
        Function<String, Boolean> function = Boolean::valueOf;
        System.out.println(function.apply("TRUE"));
    }

    private static int sum (int[] numbers, Expression func)
    {
        int result = 0;
        for(int i : numbers)
        {
            if (func.isEqual(i)){
                System.out.println("    func.isEqual(i) "+i);
                result += i;}
        }
        return result;
    }
}
class Exam {
    private String name;
    private String version;

    public Exam(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public String getVersion() {
        return version;
    }
}