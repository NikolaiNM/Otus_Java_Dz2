package animals.pets;

import animals.Animal;

public class Cat extends Animal {
    // конструктор
    public Cat(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    // переопределяем метод
    @Override
    public void say() {
        System.out.println("Мяу");
    }
}
