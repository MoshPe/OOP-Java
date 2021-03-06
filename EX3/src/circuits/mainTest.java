package circuits;

public class mainTest {
	
	public static void main(String[] argc) throws CircuitException {	
		VarGate v1 = new VarGate("1");
		VarGate v2 = new VarGate("2");
				
		Gate g1 = new Or2Gate(FalseGate.instance(), TrueGate.instance());
		Gate g3 = new Or2Gate(v1, new NotGate(new NotGate(v2))); 
		Gate g2 = new Or2Gate(v1, new NotGate(v2)); 
		
		Gate out = new AndGate(new Gate[] { g1, g2, TrueGate.instance() ,g3});
		
		//Gate g = FalseGate.instance();
		//Gate g2 = TrueGate.instance();
		//System.out.println(g.calc());		
		
		//v1.setVal(false);
		//v2.setVal(true);
		//System.out.println(out + " = " + out.calc());
		System.out.println(out + " = " + out.simplify());
		v1.setVal(false);
		System.out.println(out + " = " + out.simplify());
		v2.setVal(true);
		System.out.println(out + " = " + out.simplify());
	/*
	public static void main(String[] argc) {
		Gate[] gates =  { TrueGate.instance(), TrueGate.instance(), TrueGate.instance() };
		VarGate v1 = new VarGate("1");
		VarGate v2 = new VarGate("2");
		v1.setVal(true);
		Gate a = new And2Gate(TrueGate.instance(), new NotGate(v1));
		//Gate b = new AndGate(gates);
		//Gate c = new AndGate(new Gate[] {a,b,v1 });
		Gate e = new Or2Gate(TrueGate.instance(), v1);
		
		//Gate g1 = new AndGate(new Gate[] {c, TrueGate.instance(), v1});

		System.out.println(a.calc());
		System.out.println(a);
		System.out.println(e.calc());
		System.out.println(e);
	}*/
	}
}
