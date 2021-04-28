package circuits;

public class AndGate extends Gate {
	private static final String AND_GATE = "AND";
	
	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) {
		for (boolean bool : inValues)
			if(bool == false)
				return false;
		return true;
	}

	@Override
	public String getName() {
		return AND_GATE;
	}

	@Override
	public Gate simplify() {
		int counter = 0;
		Gate unknowGateValue = null;
			for (Gate gate : inGates) {
				if(gate.simplify() instanceof FalseGate)
					return FalseGate.instance();
				else if (!(gate.simplify() instanceof TrueGate)) {
					unknowGateValue = gate.simplify();
					counter++;
				}
			}
		if(counter == 1)
			return unknowGateValue;
		else if(counter > 1)
			return this;
		return TrueGate.instance();
		}
	}
