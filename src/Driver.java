
public class Driver {
    public static void main(String[] s) {
        Channel channel = new Channel(5, 5);
        for (int i = 0; i < 100; i++) {
            channel.advanceTime();
            System.out.print(channel.printChannel());
            System.out.println(i);
        }
    }
}
