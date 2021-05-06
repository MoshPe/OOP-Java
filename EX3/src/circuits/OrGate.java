package circuits;

public class OrGate extends Gate {
	private static final String OR_GATE = "OR";

	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) {
		for (boolean bool : inValues)
			if (bool == true)
				return true;
		return false;
	}

	@Override
	public String getName() {
		return OR_GATE;
	}

	@Override
	public Gate simplify() {
		int unknown_gate_counter = 0;
		Gate unknowGates[] = new Gate[inGates.length];
		for (Gate gate : inGates) {
			if (gate.simplify() instanceof TrueGate)
				return TrueGate.instance();
			else if (!(gate.simplify() instanceof FalseGate))
				unknowGates[unknown_gate_counter++] = gate.simplify();
		}
		if (unknown_gate_counter == 1)
			return unknowGates[0];
		else if (unknown_gate_counter > 1)
			return new OrGate(clearNullFromArr(unknowGates, unknown_gate_counter));
		return FalseGate.instance();
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
