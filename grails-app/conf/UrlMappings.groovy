class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

    "/listaConcepto/$query?"(controller: "Concepto") {
      action = [GET: "obtenerListaConceptos"]
    }

    "/listaDescuento/$query?"(controller: "Descuento") {
      action = [GET: "obtenerDescuentosInstitucion"]
    }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
