package circuits;

public class NotGate extends Gate {
	private static final String NOT_GATE = "NOT";
	private Gate in;
	
	public NotGate(Gate in) {
	super(new Gate[] { in });
	this.in = in;
	}

	@Override
	protected boolean func(boolean[] inValues) {
		return !inValues[0];
	}

	@Override
	public String getName() {
		return NOT_GATE;
	}

	@Override
	public Gate simplify() {
		if(!(in.simplify() instanceof FalseGate) && !(in.simplify() instanceof TrueGate))
			return this;
		if(in.simplify() instanceof TrueGate)
			return  FalseGate.instance();
		return  TrueGate.instance();
	}
	/*
	public static void main(String[] argc) {
		Gate[] gates =  { TrueGate.instance(), FalseGate.instance(), TrueGate.instance() };
		Gate a = new AndGate(gates);
		System.out.println(a.calc());
	}*/

}
