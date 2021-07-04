package ESA9;

public class Helloworld {
	
	public String printMessage(String message) {
		return message + " - HelloWorldTest";
	}
	
	public static void main(String args[]) {
		Helloworld h = new Helloworld();
		System.out.println(h.printMessage("Super"));
	}
	
	
}
