package EX6_Threads_Q2;

public class Exchange<E> {
	private E get1 = null, get2 = null;

	public synchronized E give1(E e) {
		get1 = e;
			while (get2 == null)
				justWait();
		notify();
		return get2;
	}

	public synchronized E give2(E e) {
		get2 = e;
		while (get1 == null)
				justWait();
		notify();
		return get1;
	}

	private void justWait() {
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
