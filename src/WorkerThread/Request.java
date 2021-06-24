package WorkerThread;
import java.util.Random;
public class Request {
	private final String NAME;
	private final int NUMBERR;
	private static final Random RANDOM = new Random();
	public Request(String name,int number) {
		this.NAME = name;
		this.NUMBERR = number;
	}
	public void execute() {
		System.out.println(Thread.currentThread().getName() + "executes " + this);
		try {
			Thread.sleep(RANDOM.nextInt(1000));
		}catch(InterruptedException e) {
			
		}
	}
	public String toString() {
		return "[Request from " + this.NAME + this.NUMBERR + "]";
	}
}
