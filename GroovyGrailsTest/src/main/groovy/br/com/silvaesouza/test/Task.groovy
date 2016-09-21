package br.com.silvaesouza.test

import groovy.json.JsonBuilder
import groovy.json.JsonOutput;

class Task {
	String summary
	int duration
	String description

	Task(String summary, int duration) {
		this.summary = summary
		this.duration = duration
	}
	
	Task(String summary, String description) {
		this.summary = summary
		
		this.description = description
	}

	/*
	def methodMissing (String name, args){
		if (name=="toJson") {
			JsonBuilder b1 = new JsonBuilder(this)
			return JsonOutput.prettyPrint(b1.toString())
		}
	}
	*/
}
