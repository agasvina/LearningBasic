import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * This is a simple java class for understanding the comparable concept
 * We use random generator to generate random number
 * @author luca
 * @version 1.1
 * */
public class CompareObject {

	public static void main(String [] args) {
		ArrayList<Weapon> WeaponList = Weapon.generateList(8);
		System.out.println(Arrays.toString(WeaponList.toArray()));
		
		//sorting using comparable implementation:
		Collections.sort(WeaponList);
		System.out.println(Arrays.toString(WeaponList.toArray()));

		//Now sorting based on the power using Comparator
		Collections.sort(WeaponList, Weapon.WeaponComparator);
		System.out.println(Arrays.toString(WeaponList.toArray()));

		//Using compareTo for string:
		String bigger = "ZZZZ";
		String lesser = "AAAA";
		// this will resulted in positive number
		System.out.println(bigger.compareTo(lesser));
	}
}

class Weapon implements Comparable<Weapon>{
	public int type; //1 --> sword, 2 --> projectile weapon 3 --> super weapon
	public int power;
	
	public Weapon(int t, int p) {
		this.type = t;
		this.power = p;
	}
	
	//static method to randomly generate arraylist of weapon
	// N is the number of weapon
	public static ArrayList<Weapon> generateList(int N) {
		Random random = new Random();
		ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
		for (int i = 0; i < N; i++) {
			//random.nextInt(max - min + 1) + min
			int randomType = random.nextInt(3 - 1 + 1) + 1; 
			int randomPower = random.nextInt(1000 - 200 + 1) + 200;
			weaponList.add(new Weapon(randomType, randomPower));
		}
		return weaponList;
	}
	
	@Override
	public String toString() {
		return this.type+"-"+this.power;
	}

	@Override
	//This will sort based on the type than based on the power
	//return 1 >> object this bigger than object o
	public int compareTo(Weapon o) {
		if(this.type == o.type) {
			if(this.power> o.power) {
				return 1;
			} else {
				return -1;
			}
		} else if(this.type > o.type) {
			return 1;
		} else {
			return -1;
		}
	}
	
	//We can also create a Comparator object
	public static Comparator<Weapon> WeaponComparator = new Comparator<Weapon>() {

		@Override
		public int compare(Weapon o1, Weapon o2) {
			if(o1.power > o2.power) return 1;
			return -1;
		}
		
	};
}