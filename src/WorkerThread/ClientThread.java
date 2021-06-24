package WorkerThread;

import java.util.Random;

public class ClientThread extends Thread{
	private final Channel CHANNEL;
	private static final Random RANDOM = new Random();

	public ClientThread(String name ,Channel channel) {
		super(name);
		this.CHANNEL =channel;
	}
	public void run() {
		try {
			for(int i =0 ; true;i++) {
				Request request = new Request(getName(), i);
				this.CHANNEL.putRequest(request);
				Thread.sleep(RANDOM.nextInt(1000));
			}
		}catch (InterruptedException e) {}
	}
}
