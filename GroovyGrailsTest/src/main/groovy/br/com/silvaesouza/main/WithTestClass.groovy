package br.com.silvaesouza.main

class WithTestClass {
	String property1
	String property2

	List<String> list = []

	def addElement(value) {
		list << value
	}

	def returnProperties () {
		"Property 1: $property1, Property 2: $property2 "
	}

	static main(def args){
		def sample = new WithTestClass()
		
		def result= sample.with {
			property1 = 'Input 1'
			property2 = 'This is cool'
			addElement 'Ubuntu'
			addElement 'Android'
			addElement 'Linux'
			returnProperties()
		}

		println result
		 
		println 3 == sample.list.size()
		println 'Input 1' == sample.property1
		println 'This is cool' == sample.property2
		println 'Linux' == sample.list[2]


		def sb = new StringBuilder()
		println sb.with {
			append 'Just another way to add '
			append 'strings to the StringBuilder '
			append 'object.'
		}
	}
}