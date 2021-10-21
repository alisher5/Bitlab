import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DBManager db = new DBManager();
        db.connect();

        while(true){

            System.out.println("[1] ADD CAR");
            System.out.println("[2] LIST CARS");
            System.out.println("[3] UPDATE CAR");
            System.out.println("[4] DELETE CAR");
            System.out.println("[0] EXIT");

            String choice = in.next();

            if(choice.equals("1")){

                System.out.println("Insert name: ");
                String name = in.next();
                System.out.println("Insert price: ");
                int price = in.nextInt();
                System.out.println("Insert engine volume: ");
                double engineVolume = in.nextDouble();

                //Именно поэтому мы и сделали Long id. Чтобы передавать в конструктор null.
                Cars car = new Cars(null, name, price, engineVolume);
                db.addCar(car);

            }else if(choice.equals("2")){

                ArrayList<Cars> cars = db.getAllCars();

                for (Cars c : cars) {
                    System.out.println(c);
                }

            }else if(choice.equals("3")){

                System.out.println("Insert id: ");
                Long id = in.nextLong();
                System.out.println("Insert name: ");
                String name = in.next();
                System.out.println("Insert price: ");
                int price = in.nextInt();
                System.out.println("Insert engine volume: ");
                double engineVolume = in.nextDouble();

                Cars car = new Cars(id, name, price, engineVolume);
                db.updateCar(car);

            }else if(choice.equals("4")){

                System.out.println("Insert id: ");
                Long id = in.nextLong();
                db.deleteCar(id);

            }else if(choice.equals("0")){
                System.exit(0);
            }
        }
    }
}




