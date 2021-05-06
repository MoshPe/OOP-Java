package circuits;

public class AndGate extends Gate {
	private static final String AND_GATE = "AND";

	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) {
		for (boolean bool : inValues)
			if (bool == false)
				return false;
		return true;
	}

	@Override
	public String getName() {
		return AND_GATE;
	}

	@Override
	public Gate simplify() {
		int unknown_gate_counter = 0;
		Gate unknowGates[] = new Gate[inGates.length];
		for (Gate gate : inGates) {
			if (gate.simplify() instanceof FalseGate)
				return FalseGate.instance();
			else if (!(gate.simplify() instanceof TrueGate))
				unknowGates[unknown_gate_counter++] = gate.simplify();
		}
		if (unknown_gate_counter == 1)
			return unknowGates[0];
		else if (unknown_gate_counter > 1)
			return new AndGate(clearNullFromArr(unknowGates, unknown_gate_counter));
		return TrueGate.instance();
	}
	
	private Gate[] clearNullFromArr(Gate[] gates, int sizeOfNonNull) {
		Gate[] nonNullGates = new Gate[sizeOfNonNull];
		int i = 0;
		for (Gate gate : gates)
			if (gate != null)
				nonNullGates[i++] = gate;
		return nonNullGates;
	}
	
}
