package br.com.silvaesouza.main

class Hello {
	
	def reverseStringAndAddLars(String s){
		(s.reverse()<<"Lars").toString()
	 }
	  

	static void main(def args){
		int escolha = 15;

		if (escolha == 1)
			arrays()
		else if (escolha == 2)
			defaultNum()
		else if (escolha == 3)
			loopAndRange()
		else if (escolha == 4)
			stringAndGString()
		else if (escolha == 5)
			listToArray()
		else if (escolha == 6)
			println lengthAllWords(["Oi, Tudo", "Bem?...", "Não sei"])
		else if (escolha == 7)
			searchList()
		else if (escolha == 8)
			workWithMap()
		else if (escolha == 9)
			eachAnyEvery()
		else if (escolha == 10)
			listToMap()
		else if (escolha == 11)
			groovyTruth()
		else if (escolha == 12) {
			println 'Object equals' == testingSwitch(51)
			println 'Pattern match' == testingSwitch("Regular pattern matching")
			println 'Range contains' == testingSwitch(13)
			println 'List contains' == testingSwitch('Ubuntu')
			println 'Closure boolean' == testingSwitch(9)
			println 'Class isInstance' == testingSwitch('This is an instance of String')
			println 'Default' == testingSwitch(200)
		} else if (escolha == 13)
			iterativeWithNumber()
		else if (escolha == 14)
			testeAll()	
		else if (escolha == 15)
			testeJSon()
	
		//String.metaClass.reverseStringAndAddLars = { -> reverseStringAndAddLars(delegate) }
		//println 'Hamburg'.reverseStringAndAddLars()
		
	}
	
	
	
	static testeJSon() {
		def t = new Task("Mop","Learn all about Mop");
		println t.toJson()
	}
	
	static testeAll() {
		def test = new AnyMethodExecutor ();
		
		// you can call any method you like
		// on this class
		println "This method is just fake" == test.hall();
		println "This method is just fake" == test.Hallo();
		println "Still a fake method but 'hello' back to you." == test.helloMethod();
		
		test.hello()
		
		// setting is basically ignored
		test.test= 5;
		test.superDuperCool= 100
		
		// all properties return 5
		println test.superDuperCool == 5
		println test.value == 5;
		
	}
	
	static iterativeWithNumber() {
		5.times {println "Times + $it "}
		1.upto(3) {println "Up + $it "}
		4.downto(0) {print "Down $it | "}
		println ''
		def sum = 0
		1.upto(100) {sum += it}
		println sum
		(1..6).each {print "Range $it | "}
	}
	
	static testingSwitch(input) {
		def result
		switch (input) {
			case 51:
				result = 'Object equals'
				break
			case ~/^Regular.*matching/:
				result = 'Pattern match'
				break
			case 10..50:
				result = 'Range contains'
				break
			case ["Ubuntu", 'Android', 5, 9.12]:
				result = 'List contains'
				break
			case { it instanceof Integer && it < 50 }:
				result = 'Closure boolean'
				break
			case String:
				result = 'Class isInstance'
				break
			default:
				result = 'Default'
				break
		}
		result
	}
	
	static groovyTruth() {
		def map = [:]
		assert !map
		
		def list = ["Ubuntu", "Android"]
		if (list) println true else println false
		println !0
		if (1) println true else println false
		if (-1) println true else println false
		println !""
		if ("Hello") println true else println false
		def test = null
		println !test
	}
	
	static listToMap() {
		def words = ['Ubuntu', 'Android', 'Mac OS X', 'Windows']
		
		// simple conversion
		def result = words.collectEntries {
		  [(it):0]
		}
		
		println result.size() == 4
		println result.Ubuntu == 0
		
		// now calculate value with a closure, true if word contains "n"
		def map = words.collectEntries {
		  [(it): it.contains('n')]
		}
		
		println map
		println map.Ubuntu && map.Windows && map.Android && !map.'Mac OS X'
	}

