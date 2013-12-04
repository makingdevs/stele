databaseChangeLog = {

	changeSet(author: "jorge (generated)", id: "1386104507085-1") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "cuentas_bancarias") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cuentas_bancaPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "beneficiario", type: "varchar(80)") {
				constraints(nullable: "false")
			}

			column(name: "cuenta_interbancaria", type: "varchar(18)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "nombre_de_banco", type: "varchar(60)") {
				constraints(nullable: "false")
			}

			column(name: "numero_de_cuenta", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "organizacion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "referencia", type: "varchar(120)")

			column(name: "tipo_transferencia", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jorge (generated)", id: "1386104507085-3") {
		createIndex(indexName: "FKD9D2BCC2418DE2A1", tableName: "cuentas_bancarias") {
			column(name: "organizacion_id")
		}
	}

	changeSet(author: "jorge (generated)", id: "1386104507085-2") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "cuentas_bancarias", constraintName: "FKD9D2BCC2418DE2A1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}


}
