public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please give an image path");
            return;
        }
        String imagePath = args[0];
        new Frame(imagePath);
    }
}