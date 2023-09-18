import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Automat automat = new Automat();
        while (true){
            showMenu();
            int choice = 0;
            try {
                choice = sc.nextInt();
            }catch (Exception e){
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1 -> automat.addInList(getAToy(sc));
                case 2 -> System.out.println("Вы получили игрушку "+automat.giveOutAToy());
                case 3 -> automat.viewQueue();
                case 4 -> {
                    sc.close();
                    return;
                }
            }
        }

    }

    public static void showMenu() {
        System.out.println("Выберите пункт меню:\n"+
                "1 - Добавить игрушку\n"+
                "2 - Выдать игрушку\n"+
                "3 - Посмотреть очередь\n"+
                "4 - Выход");
    }

    public static Toy getAToy(Scanner in){
        try {
            in.nextLine();
            System.out.print("Название: ");
            String title = in.nextLine();
            System.out.print("Количество: ");
            int count = in.nextInt();
            System.out.print("Вес: ");
            double weight = in.nextDouble();

            return new Toy(title,count,weight);
        } catch (Exception e){
            System.out.println("Ошибка ввода данных! Повторите попытку.");
            return getAToy(in);
        }
    }
}