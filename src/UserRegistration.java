public class UserRegistration {
    // Метод для проверки данных пользователя
    public static void checkUserData(String userData) throws IllegalArgumentException {
        String[] userDataArr = userData.split(" ");
        if (userDataArr.length != 6) {
            throw new IllegalArgumentException("Неверное количество данных. Введите ФИО, дату рождения, номер телефона и пол через пробел");
        }
        String namePattern = "[A-Za-zА-Яа-я]+";
        String datePattern = "\\d{2}\\.\\d{2}\\.\\d{4}";
        String phonePattern = "\\d{11}";
        String genderPattern = "[fm]";

        if (!userDataArr[0].matches(namePattern) || !userDataArr[1].matches(namePattern) || !userDataArr[2].matches(namePattern)) {
            throw new IllegalArgumentException("Неверный формат ФИО: латинские(A-Z, a-z) или не все поля заполнены!");
        }
        if (!userDataArr[3].matches(datePattern)) {
            throw new IllegalArgumentException("Неверный формат даты рождения (dd.mm.yyyy)");
        }
        if (!userDataArr[4].matches(phonePattern)) {
            throw new IllegalArgumentException("Неверный формат номера телефона (11) ***********");
        }

        if (!userDataArr[5].matches(genderPattern)) {
            throw new IllegalArgumentException("Неверный формат пола (f or m)");
        }

    }
}
