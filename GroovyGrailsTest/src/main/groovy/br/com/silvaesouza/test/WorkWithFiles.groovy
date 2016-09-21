package br.com.silvaesouza.test

class WorkWithFiles {
	
	static final caminhoFile = "C:/Users/Public/TEMP/"
	
	static final nomeArquivoIn = "teste.txt"
	
	static final nomeArquivoOut = "output.txt"
	
	static main(def args) {
		readFile()
		writeFile()
	}
	
	static writeFile() {
		// write the content of the file to the console
		File file = new File("$caminhoFile$nomeArquivoOut")
		file.write "Hello\n"
		file.append "Testing\n"
		file << "More appending...\n"
		
		//def data = new URL(http://www.vogella.com).text
		
		//alternatively use Groovy JDK methods
	    file << 'http://www.vogella.com'.toURL().text
		
		File result = new File("$caminhoFile$nomeArquivoOut")
		println (result.text)
		// clean-up
		//file.delete()
	}
	
	static readFile() {
		// write the content of the file to the console
		File file = new File("$caminhoFile$nomeArquivoIn")
		file.eachLine{ line -> println line }
		
		// adds a line number in front of each line to the console
		def lineNumber = 0
		file = new File("$caminhoFile$nomeArquivoIn")
		
		file.eachLine{ line ->
		  lineNumber++
		  println "$lineNumber: $line"
		}
		
		// read the file into a String
		String s = new File("$caminhoFile$nomeArquivoIn").text
		println s
	}

}
