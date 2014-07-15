databaseChangeLog = {

	changeSet(author: "makingdevs (generated)", id: "1405440162013-1") {
		addColumn(tableName: "pago") {
			column(name: "referencia", type: "varchar(255)")
		}
    sql("update pago set referencia='0'")
 	}

}
