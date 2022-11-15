package Lessons.L25_Lambda20221004.DZ_Lambda;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @see https://stepic.org/lesson/Функциональные-интерфейсы-12777/step/8?unit=3125
 */
public class Main {

    /**
     * @see http://stackoverflow.com/a/33284366/2289640
     *
     * @param condition
     * @param ifTrue
     * @param ifFalse
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        String strNew = "Hello world!";
        Consumer<String> c = str -> System.out.println(strNew+str);
        c.accept(" Аbar-joba Genocwally");

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength);
    }

}
