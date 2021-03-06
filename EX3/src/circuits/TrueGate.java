package circuits;

public class TrueGate extends Gate  {
	private static final String TRUE_GATE = "T";
	private static TrueGate instance = null;
	
	private TrueGate() {
		super(new Gate[] { TrueGate.instance });
	}

	public static Gate instance() {
		if(instance == null)
			instance = new TrueGate();
		return instance;
	}

	@Override
	protected boolean func(boolean[] inValues) {
		return true;
	}

	@Override
	public String getName() {
		return TRUE_GATE;
	}

	@Override
	public Gate simplify() {
		return this;
	}
}
