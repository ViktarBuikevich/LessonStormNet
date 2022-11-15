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
        //����������� �������� ������� ifTrue, ���� �������� ��������, � �������� ifFalse �����.
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        /*
1/��� �������� condition � ��� ������� ifTrue � ifFalse. �������� ����� ternaryOperator,
������� �� ��� �������� ����� �������, ������������ �������� ������� ifTrue, ���� �������� ��������, � �������� ifFalse �����.
*/
        System.out.println("------------- DZ #1------------------");
        Predicate<Object> condition = (obj) -> Objects.isNull(obj);
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = (obj) -> obj.length();
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength);


/*
2/�������� ������ ���������, ������� ��������� �� ���� ������ ���� HeavyBox
� ������� �� ������� ��������� ���������� ���� � ����� n�. ����������� ���� � ����� n�
���������� �������������� ��������� Consumer � ����� �� ��������� andThen.
*/
        System.out.println("------------- DZ #2------------------");
        HeavyBox heavyBox = new HeavyBox("100 t");
        Consumer<HeavyBox> consumerOtgr = hb -> System.out.println("��������� ���� � ����� " + hb.getMsg());
        Consumer<HeavyBox> consumerOtpr = hb -> System.out.println("���������� ���� � ����� " + hb.getMsg());

        consumerOtgr.andThen(consumerOtpr).accept(heavyBox);

/*
3/�������� ������ ���������, ������� ���������� ��������� ����� �� 0 �� 10.
���������� �������������� ��������� Supplier.
*/
//        ��������� Supplier ������������ �����, ����� �� ���� �� ���������� ��������,
//    �� ���������� ������� ���������.
//
//	@FunctionalInterface
//	public interface Supplier<T> {
//	    T get();
//	}
//
//    �������������� ���������� ����������:
//
//	() -> T
        /* ������� �������� [min; max]
        max -= min;
        return (int) (Math.random() * ++max) + min;
        min=0, max=10 �������
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
4/ �������� ������ ���������, ������� ��������� �� ���� ����� � ���������� ��������
�������������� �����, �������������� ����� ���  ������. ���������� �������������� ��������� Function.
--------------------
��������� �������� � �������� ��������� ������ ���� � ���������� ������ ��������.
����� ������������ ��� �������������� ������ �������� � ������:

	@FunctionalInterface
	public interface Function<T, R> {
	    R apply(T t);
	}

�������������� ���������� ����������:

	T -> R
*/
        System.out.println("------------- DZ #4------------------");
        Function<Integer, String> octothorpe = integet -> {
            String str = "����";
            if ( integet > 0){
                str = "������������� �����";
            }else if ( integet <0){
                str = "������������� �����";
            }
            return str;
        };
        int i4= -10;
        System.out.println("number of: "+i4+" -- "+octothorpe.apply(i4));
    }

}
