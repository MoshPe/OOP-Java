package fghfgh;

public class ReporterDecorator implements Reporter{
	private Reporter base1,base2;
	
	public ReporterDecorator(Reporter base1,Reporter base2) {
		this.base1 = base1;
		this.base2 = base2;
	}

	@Override
	public void addNumber(int num) {
		base1.addNumber(num);
		base2.addNumber(num);
		
	}

	@Override
	public int report() {
		return base1.report() + base2.report();
	}
	
}
