import java.util.Random;

/**
 * A simple class for implementing the random number generator
 * This is based on the explanation found in stack overflow
 * The Pseudo random generator is also known as the “deterministic” 
 * random generator. Well, in fact, it’s very unlikely to have a 
 * nondeterminism in the computation. 
 * To generate random number using this generator, we need seed.
 * This process is determined by a set in initial value.
 * 
 * */
public class RandomGenerator {

	private Random random;
	
	//We use the system time, thus we have a different seed for our 
	// random generator
	public RandomGenerator(){
		this.random = new Random(System.currentTimeMillis());
	}
	
	public double generateRandom() {
		return random.nextDouble();
	}
	
	/*
	 * The Main method. In this method we include a simple 
	 * process (i.e. a couple lines of code) to test 
	 * the random generator we have just created.
	 * */
	public static void main(String [] args) {
		RandomGenerator  randGenerator = new RandomGenerator();
		for(int i = 0; i < 10; i++) {
			System.out.println(randGenerator.generateRandom());
		}
	}
	
	
}

