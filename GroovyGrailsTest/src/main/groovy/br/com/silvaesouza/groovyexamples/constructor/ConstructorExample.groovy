package br.com.silvaesouza.groovyexamples.constructor

import groovy.transform.ToString;

@ToString
public class ConstructorExample {

	String firstParameter;
	String secondParameter;
	int number;
	def wharever;
	
	static exampleDefaultParameter() {
		println sum(1,5)
		println sum(1,2,5)
	}
	
	static sum(a,b,c=0){
		a+b+c;
	}
	
}
