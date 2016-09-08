package br.com.silvaesouza.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;

public class ExecuteGroovyViaJSR223 {
	
	public static void main(String[] args) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
		try {
			engine.put("street", "Haindaalwisch 17a");
			engine.eval("println 'Hello, Groovy!'");
			engine.eval(new FileReader("src/main/groovy/br/com/silvaesouza/main/Hello.groovy"));

			File currentDir = new File("./src/main/groovy/br/com/silvaesouza/main");
			String file = "Hello.groovy";
			
			Binding binding = new Binding();
		    GroovyShell shell = new GroovyShell(binding);
		    String[] test = null;
		    Object result = shell.run(new File(currentDir, file), test);
			
			String[] roots = new String[] { currentDir.getAbsolutePath() };
			GroovyScriptEngine gse = new GroovyScriptEngine(roots);
			binding = new Binding();
			result = gse.run(file, binding);
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}