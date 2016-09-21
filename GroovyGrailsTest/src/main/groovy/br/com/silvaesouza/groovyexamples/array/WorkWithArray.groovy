package br.com.silvaesouza.groovyexamples.array

class WorkWithArray {
	
	static main(def args) {
		example1()
	}
	
	static example1() {
		def mylist= [1, 2, "Lars", "4"]
		mylist.each{ println it }
	}

}
