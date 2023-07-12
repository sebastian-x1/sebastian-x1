//Objective: Create a java program of interfaces
//Created by: Sebastian Xayaphet
//Date: 6/24/2023
//Version: jdk-19
public class testEdible {

	public static void main(String[] args) {
		Object[] objects = {new Tiger(), new Chicken(),new Apple(), new Fish(), new Watermelon()};
		for (int i = 0; i < objects.length; i++) {
		if (objects[i] instanceof Edible ) 
				System.out.println(((Edible)objects[i]).howToEat());
			
			if (objects[i] instanceof Animal) {
				System.out.println(((Animal)objects[i]).sound());
			}
		}

	}

}
abstract class Animal {
	private double weight;
	
	public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;

}
//return animal sound
public abstract String sound();
}
class Chicken extends Animal implements Edible {
	@Override
	public String howToEat() {
		return "Chicken: Fry it";
	}
	@Override
	public String sound() {
		return "Chicken: cock-a-doodle-doo";
	}
}
class Tiger extends Animal {
	@Override
	public String sound() {
		return "Tiger: RROOAARR";
	}
}
class Fish extends Animal implements Edible {
	@Override
	public String howToEat() {
		return "Fish: Fry it";
	}
	@Override
	public String sound() {
		return "";
	}
}
abstract class Fruit implements Edible {
	//data fields, constructors, and methods omitted here
}
class Apple extends Fruit {
	@Override
	public String howToEat() {
		return "Apple: Make apple cider";
	}
}
class Watermelon extends Fruit {
	@Override
	public String howToEat() {
		return "Watermelon: Cut watermelon slices"; 
	}
}
