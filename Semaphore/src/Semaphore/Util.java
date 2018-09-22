package Semaphore;
import java.util.*;
public class Util {
	public static void sprintln(String s) {
		if(Symbols.debugFlag) {
			System.out.println(s);
			System.out.flush();
		
		}
	}
	public static void mySleep(int time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException e) {
			
		}
	}
	public static void myWait(Object obj) {
		sprintln("waiting");
		try {
			obj.wait();
		}catch(InterruptedException e) {}
	}
}
