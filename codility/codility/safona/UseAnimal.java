class Animal {}
class Horse extends Animal {}
class UseAnimal {

	public void doStuff(Animal obj){System.out.println("A");}
	public void doStuff(Horse obj){System.out.println("B");}

	public static void main (String[] args){
	
		Animal a = new Animal();
		Horse h = new Horse();
		UseAnimal ua = new UseAnimal();

		ua.doStuff(a);
		ua.doStuff(h);

		Animal ah = new Horse();
		ua.doStuff(ah);
	
		int x=3,y=5;
		if (x=y);


	}

	public void doit(){}
	//public int doit(){return 1;}
	public double doit(int x){return 4.2;}

}
