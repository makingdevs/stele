class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

    "/listaConcepto"(controller: "Concepto") {
      action = [GET: "obtenerListaConceptos"]
    }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
