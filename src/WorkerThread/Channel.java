package WorkerThread;

public class Channel {
	private static final int MAX_REQUEST = 100;
	private final Request[] REQUEST_QUEUE;
	private int tail;
	private int head;
	private int count;
	private final WorkerThread[] threadPool;
	public Channel(int threads) {
		this.REQUEST_QUEUE = new Request[MAX_REQUEST];
		this.tail = 0;
		this.head = 0;
		this.count = 0;
		threadPool = new WorkerThread[threads];
		for(int i = 0;i<threadPool.length;i++) {
			threadPool[i] = new WorkerThread("Worker-"+i,this);
		}
		System.out.println("Channel initialized!");
	}
	public void startWoekers() {
		for(WorkerThread thread: this.threadPool) {
			System.out.println(thread.getName() + " is starting!");
			thread.start();
		}
	}
	public Request takeRequest() {
		System.out.println("take request start!");
		while(count<=0) {
			try {
				wait();
			}catch(InterruptedException e) {
				
			}
		}
		Request request = REQUEST_QUEUE[head];
		head= (head+1)%REQUEST_QUEUE.length;
		count--;
		notifyAll();
		System.out.println("put request end successflly!");
		return request;
	}
	public synchronized void putRequest(Request request) {
		System.out.println("put request start!");
		while(this.count>=this.REQUEST_QUEUE.length) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		this.REQUEST_QUEUE[tail] = request;
		tail = (tail + 1)%this.REQUEST_QUEUE.length;
		count++;
		notifyAll();
		System.out.println("put request end successflly !");
	}
}
