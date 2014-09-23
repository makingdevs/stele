import com.stele.Institucion

databaseChangeLog = {
  
  changeSet(author: "makingdevs (generated)", id: "1410446070553-3") {
		addColumn(tableName: "organization") {
			column(name: "class", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-18") {
		dropColumn(columnName: "class", tableName: "organizacion")
	}

  changeSet(author: "makingdevs (generated)", id: "1410446070554-1") {
    sql("update organization set class=\"${Institucion.class.name}\"") 
  }

}
