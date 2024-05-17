public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("hello")
            return;
        }
        String imagePath = args[0];
        new NonogramFrame(imagePath);
    }
}