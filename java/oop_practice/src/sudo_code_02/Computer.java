package sudo_code_02;

public class Computer {
	
//	// Aggregation (집약) 코딩
//	private MainBoard mb;
//	private CPU c;
//	private Memory m;
//	private PowerSupply ps;
//	
//	public Computer(MainBoard mb, CPU c, Memory m, PowerSupply ps) {
//		this.mb = mb;
//		this.c = c;
//		this.m = m;
//		this.ps = ps;
//	}
	
//	// Composition (합성) 코딩
	private MainBoard mb;
	private CPU c;
	private Memory m;
	private PowerSupply ps;
	
	public Computer() {
		this.m = new Mainboard();
		this.c = new CPU();
		this.m = new Memory();
		this.ps = new PowerSupply();
	}

}
