package BWinter2020;

public class ObservableInteger {
	private int val = 0;
	private Observer<Integer> obs = null;
	
	public void set(int val) {
		if(obs != null)
			obs.inform(this.val, val);
		this.val = val;
	}
	
	public void setObserver(Observer<Integer> obs) {
		this.obs = obs;
	}
	
	public static void main(String[] args) {
		ObservableInteger i = new ObservableInteger();
		i.setObserver(new PrintDiff());
		i.set(4);
		i.set(5);
		i.set(2);
	}
	
}
