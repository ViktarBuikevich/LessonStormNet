package Lessons.L25_Lambda20221004;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        //возвращаетю значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        /*
1/Дан предикат condition и две функции ifTrue и ifFalse. Напишите метод ternaryOperator,
который из них построит новую функцию, возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
*/
        System.out.println("------------- DZ #1------------------");
        Predicate<Object> condition = (obj) -> Objects.isNull(obj);
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = (obj) -> obj.length();
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength);


/*
2/Написать лямбда выражение, которое принимает на вход объект типа HeavyBox
и выводит на консоль сообщение “Отгрузили ящик с весом n”. “Отправляем ящик с весом n”
Используем функциональный интерфейс Consumer и метод по умолчанию andThen.
*/
        System.out.println("------------- DZ #2------------------");
        HeavyBox heavyBox = new HeavyBox("100 t");
        Consumer<HeavyBox> consumerOtgr = hb -> System.out.println("Отгрузили ящик с весом " + hb.getMsg());
        Consumer<HeavyBox> consumerOtpr = hb -> System.out.println("Отправляем ящик с весом " + hb.getMsg());

        consumerOtgr.andThen(consumerOtpr).accept(heavyBox);

/*
3/Написать лямбда выражение, которое возвращает случайное число от 0 до 10.
Используем функциональный интерфейс Supplier.
*/
//        Интерфейс Supplier используется тогда, когда на вход не передаются значения,
//    но необходимо вернуть результат.
//
//	@FunctionalInterface
//	public interface Supplier<T> {
//	    T get();
//	}
//
//    Функциональный дескриптор интерфейса:
//
//	() -> T
        /* Границы включаем [min; max]
        max -= min;
        return (int) (Math.random() * ++max) + min;
        min=0, max=10 получим
        return (int) (Math.random() * 11);
         */

        System.out.println("------------- DZ #3------------------");
        Supplier<Integer> rundom0_10 = () ->Integer.valueOf((int) (Math.random() * 11));
        System.out.print("rundom from 0 to 10: "+rundom0_10.get()+", ");
        for (int i = 0; i < 100; i++) {
            System.out.print(rundom0_10.get()+", ");
        }
        System.out.println(rundom0_10.get());

/*
4/ Написать лямбда выражение, которое принимает на вход число и возвращает значение
“Положительное число”, “Отрицательное число” или  “Ноль”. Используем функциональный интерфейс Function.
--------------------
Принимает значение в качестве аргумента одного типа и возвращает другое значение.
Часто используется для преобразования одного значения в другое:

	@FunctionalInterface
	public interface Function<T, R> {
	    R apply(T t);
	}

Функциональный дескриптор интерфейса:

	T -> R
*/
        System.out.println("------------- DZ #4------------------");
        Function<Integer, String> octothorpe = integet -> {
            String str = "Ноль";
            if ( integet > 0){
                str = "Положительное число";
            }else if ( integet <0){
                str = "Отрицательное число";
            }
            return str;
        };
        int i4= -10;
        System.out.println("number of: "+i4+" -- "+octothorpe.apply(i4));
    }

}
