package Animals;

public class Dog extends Animal {
    // конструктор
    public Dog(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    // переопределяем метод
    @Override
    public void say() {
        System.out.println("Гав");
    }
}