	static workWithMap() {
		// create map
		def map = ["Jim":"Knopf", "Thomas":"Edison"]
		// the dot operator is overloaded to access the value
		map.AnotherKey="Testing"
		// create map without quotes for the keys
		def anotherMap = [Jim:"Knopf", Thomas:"Edison"]
		// size is used to determine the number of elements
		println anotherMap.size()

		// if key should be evaluated put it into brackets
		def x ="a"
		// not true, as x is interpreted as "x"
		println ([a:1]==[x:1])
		// force Groovy to see x as expression
		println ([a:1]==[(x):1])

		// create empty map
		def emptyMap = [:]
	}

	static searchList() {
		def l1 = ['test', 12, 20, true]
		// check with grep that one element is a Boolean
		println '                            [true] == l1.grep(Boolean) --> ' + ([true]== l1.grep(Boolean))

		// grep for all elements which start with a pattern
		println "['Groovy'] == ['test', 'Groovy', 'Java'].grep(~/^G.*/) --> " + (['Groovy']== ['test', 'Groovy', 'Java'].grep(~/^G.*/))

		// grep for if the list contains b and c
		println "   ['b', 'c'] == ['a', 'b', 'c', 'd'].grep(['b', 'c']) --> " + (['b', 'c']== ['a', 'b', 'c', 'd'].grep(['b', 'c']))

		// grep for elements which are contained in the range
		println "          [14, 16] == [5, 14, 16, 75, 12].grep(13..17) --> " + ([14, 16]== [5, 14, 16, 75, 12].grep(13..17))

		// grep for elements which are equal to 42.031
		println "[42.031] == [15, 'Peter', 42.031, 42.032].grep(42.031) --> " + ([42.031]== [15, 'Peter', 42.031, 42.032].grep(42.031))

		// grep for elements which are larger than 40 based on the closure
		println "[50, 100, 300] == [10, 12, 30, 50, 100, 300].grep({ it > 40 }) -->" + ([50, 100, 300]== [10, 12, 30, 50, 100, 300].grep({ it > 40 }))

	}

	static int lengthAllWords(def list) {
		// calculate the length of every String in the list
		def sizeList = list*.size()
		
		list.sort({s1, s2 -> s1.size() <=> s2.size()});
		
		int sizeAll = 0
		
		/*
		list.each{word->
			def tam = word.size()
			sizeAll += tam
			println word + "|" + tam
		}
		*/
		
		//list.each({line -> println line})
		list.each({
			def tam = it.size()
			sizeAll += tam
			println "${it} | $tam"})
	  
		return sizeAll
	}

	static listToArray() {
		// demo of auto conversion
		def String[] strings = "This is a long sentence".split();
		// convert Array to list
		def List listStrings = strings
		// convert List back to Array
		def String[] arrayStrings = listStrings

		println strings.class.name + "|" + strings.size()
		println listStrings.class.name + "|" + listStrings.size()
		println arrayStrings.class.name + "|" + arrayStrings.size()
	}

	static stringAndGString() {
		def name = "John"
		def s1 = "Hello $name" // $name will be replaced
		def s2 = 'Hello $name' // $name will not be replaced
		println s1
		println s2
		println s1.class
		println s2.class

		// demonstrates object references and method calls
		def date = new Date()
		println "We met at $date"
		println "We met at ${date.format('MM/dd/yy')}"
	}
	
	static eachAnyEvery() {
		def mymap = [1:"Jim Knopf", 2:"Thomas Edison", 3:"Lars Vogel"]
		mymap.each {entry -> println (entry.key > 1)}
		mymap.each {entry -> println (entry.value.contains("o"))}
		println "Lars contained:" + mymap.any {entry -> entry.value.contains("Lars")}
		println "Every key small than 4:" + mymap.every {entry -> entry.key < 4}
	
		def result =''
		for (key in mymap.keySet()) {
		  result += key
		}
		println result
	
		mymap.each { key, value ->
		  print key + " "
		  println value
		}
	
		mymap.each { entry ->
		  print entry.key + " "
		  println entry.value
		}
	}

	static arrays() {
		def mylist= [1, 2, "Lars", "4"]
		mylist.each{ println it }
	}

	static loopAndRange() {
		for (i in 0..9) {
			println ("Hello $i")
		}
		println 'B'..'E' == ['B', 'C', 'D', 'E']
	}

	static defaultNum() {
		println sum(1,5)
		println sum(1,2,5)
	}

	static sum(a,b,c=0){
		a+b+c;
	}
}