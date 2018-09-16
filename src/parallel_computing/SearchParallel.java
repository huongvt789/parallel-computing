package parallel_computing;

import java.util.Scanner;

public class SearchParallel implements Runnable {
	private int startParagrap, endParagrap;
	private int item, position = -1;
	private int[] arrayA;

	public SearchParallel() {
	}

	public SearchParallel(int begin, int end, int itemSearch, int[] A) {
		this.startParagrap = begin;
		this.endParagrap = end;
		this.item = itemSearch;
		this.arrayA = A;
	}

	public void run() {
		for (int i = startParagrap; i <= endParagrap; i++)
			if (arrayA[i] == item) {
				System.out.println("Phan tu tim kiem co gia tri la  " + item + " co vi tri dau tien la: " + i);
				position = i;
				break;
			}
	}

	public int getPosition() {
		return position;
	}

	public static int parallelSearch(int x, int[] A, int numsThreads) {
		int sizeOfArray = A.length;
		int rangePos = sizeOfArray / numsThreads;
		for (int i = 0; i < numsThreads; i++) {
			Thread itemSearch;
			if (i == numsThreads - 1)
				itemSearch = new Thread(new SearchParallel(i * rangePos, sizeOfArray - 1, x, A));
			else
				itemSearch = new Thread(new SearchParallel(i * rangePos, i * rangePos + rangePos - 1, x, A));
			itemSearch.start();
		}
		return 0;
	}

	public static void main(String[] args) {
		int item, n, numsThreads, max = 100;
		int[] A = new int[max];
		Scanner scanIn = new Scanner(System.in);
		do {
			System.out.println("Nhap so luong phan tu cua mang: ");
			n = scanIn.nextInt();
		} while (n <= 0 || n > max - 1);
		System.out.println("Nhap cac phan tu cho mang:");
		for (int i = 1; i < n; i++) {
			System.out.print("A[" + i + "] = ");
			A[i] = scanIn.nextInt();
		}

		System.out.println("Hay nhap so luong luong:");
		numsThreads = scanIn.nextInt();

		System.out.println("Nhap phan tu tim kiem:");
		item = scanIn.nextInt();
		int i = 1;
		while ((i < n) && (A[i] != item)) {
			i++;
		}
		int result = parallelSearch(item, A, numsThreads);
		if (i > n - 1) {
			System.out.println("Trong mang khong co phan nao can tim.");
		} else {
			System.out.println(result);
		}
	}
}
