package br.com.silvaesouza.main;

import javax.swing.JRadioButton;

import br.com.silvaesouza.groovyexamples.array.WorkWithArray;
import br.com.silvaesouza.groovyexamples.main.Hello;
import br.com.silvaesouza.test.Person;

public class MainTest {
	
	public static void main(String[] args) {
		
		Person p = new Person();
	    p.setFirstName("Lars");
	    p.setLastName("Vogel");
	    System.out.println(p.getFirstName() + " " + p.getLastName());
	    
	    WorkWithArray.example1();
	    Hello.testeJSon();
	    
	    JRadioButton radioButton = new JRadioButton();
		
	}

}
