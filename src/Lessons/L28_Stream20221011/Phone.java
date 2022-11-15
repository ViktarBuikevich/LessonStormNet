package Lessons.L28_Stream20221011;
/*
1/  Класс телефона содержит само значение и тип (стационарный или мобильный).
 */
public class Phone {
    private String namber;
    private TypePhone typePhone;

    public Phone(String namber, TypePhone typePhone) {
        this.namber = namber;
        this.typePhone = typePhone;
    }

    public String getNamber() {
        return namber;
    }

    public TypePhone getTypePhone() {
        return typePhone;
    }

    public void setNamber(String namber) {
        this.namber = namber;
    }

    public void setTypePhone(TypePhone typePhone) {
        this.typePhone = typePhone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                typePhone +": " + namber + '}';
    }
}
