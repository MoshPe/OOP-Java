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
	/*
	 * Algorithm: Counting the amount of unknown gates that has
	 * 			  a value of null and saving it into an initialize array. 
	 */
	@Override
	public Gate simplify() {
		//counting the amount of unknown gates
		int unknown_gate_counter = 0;
		Gate unknowGates[] = new Gate[inGates.length];
		for (Gate gate : inGates) {
			//checking for a true gate and return it 
			if (gate.simplify() instanceof TrueGate)
				return TrueGate.instance();
			else if (!(gate.simplify() instanceof FalseGate))
				//adding the unknown gate to the unknown gates array
				unknowGates[unknown_gate_counter++] = gate.simplify();
		}
		//if there is only one unknown gate the function return that gate 
		if (unknown_gate_counter == 1)
			return unknowGates[0];
		/* 
		 * if there are more unknown gates the function return a new array with the
		 *  exact amount of the unknown gates 
		 */
		else if (unknown_gate_counter > 1)
			return new OrGate(clearNullFromArr(unknowGates, unknown_gate_counter));
		return FalseGate.instance();
	}
	//creating a new array without the null gates
	private Gate[] clearNullFromArr(Gate[] gates, int sizeOfNonNull) {
		Gate[] nonNullGates = new Gate[sizeOfNonNull];
		int i = 0;
		for (Gate gate : gates)
			if (gate != null)
				nonNullGates[i++] = gate;
		return nonNullGates;
	}

}
