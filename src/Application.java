import model.Kotik;

public class Application {
    public static void main(String[] args) {

        Kotik kotik1 = new Kotik(9001, "Meatball", 6, "Meow");
        Kotik kotik2 = new Kotik();

        kotik2.setKotik(9000, "Coffee", 5, "Nyaaa");
        kotik1.liveAnotherDay();

        System.out.println("\nName of the Kotik is " + kotik1.getName() + " and his weight is " + kotik1.getWeight() + " kg.\n");

        if (kotik1.getMeow().equalsIgnoreCase(kotik2.getMeow())) {
            System.out.println("Kotiks is speaking the same language.\n");
        } else {
            System.out.println("Kotiks languages are different.\n");
        }

        System.out.println("Amount of Kotiks created is " + Kotik.getCount() + ".");
    }
}
