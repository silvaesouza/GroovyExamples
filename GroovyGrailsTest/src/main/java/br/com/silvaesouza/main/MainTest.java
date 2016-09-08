package br.com.silvaesouza.main;

public class MainTest {
	
	public static void main(String[] args) {
		
		Person p = new Person();
	    p.setFirstName("Lars");
	    p.setLastName("Vogel");
	    System.out.println(p.getFirstName() + " " + p.getLastName());
	    
	    Hello.arrays();
	    Hello.testeJSon();
		
	}

}
