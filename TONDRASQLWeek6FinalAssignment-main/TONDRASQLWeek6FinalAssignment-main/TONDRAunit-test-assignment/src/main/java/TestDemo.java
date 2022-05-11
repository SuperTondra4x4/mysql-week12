import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		int sum = 0;
		 
		try {
			
			if( a > 0 && b > 0) {
				sum = a + b;
				
			} else throw new IllegalArgumentException("Both parameters must be positive!");
			
		} catch(IllegalArgumentException e) {
			System.err.println(e);
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
		return sum;
		
	}
	
	public int randomNumberSquared() {
		int randInt = getRandomInt();
		return randInt * randInt;
	}
	
	public int getRandomInt() {
		  Random rand = new Random();
		  return rand.nextInt(10) + 1;
		}
}
