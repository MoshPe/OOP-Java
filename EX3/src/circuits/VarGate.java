package circuits;

public class VarGate extends Gate {
	private String name;
	private Gate value;
		
	public VarGate(String name) {
		super(null);
		this.name = name;
		value = null;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException{
		if(value == null)
<<<<<<< HEAD
			throw new CircuitException();
=======
			throw new CircuitException("^^");
>>>>>>> 4d53449f51915f7ce98078c832c7807b6d773789
		return value.simplify().func(null);
	}
	
	public void setVal(boolean value) {
		if(value == false)
			this.value = FalseGate.instance();
		else
			this.value = TrueGate.instance();
	}

	@Override
	public String getName() {
		return "V" + name;
	}

	@Override
	public Gate simplify() {
		if(value == null)
			return null;
		if(value instanceof TrueGate)
			return TrueGate.instance();
		return FalseGate.instance();
	}
}
