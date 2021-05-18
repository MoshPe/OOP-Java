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
	/*
	 * Algorithm: Counting the amount of unknown gates that has
	 * 			  a value of null and saving it into an initialize array. 
	 */
	@Override
	public Gate simplify() {
		int unknown_gate_counter = 0;
		Gate unknowGates[] = new Gate[inGates.length];
		for (Gate gate : inGates) {
			//checking for a false gate and return it 
			if (gate.simplify() instanceof FalseGate)
				return FalseGate.instance();
			else if (!(gate.simplify() instanceof TrueGate))
				unknowGates[unknown_gate_counter++] = gate.simplify();
		}
		//if there is only one unknown gate the function return that gate 
		if (unknown_gate_counter == 1)
			return unknowGates[0];
		/* if there are more unknown gates the function return a new array with the
		* exact amount of the unknown gates 
		*/
		else if (unknown_gate_counter > 1)
			return new AndGate(clearNullFromArr(unknowGates, unknown_gate_counter));
		return TrueGate.instance();
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
