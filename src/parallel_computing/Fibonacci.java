package paraller_computing;

public class Fibonacci extends Thread {
	int n;
	int result;
	public Fibonacci(int n)
	{
		this.n = n;
	}
	public void run() {
		if((n== 0) || (n==1))
		{
			result = 1;
		}
		else {
			Fibonacci f1 = new Fibonacci(n-1);
			Fibonacci f2 = new Fibonacci(n-2);
			f1.start();
			f2.start();
			try {
				f1.join();
				f2.join();
			}
			catch(InterruptedException e) {}
			result = f1.getResult() + f2.getResult();
		}
	}
	public int getResult() {
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f1 = new Fibonacci(9);
		f1.start();
		try {
			f1.join();
		}catch(InterruptedException e) {}
		System.out.println("Result is:" + f1.getResult()); //input result = 55.
	}
}
