package animals;

public class Animal {

    // поля свойства
    private String name;
    private int age;
    private int weight;
    private String color;

    // конструктор
    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /* методы */
    // говорить
    public void say() {
        System.out.println("Я говорю");
    }

    // ходить
    public void go() {
        System.out.println("Я иду");
    }

    // пить
    public void drink() {
        System.out.println("Я пью");
    }

    // есть
    public void eat() {
        System.out.println("Я ем");
    }

    // метод приветМалыш
    @Override
    public String toString() {
        return "Привет! меня зовут " + name + ", мне " + age + " " + correctAgeStr(age) + ", я вешу - " + weight + " кг, мой цвет - " + color;
    }

    private String correctAgeStr(int age) {
        if (age ==  1) {
            return "год";
        }
        else if (age >= 2 && age <= 4) {
            return "года";
        }
        else {
            return "лет";
        }
    }
}
