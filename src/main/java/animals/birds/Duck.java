package animals.birds;

import animals.Animal;

public class Duck extends Animal implements Flying {
    // конструктор
    public Duck(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    // реализуем все методы интерфейса
    @Override
    public void fly() {
        System.out.println("Я лечу");
    }

    // переопределяем метод
    @Override
    public void say() {
        System.out.println("Кря");
    }


}
