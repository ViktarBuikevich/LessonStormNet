package Lessons.L28_Stream20221011.DZ2;
/*
2/ This exercise asks you to write a few lambda expressions and a function that returns a lambda expression as its value.
Suppose that a function interface ArrayProcessor is defined as

public interface ArrayProcessor {
    double apply( double[] array );
}

Write a class that defines four public static final variables of type ArrayProcessor that process an array in the following ways:
find the maximum value in the array,
find the minimum value in an array,
find the sum of the values in the array,
and find the average of the values in the array.
In each case, the value of the variable should be given by a lambda expression. The class should also define a function

public static ArrayProcessor counter( double value ) { ...

This function should return an ArrayProcessor that counts the number of times that value occurs in an array.
The return value should be given as a lambda expression.

The class should have a main() routine that tests your work.
The program that you write for this exercise will need access to the file ArrayProcessor.java, which defines the functional interface.
---------------------------------------------
� ���� ���������� ��� ������������ �������� ��������� ������-��������� � �������, ������� ���������� ������-��������� � �������� ��������.
�����������, ��� ��������� ������� ArrayProcessor ��������� ���
public interface ArrayProcessor {
    double apply( double[] array );
}
�������� �����, ������������ ������ ������������� static final ���������� ���� ArrayProcessor, ������� ������������ ������ ���������� ���������:
 ������� ������������ �������� � �������,
 ������� ����������� �������� � �������,
 ������� ����� �������� � �������
 � ����� ������� �������� � �������.
� ������ ������ �������� ���������� ������ ���� ������ ������-����������. ����� ����� ������ ���������� �������

public static ArrayProcessor counter( double value ) { ...

��� ������� ������ ���������� ArrayProcessor, ������� ������������, ������� ��� ��� �������� ����������� � �������.
������������ �������� ������ ���� ������ ��� ������-���������.

� ������ ������ ���� ��������� main(), ������� ��������� ���� ������.
���������, ������� �� �������� ��� ����� ����������, ����������� ������ � ����� ArrayProcessor.java, ������� ���������� �������������� ���������.

 */

/**
 * This class defines several public static member variables of
 * type ArrayProcessor that process arrays in various ways.  It
 * also defines a function that can create ArrayProcessors for
 * counting occurrences of values in an array.  (Note that this
 * program depends on interface ArrayProcessor.)
 */
public class LambdaTest {

    /**
     * �T� ������� ���������� ArrayProcessor, ������� ������������,
     * ������� ��� ������������ �������� ����������� � �������.
     * �������� value ��������� ��������, ������� ������ ���� ����������.
     */
    public static ArrayProcessor counter( double value ) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if ( array[i] == value )
                    count++;
            }
            return count;
        };
    }


    /**
     *  ��������� � ���������� ������������ �������� �������.
     * (������ ������ ����� ����� �� ����� 1.)
     */
    public static final ArrayProcessor maxer = array -> {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if ( array[i] > max)
                max = array[i];
        }
        return max;
    };


    /**
     *  ��������� � ���������� ������������ �������� �������.
     *  (������ ������ ����� ����� �� ����� 1.)
     */
    public static final ArrayProcessor miner = array -> {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if ( array[i] < min)
                min = array[i];
        }
        return min;
    };


    /**
     * ��������� � ���������� ����� �������� � �������.
     * (������ ������ ����� ����� �� ����� 1.)
     */
    public static final ArrayProcessor sumer = array -> {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    };


    /**
     * ��������� � ���������� ������� �������� � �������.
     * (������ ������ ����� ����� �� ����� 1.)
     */
    public static final ArrayProcessor averager =
            array -> sumer.apply(array) / array.length;



    //---------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        double[] firstList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] secondList = { 17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14 };

        System.out.println("Sum of first list (should be 55): "
                + sumer.apply(firstList) );
        System.out.println("Average of first list (should be 5.5): "
                + averager.apply(firstList) );
        System.out.println("Minimum of second list (should be -3.4): "
                + miner.apply(secondList) );
        System.out.println("Maximum of second list (should be 42.0): "
                + maxer.apply(secondList) );

        System.out.println();

        System.out.println("Count of 17.0 in second list (should be 3): "
                + counter(17.0).apply(secondList) );
        System.out.println("Count of 20.0 in second list (should be 0): "
                + counter(20.0).apply(secondList) );
        System.out.println("Count of 5.0 in first list (should be 1): "
                + counter(5.0).apply(firstList) );
    }
} // end class LambdaTest
