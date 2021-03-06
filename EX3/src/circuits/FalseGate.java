package circuits;

public class FalseGate extends Gate {
	private static final String FALSE_GATE = "F";
	private static FalseGate instance = null;
	
	private FalseGate() {
		super(new Gate[] { FalseGate.instance });
	}

	public static Gate instance() {
		if(instance == null)
			instance = new FalseGate();
		return instance;
	}

	@Override
	protected boolean func(boolean[] inValues) {
		return false;
	}

	@Override
	public String getName() {
		return FALSE_GATE;
	}

	@Override
	public Gate simplify() {
		return this;
	}
}
