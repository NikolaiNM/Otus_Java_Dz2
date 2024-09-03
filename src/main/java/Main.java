import animals.Animal;
import data.AnimalFactory;
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

        System.out.print("Привет! Вводи команду Add / List / Exit : ");       // Приветствие

        // цикл пока не выберем exit
        while (true) {

            String input = scanner.nextLine();                  // Запись в input из терминала
            Command command = Command.fromString(input);        // Объявление переменной command для menu.Command(enum)

            // Проверка если ввели пустую команду
            if (command == null) {                               // Проверяет чтобы в команде не был нулл
                System.out.print("Неверная команда, попробуйте еще : ");
                continue;                                       // необходимо для продолжения если в command null
            }

            // переключатель проверка содержимого переменной command
            switch (command) {
                case ADD:                                   //если ввели ADD
                    String type;
                    boolean rightType = false;
                    do {
                        System.out.print("Какое животное вы хотите добавить cat / dog / duck : ");
                        type = scanner.nextLine().trim().toUpperCase();
                        if ("CAT".equals(type) || "DOG".equals(type) || "DUCK".equals(type)) {
                            rightType = true;
                        } else {
                            System.out.println("Неизвестное животное, попробуйте еще раз");
                        }
                    } while (!rightType);

                    System.out.println("Как зовут животное?");
                    String name = scanner.nextLine().trim();

                    int age = validator.getValidInput("Сколько ему лет?", "Возраст должен", 1, 20);

                    int weight = validator.getValidInput("Сколько оно весит?", "Вес должен", 1, 100);

                    System.out.println("Какого цвета животное?");
                    String color = scanner.nextLine().trim().toUpperCase();

                    try {
                        Animal newAnimal = AnimalFactory.createAnimal(type, name, age, weight, color);
                        animals.add(newAnimal);
                        newAnimal.say();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.print("Вводи команду Add / List / Exit : ");
                    break;

                case LIST:
                    //если ввели LIST
                    if (animals.isEmpty()) {
                        System.out.print("Список пуст, добавьте животное Add / Exit : ");
                    } else {
                        for (Animal animal : animals) {
                            System.out.println(animal.toString());
                        }
                        System.out.print("Вводи команду Add / List / Exit : ");
                    }
                    break;

                case EXIT:                                  //если ввели EXIT
                    System.out.println("Выход");
                    // закрыть сканер
                    scanner.close();
                    System.exit(0);                 // правильный выход
                default:                                  // любое другое значение
                    System.out.println("Не верная команда");
            }
        }
    }
}
