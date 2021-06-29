package BWinter2020;

public class PrintDiff implements Observer<Integer>{

	@Override
	public void inform(Integer oldVal, Integer newVal) {
		System.out.println(newVal - oldVal);
	}

}
