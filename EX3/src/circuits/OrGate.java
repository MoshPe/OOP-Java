package circuits;

public class OrGate extends Gate {
	private static final String OR_GATE = "OR";
	
	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) {
		for (boolean bool : inValues)
			if(bool == true)
				return true;
		return false;
	}

	@Override
	public String getName() {
		return OR_GATE;
	}

	@Override
	public Gate simplify() {
	int counter = 0;
	Gate unknowGateValue = null;
		for (Gate gate : inGates) {
			if(gate.simplify() instanceof TrueGate)
				return TrueGate.instance();
			else if (!(gate.simplify() instanceof FalseGate)) {
				unknowGateValue = gate.simplify();
				counter++;
			}
		}
	if(counter == 1)
		return unknowGateValue;
	else if(counter > 1)
		return this;
	return FalseGate.instance();
	}
	
	/*
	public static void main(String[] argc) {
		Gate[] gates =  { TrueGate.instance(), FalseGate.instance(), TrueGate.instance() };
		Gate a = new AndGate(gates);
		System.out.println(a.calc());
	}*/

}
