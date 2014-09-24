databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id:"1411577238852-2"){
    sql("ALTER TABLE qa_stele_db.organization ENGINE=InnoDB")
  }
	
  changeSet(author: "makingdevs (generated)", id: "1411577238852-3") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "cuentas_bancarias", constraintName: "FKD9D2BCC2418DE2A1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1411577238852-4") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1411577238852-9") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}
}
