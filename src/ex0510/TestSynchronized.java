package ex0510;

public class TestSynchronized {
	private final static Object lock=new Object();
	public void test() {
		synchronized (lock) {
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			}
		}
	}
	public static void main(String[] args) {
		final TestSynchronized testSynchronized = new TestSynchronized();
		final TestSynchronized testSynchronized1 = new TestSynchronized();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				testSynchronized.test();
			}
		},"A");
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				testSynchronized1.test();
			}
		},"B");
		thread1.start();
		thread2.start();
		//System.out.println("ÄãºÃ");
	}
}
