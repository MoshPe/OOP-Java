package circuits;

public abstract class Gate {
	protected Gate[] inGates;
	
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}
	
	public boolean calc() throws CircuitException{
		if(inGates != null) {
		boolean gates[] = new boolean[inGates.length];
		if(inGates.length == 1 && inGates[0] == null)
			return this.func(new boolean[] {});
		for (int i = 0; i < gates.length; i++)
					gates[i] = inGates[i].calc();
		return func(gates);	
		}
		return func(new boolean[1]) ;
	}

	protected abstract boolean func(boolean[] inValues) throws CircuitException;
	
	public abstract String getName();
	
	public abstract Gate simplify();
	
	public String toString() {
		StringBuilder returnFormula = new StringBuilder();
		if((getName().equals("AND")) || (getName().equals("OR")) || (getName().equals("NOT"))) {
			returnFormula.append(getName()+"[");
		for (int i = 0; i < inGates.length; i++) {
				returnFormula.append(inGates[i].toString());
			returnFormula.append(((i + 1) == inGates.length ? "" : ", "));
		}
		if(!(getName().equals("T") && getName().equals("F")))
			returnFormula.append("]");
		return returnFormula.toString();
		}
	return getName();
	}
}
