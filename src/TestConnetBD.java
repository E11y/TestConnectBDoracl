import java.util.Scanner;

public class TestConnetBD {
    public static void main(String[] args) {
        IPAddressValidator v = new IPAddressValidator();
        String ip;
        do {
            System.out.println("Введите ip адрес сервера БД");
            ip = new Scanner(System.in).nextLine();
            if (v.validate(ip))
                break;
            else
                System.out.println("Введён некорректный адрес");
        }
        while (true);
        System.out.println("Введите порт сервера БД");
        int BdPort = new Scanner(System.in).nextInt();
        System.out.println("Введите имя БД");
        String BdName = new Scanner(System.in).nextLine();
        System.out.println("Введите пользователя БД ");
        String DbUser = new Scanner(System.in).nextLine();
        System.out.println("Введите пароль для БД");
        String DbPassword = new Scanner(System.in).nextLine();
        Ora dbConnect = new Ora();
        dbConnect.getDBConnection(ip, BdPort, BdName, DbUser, DbPassword);
    }
}
