package WorkerThread;

public class Main {

	public static void main(String[] args) {
		System.out.println("start");
		Channel channel = new Channel(5);
		channel.startWoekers();
		new ClientThread("Alice",channel).start();
		new ClientThread("Bob",channel).start();
		new ClientThread("Chris",channel).start();
	}

}
