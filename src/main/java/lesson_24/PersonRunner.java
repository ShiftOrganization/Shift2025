package lesson_24;

public class PersonRunner {
    public static void main(String[] args) {

        Person sveta = new Person();
        sveta.setName("Sveta");
        sveta.setLastName("Svetikova");
        sveta.setAge(20);
        sveta.setGender("Ж");
        sveta.setEmail("sveta@mail.com");

        Person vasya = new Person("Vasya", "Vasechkin", 35, "М", "vasya@mail.com");

        System.out.println(sveta);
        System.out.println(vasya);
    }
}