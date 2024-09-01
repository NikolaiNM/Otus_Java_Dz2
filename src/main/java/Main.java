import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import menu.Command;
import utils.InputIntValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // создаем сканер
        Scanner scanner = new Scanner(System.in);

        InputIntValidator validator = new InputIntValidator(scanner);

        List<Animal> animals = new ArrayList<>(); // Создаем коллекцию - список Animals ArrayList

        // создаем переменную флаг - для выхода
        boolean exit = false;

        System.out.print("Привет! Вводи команду Add / List / Exit : ");       // Приветствие

        // цикл пока exit == false
        while (!exit) {

            String input = scanner.nextLine();                  // Запись в input из терминала
            Command command = Command.fromString(input);        // Обьясвление переменнной command для menu.Command(enum)

            // Проверка если ввели пустую команду
            if (command == null) {                               // Проверяет чтобы в команде не был нулл
                System.out.print("Неверная команда, попробуйте еще : ");
                continue;                                       // необходимо для продолжения если в command null
            }
            String type;
            boolean rightType = false;
            // переключатель проверка содержимого переменной command
            switch (command) {
                case ADD:                                   //если ввели ADD
                    do {
                        System.out.print("Какое животное вы хотите добавить cat / dog / duck : ");
                        type = scanner.nextLine().trim().toUpperCase();     // вводим тип животного, оттбрасываем пробелы и пишем в ВВЕРХНЕМ РЕГИСТРЕ
                        if ("CAT".equals(type) || "DOG".equals(type) || "DUCK".equals(type)) {
                            rightType = true;
                        } else {
                            System.out.println("Неизвестное животное, попробуйте еще раз");
                        }
                    } while (!rightType);


                    System.out.println("Как зовут животное?");
                    String name = scanner.nextLine().trim();      // вводим имя животного, отбрасываем пробелы

                    int age = validator.getValidInput("Сколько ему лет?", "Возраст должен",1, 20);
                    int weight = validator.getValidInput("Сколько оно весит?","Вес должен", 1, 100);

                    System.out.println("Какого цвета животное?");
                    String color = scanner.nextLine().trim().toUpperCase();     // вводим цвет животного, оттбрасываем пробелы


                    Animal newAnimal;

                    switch (type) {
                        case "CAT":
                            newAnimal = new Cat(name, age, weight, color);
                            break;
                        case "DOG":
                            newAnimal = new Dog(name, age, weight, color);
                            break;
                        case "DUCK":
                            newAnimal = new Duck(name, age, weight, color);
                            break;
                        default:
                            System.out.println("Что за зверь?");
                            continue;
                    }

                    animals.add(newAnimal);
                    newAnimal.say();
                    System.out.print("Вводи команду Add / List / Exit : ");
                    break;

                case LIST:
                    //если ввели LIST
                    if (animals.isEmpty()) {
                        System.out.print("Список пуст, добавьте животное Add / Exit : ");
                    } else {
                        for (int i = 0; i < animals.size(); i++) {
                            System.out.println(animals.get(i).toString());
                        }
                        System.out.print("Вводи команду Add / List / Exit : ");
                    }
                    break;

                case EXIT:                                  //если ввели EXIT
                    System.out.println("Выход");
                    System.exit(0);                 // правильный выход
                default:                                  // любое другое значение
                    System.out.println("Не верная комманда");
            }
        }

        // закрыть сканер
        scanner.close();
    }
}
