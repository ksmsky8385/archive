package mini_project_10_추상클래스_2;

public class MainClass {
	public static void main(String[] args) {

		Sonata car1 = new SonataLowGrade(CarSpecs.colorBlue, CarSpecs.tireNormal, CarSpecs.displacement2000, CarSpecs.handlePower);
		Sonata car2 = new SonataHighGrade(CarSpecs.colorRed, CarSpecs.tireWide, CarSpecs.displacement2500, CarSpecs.handlePower);
		
		evaluation(car1);
		evaluation(car2);
	}
	
	public static void evaluation(Sonata car) {
		System.out.println("****************************");
		if(car.getSpec() > 2000) {
			System.out.println("세금: 1500");
		}
		else {
			System.out.println("세금: 1000");
		}
		System.out.println("****************************");
	}
}
