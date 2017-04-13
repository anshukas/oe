package oe.demo;

public class Demo1 {
	public static void main(String[] args) {
		/*B objB = new B();
		objB.displayA();
		objB.displayB();
		
		A objA = new A();
		objA.displayA();*/
		
		B objB = new B();
		((A)objB).displayA();
		
	}
}

class A{
	void displayA(){
		System.out.println("DisplayA from class A");
	}
	
}
class B extends A{
	void displayB(){
		System.out.println("DisplayB from class B");
	}
}
