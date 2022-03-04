package ru.job4j.ex;

/**
 * 0.5. Иерархия исключений и множественный catch.
 * Throwable - базовый класс для всех нестандартных ситуаций при работе вашего приложения.
 * Error - ошибки связанные с работой виртуальной машины. Такие как: выход за границы памяти,
 * использование одинаковых библиотек с разными версиями.
 * Exception - ошибки, которые связаны с работой самой программы.
 * Их можно разделить на два типа: проверяемые (checked) и непроверяемые (unchecked) исключения (RuntimeException).
 * Конструкция try-catch может содержать множественный блок catch.
 * Это позволяет для конкретного прерывания произвести свою обработку.
 */

public class UserStore {
    /** Если пользователя не нашли в списке, то кинуть исключение UserNotFoundException. */
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                return users[i];
            }
        }
        throw new UserNotFoundException("Login could not be find");
    }
    /** Если пользователь не валидный или если имя пользователя состоит из менее трех символов, то кинуть исключение UserInvalidException. */
    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("User name invalid");
        }
        return true;
    }

    /** Использовать блок try-catch, так как исключения, которые могут возникнуть в процессе выполнения этого метода являются handle exception
     * первый должен обрабатываться самый нижний класс по иерархии
     * catch - этот блок отлавливает любые нестандартные ситуации в нашей программе (нежелательный)
     */
    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User newFind = findUser(users, "Petr Arsentev");
            if (newFind != null) {
                validate(newFind);
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
