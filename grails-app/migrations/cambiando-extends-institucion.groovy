import com.stele.Dependiente
import com.stele.Institucion

databaseChangeLog = {

	changeSet(author: "makingdevs (generated)", id: "1410446070553-1") {
		createTable(tableName: "institucion_direccion") {
			column(name: "institucion_direcciones_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-2") {
		createTable(tableName: "institucion_telefono") {
			column(name: "institucion_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-3") {
		addColumn(tableName: "organization") {
			column(name: "class", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-4") {
		dropForeignKeyConstraint(baseTableName: "cuentas_bancarias", baseTableSchemaName: "stele_dev", constraintName: "FKD9D2BCC2418DE2A1")
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-5") {
		dropForeignKeyConstraint(baseTableName: "distribucion_institucional", baseTableSchemaName: "stele_dev", constraintName: "FK4B3D26CA8C0A9FFC")
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-6") {
		dropForeignKeyConstraint(baseTableName: "usuario_instituciones", baseTableSchemaName: "stele_dev", constraintName: "FKF5FF5E868C0A9FFC")
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-14") {
		createIndex(indexName: "FK6F9EC3DA53AFD0FD", tableName: "institucion_direccion") {
			column(name: "institucion_direcciones_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-15") {
		createIndex(indexName: "FK6F9EC3DAA649AEE2", tableName: "institucion_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-16") {
		createIndex(indexName: "FK5143770AE8FC8D12", tableName: "institucion_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-17") {
		createIndex(indexName: "FK5143770AFB39D8BC", tableName: "institucion_telefono") {
			column(name: "institucion_telefonos_id")
		}
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

	changeSet(author: "makingdevs (generated)", id: "1410446070553-10") {
		addForeignKeyConstraint(baseColumnNames: "institucion_direcciones_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DA53AFD0FD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-11") {
		addForeignKeyConstraint(baseColumnNames: "institucion_telefonos_id", baseTableName: "institucion_telefono", constraintName: "FK5143770AFB39D8BC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-12") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "institucion_telefono", constraintName: "FK5143770AE8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410446070553-13") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

  changeSet(author: "makingdevs (generated)", id: "1410360948203-1") {
    sql("insert into concept select * from concepto")
    sql("insert into surcharge select * from recargo")   
    sql("insert into discount select id,version,cantidad,date_created,nombre_de_descuento,last_updated,organizacion_id,porcentaje,dias_previos_para_cancelar_descuento from descuento")
    sql("insert into payment select id,version,descuento_aplicable,recargos_acumulados,date_created,fecha_de_vencimiento,last_updated,cantidad_de_pago,concepto_de_pago,fecha_de_pago,estatus_de_pago,tipo_de_pago,comprobante_de_pago_id,referencia,recargo_id,transaction_id from pago")
    sql("insert into applicable_discount select id,version,descuento_aplicable_status,date_created,descuento_id,fecha_de_expiracion,last_updated,pago_id from descuento_aplicable")
    sql("insert into payment_scheme select id,version,concepto_id,cantidad_de_pago,recargo_id from esquema_de_pago")
    sql("insert into payment_link(version,payment_ref,type) select 0,id,\"${Dependiente.class.simpleName}\" from dependiente") 
    sql("insert into payment_link_payment select pl.id,pp.pago_id from payable_pago pp inner join payment_link pl on pp.payable_pagos_id=pl.payment_ref")
    sql("insert into organization select id,version,date_created,last_updated,nombre,\"${Institucion.class.name}\" from organizacion") 
  }

}
