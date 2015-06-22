/**
 * A class to give a simple explanation about the differences between abstract class and interface.
 * @author Luca
 * @version 1.1
 * */
public class LearnInterfaceAndAbstract{
	public static void main(String [] args) {
		//this statement below is invalid
			//Plane plane = new Plane();
		Plane jet = new Jet("OathKeeper", 1234);
		//this method is also invalid.
			//jet.explode();
		Jet realJet = new Jet("Oblivion", 4567);
		
		jet.fly();
		realJet.fly();
		realJet.explode();
	}
}

abstract class Plane{
	public String name;
	public int speed;
	
	//Defining constructor, consideration:
	public Plane(String n, int s) {
		this.name = n;
		this.speed = s;
	}
	//it has a method that need to be implemented
	abstract void fly();
	//it can also contain "real"-method
	public void move() {
		System.out.println("I'm moving on the ground");
	}
		
}

/**
 * An example of interface
 * */
interface Explodable{
	//any interface method have to be public
	void explode();
}

class Jet extends Plane implements Explodable{

	public Jet(String n, int s) {
		super(n,s);
	}

	@Override
	void fly() {
		System.out.println("I'm, " + this.name + ", flying");
	}
	
	@Override
	public void explode() {
		System.out.println("BOOM!!");
	}
}


