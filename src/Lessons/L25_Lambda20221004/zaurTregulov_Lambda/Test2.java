package Lessons.L25_Lambda20221004.zaurTregulov_Lambda;
/* В интерфнйсе I определен метод abc(),
но до определенного момента мы не знаем,
как должен работать этот метод.
Это определяется непосредственно на
момент вызова статического метода def(I i)
который в качестве параметра принимает объект интерфейса I
лямбда выражние реализует логику интерфнйса на момент вызова.

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
