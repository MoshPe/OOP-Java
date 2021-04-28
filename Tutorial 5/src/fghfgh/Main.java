package fghfgh;

public class Main {
	public static void main(String[] argc) {
		Reporter r = new AverageReporter();

		Reporter b = new MostCommonReporter(51);
		Reporter c = new ReporterDecorator(b,r);
		
		Util.reportAll(new int[] { 3,50,50,4,4,4}, new Reporter[] {r,b,c});
	}
}
