package br.com.silvaesouza.main

public class Person{
  String firstName
  String lastName
  int age
  def address
  
  Person() { }
  
  Person(String firstName, String lastName){
	this.firstName = firstName
	this.lastName= lastName
  }
  
  static void main(def args) {
    Person p = new Person()
    // use the generated access methods
    p.setFirstName("Lars")
    // this will still use the generated access method, it is not a direct access!
    p.lastName = "Vogel" 
    p.address = ("Homestreet 3");
    println(p.firstName + " " + p.lastName + " | " + p.address);
    // use the generated constructor
    p = new Person(firstName: "Peter", lastName:"Mueller");
    println(p.firstName + " " + p.lastName + " | " + p.address);
  }
  
} 
