package Semaphore;

public interface Lock {
	public void requestCS(int i);
	public void releaseCS(int i);
}
