package groovy.runtime.metaclass.br.com.silvaesouza.main

import groovy.json.JsonBuilder
import groovy.json.JsonOutput;

class TaskMetaClass extends DelegatingMetaClass{

	TaskMetaClass(MetaClass meta) {
		super(meta)
	}

	@Override
	def invokeMethod(Object object, String method, Object[] args) {
		println method
		if (method == "toJson") {
			JsonBuilder b1 = new JsonBuilder(object)
			return JsonOutput.prettyPrint(b1.toString())
		}
		super.invokeMethod(object, method, args)
	}
}
