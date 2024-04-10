import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаем объект Scanner для считывания данных с консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел:\t Фамилия Имя Отчество,\t дата_рождения(dd.mm.yyyy),\t номер_телефона(11)(***********),\t пол (f or m).");
        // Считываем данные с консоли
        String input = scanner.nextLine();
        String[] parts;
        try {
            // Разделяем введенные данные на составляющие
            parts = input.split("\s+");
            // Проверяем количество данных
            UserRegistration.checkUserData(input);

            // Извлекаем данные о человеке из введенных данных
            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];
            String birthDate = parts[3];
            long phoneNumber = Long.parseLong(parts[4]);
            char gender = parts[5].charAt(0);

            // Создаем объект Person
            Person person = new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            // Выводим данные о человеке
            System.out.println("Данные введены корректно:");
            System.out.println("ФИО: " + person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName());
            System.out.println("Дата рождения: " + person.getBirthDate());
            System.out.println("Номер телефона: " + person.getPhoneNumber());
            System.out.println("Пол: " + person.getGender());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;

        } finally {
            scanner.close();
        }

        String surname = parts[0];
        String data = input;
        FileWriter writer = new FileWriter(surname + ".txt", true);

        try  {
            writer.write(data + System.lineSeparator());
            System.out.println("Данные успешно записаны в файл " + surname + ".txt");

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();

        } finally {
            writer.close();
        }

    }


}