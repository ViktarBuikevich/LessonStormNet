package Lessons.L25_Lambda20221004.zaurTregulov_Lambda;
/* � ���������� I ��������� ����� abc(),
�� �� ������������� ������� �� �� �����,
��� ������ �������� ���� �����.
��� ������������ ��������������� ��
������ ������ ������������ ������ def(I i)
������� � �������� ��������� ��������� ������ ���������� I
������ �������� ��������� ������ ���������� �� ������ ������.

 */
public class Test2 {
    static void def(I i){
        System.out.println(i.abc("privet"));
    }

    public static void main(String[] args) {
        def((String str)->{return str.length();});
    }
}
interface I{
    int abc(String s);

}
