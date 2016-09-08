package br.com.silvaesouza.main

import groovy.text.SimpleTemplateEngine
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration

class WorkWithTemplateEngine {
	
	static String templateText = '''Project report:

We have currently ${tasks.size} number of items with a total duration of $duration.
<% tasks.each { %>- $it.summary
<% } %>

'''
	
	static String xml_template = '''xmlDeclaration()
	tasks {
	  tasks.each {
	    task (summary: it.summary, duration: it.duration)
	  }
	}'''
	
	static String html_template ='''
	yieldUnescaped '<!DOCTYPE html>'
	html(lang:'en') {
	  head {
	    meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
	    title('My page')
	  }
	  body {
	    p('This is an example of HTML contents')
	  }
	}'''
	
	static main(def args) {
		def list = [
			new Task("Learn Groovy", 4),
			new Task("Learn Grails", 12)]
		
		def totalDuration = 0
		list.each {totalDuration += it.duration}
		
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(templateText)
		def binding = [
		duration: "$totalDuration",
		tasks: list]
		
		println template.make(binding).toString()
		
		def values = [tasks:[
			new Task("Doit1", 4),
			new Task("Doit2", 12)
			]]
		
		TemplateConfiguration config = new TemplateConfiguration()
		engine = new MarkupTemplateEngine(config)
		def template1 = engine.createTemplate(xml_template)
		def template2 = engine.createTemplate(html_template)
		println template1.make(values)
		println template2.make(values)
	}

}
