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
    dropForeignKeyConstraint(baseTableName: "cuentas_bancarias", baseTableSchemaName: "qa_stele_db", constraintName: "FKD9D2BCC2418DE2A1")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-5") {
    dropForeignKeyConstraint(baseTableName: "distribucion_institucional", baseTableSchemaName: "qa_stele_db", constraintName: "FK4B3D26CA8C0A9FFC")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-6") {
    dropForeignKeyConstraint(baseTableName: "usuario_instituciones", baseTableSchemaName: "qa_stele_db", constraintName: "FKF5FF5E868C0A9FFC")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-18") {
    dropColumn(columnName: "class", tableName: "organizacion")
	}

  changeSet(author: "makingdevs (generated)", id: "1410446070554-1") {
    sql("update organization set class=\"${Institucion.class.name}\"") 
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-18") {
    dropColumn(columnName: "class", tableName: "organizacion")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-7") {
    addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "cuentas_bancarias", constraintName: "FKD9D2BCC2418DE2A1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-8") {
    addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
  }

  changeSet(author: "makingdevs (generated)", id: "1410446070553-9") {
    addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DAA649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
  }

}
