import com.stele.Institucion

databaseChangeLog = {
  
  changeSet(author: "makingdevs (generated)", id: "1410446070553-3") {
		addColumn(tableName: "organization") {
			column(name: "class", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

  changeSet(author: "makingdevs (generated)", id: "1410446070553-4") {
    dropForeignKeyConstraint(baseTableName: "cuentas_bancarias", constraintName: "FKD9D2BCC2418DE2A1")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-5") {
    dropForeignKeyConstraint(baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-6") {
    dropForeignKeyConstraint(baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-18") {
    dropColumn(columnName: "class", tableName: "organizacion")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070554-1") {
    sql("update organization set class=\"${Institucion.class.name}\"") 
  }

}
