package Semaphore;

	import java.util.Random;
	public class RunBakery extends Thread {
	    int myId;
	    Lock lock;
	    Random r = new Random();
	    public RunBakery(int id, Lock lock) {
	        myId = id;
	        this.lock = lock;
	    }
	    void nonCriticalSection() {
	        System.out.println(myId + " is not in CS");
	        Util.mySleep(r.nextInt(1000));
	    }
	    void CriticalSection() {
	        System.out.println(myId + " is in CS *****");
	        // critical section code
	        Util.mySleep(r.nextInt(1000));
	    }
	    public void run() {
	        while (true) {
	            lock.requestCS(myId);
	            CriticalSection();
	            lock.releaseCS(myId);
	            nonCriticalSection();
	        }
	    }
	    public static void main(String[] args) throws Exception {
	    	RunBakery t[];
	        int N = 5;
	        t = new RunBakery[N];
	        Lock lock = new Bekary(N);//or any other mutex algorithm
	        for (int i = 0; i < N; i++) {
	            t[i] = new RunBakery(i, lock);
	            t[i].start();
	        }
	    }
}
