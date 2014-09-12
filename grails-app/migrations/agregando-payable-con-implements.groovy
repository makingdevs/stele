import com.stele.Dependiente

databaseChangeLog = {

	changeSet(author: "makingdevs (generated)", id: "1410360948202-1") {
		createTable(tableName: "applicable_discount") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "applicable_diPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "applicable_discount_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "discount_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "expiration_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "payment_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-2") {
		createTable(tableName: "concept") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "conceptPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(150)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "organization_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-3") {
		createTable(tableName: "discount") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "discountPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "decimal(19,2)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "discount_name", type: "varchar(150)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "organization_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "percentage", type: "decimal(19,2)")

			column(name: "previous_days_for_canceling_discount", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-4") {
		createTable(tableName: "organization") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "organizationPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-5") {
		createTable(tableName: "organization_direccion") {
			column(name: "organization_addresses_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-6") {
		createTable(tableName: "organization_telefono") {
			column(name: "organization_phones_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-7") {
		createTable(tableName: "payment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "paymentPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "accumulated_discount", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "accumulated_surcharges", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "due_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "payment_amount", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "payment_concept", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "payment_date", type: "datetime")

			column(name: "payment_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "payment_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "proof_of_payment_id", type: "bigint")

			column(name: "reference", type: "varchar(255)")

			column(name: "surcharge_id", type: "bigint")

			column(name: "transaction_id", type: "varchar(20)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-8") {
		createTable(tableName: "payment_link") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "payment_linkPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "payment_ref", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-9") {
		createTable(tableName: "payment_link_payment") {
			column(name: "payment_link_payments_id", type: "bigint")

			column(name: "payment_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-10") {
		createTable(tableName: "payment_scheme") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "payment_schemPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "concept_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "payment_amount", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "surcharge_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-11") {
		createTable(tableName: "payment_scheme_discount") {
			column(name: "payment_scheme_discounts_id", type: "bigint")

			column(name: "discount_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-12") {
		createTable(tableName: "payment_with_implements") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "payment_with_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-13") {
		createTable(tableName: "payment_with_no_implements") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "payment_with_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-14") {
		createTable(tableName: "surcharge") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "surchargePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "decimal(19,2)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "organization_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "percentage", type: "decimal(19,2)")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-15") {
		addColumn(tableName: "dependiente") {
			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-33") {
		createIndex(indexName: "FK2DC9B5E18A731973", tableName: "applicable_discount") {
			column(name: "discount_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-34") {
		createIndex(indexName: "FK2DC9B5E1FC696181", tableName: "applicable_discount") {
			column(name: "payment_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-35") {
		createIndex(indexName: "FK38AF7A68C1CA67B3", tableName: "concept") {
			column(name: "organization_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-36") {
		createIndex(indexName: "FK10487541C1CA67B3", tableName: "discount") {
			column(name: "organization_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-37") {
		createIndex(indexName: "FK1229912460815670", tableName: "organization_direccion") {
			column(name: "organization_addresses_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-38") {
		createIndex(indexName: "FK12299124A649AEE2", tableName: "organization_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-39") {
		createIndex(indexName: "FKE2E4D8808103A6D5", tableName: "organization_telefono") {
			column(name: "organization_phones_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-40") {
		createIndex(indexName: "FKE2E4D880E8FC8D12", tableName: "organization_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-41") {
		createIndex(indexName: "FKD11C320694034B2D", tableName: "payment") {
			column(name: "proof_of_payment_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-42") {
		createIndex(indexName: "FKD11C3206A4005301", tableName: "payment") {
			column(name: "surcharge_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-43") {
		createIndex(indexName: "FK9A2B205A974758E8", tableName: "payment_link_payment") {
			column(name: "payment_link_payments_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-44") {
		createIndex(indexName: "FK9A2B205AFC696181", tableName: "payment_link_payment") {
			column(name: "payment_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-45") {
		createIndex(indexName: "FKCCBFCDFE9070EE41", tableName: "payment_scheme") {
			column(name: "concept_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-46") {
		createIndex(indexName: "FKCCBFCDFEA4005301", tableName: "payment_scheme") {
			column(name: "surcharge_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-47") {
		createIndex(indexName: "FK6042B6623014995B", tableName: "payment_scheme_discount") {
			column(name: "payment_scheme_discounts_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-48") {
		createIndex(indexName: "FK6042B6628A731973", tableName: "payment_scheme_discount") {
			column(name: "discount_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-49") {
		createIndex(indexName: "aws_key_uniq_1410360947906", tableName: "s3asset", unique: "true") {
			column(name: "aws_key")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-50") {
		createIndex(indexName: "FK5204E504C1CA67B3", tableName: "surcharge") {
			column(name: "organization_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-16") {
		addForeignKeyConstraint(baseColumnNames: "discount_id", baseTableName: "applicable_discount", constraintName: "FK2DC9B5E18A731973", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "discount", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-17") {
		addForeignKeyConstraint(baseColumnNames: "payment_id", baseTableName: "applicable_discount", constraintName: "FK2DC9B5E1FC696181", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payment", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-18") {
		addForeignKeyConstraint(baseColumnNames: "organization_id", baseTableName: "concept", constraintName: "FK38AF7A68C1CA67B3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-19") {
		addForeignKeyConstraint(baseColumnNames: "organization_id", baseTableName: "discount", constraintName: "FK10487541C1CA67B3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-20") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "organization_direccion", constraintName: "FK12299124A649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-21") {
		addForeignKeyConstraint(baseColumnNames: "organization_addresses_id", baseTableName: "organization_direccion", constraintName: "FK1229912460815670", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-22") {
		addForeignKeyConstraint(baseColumnNames: "organization_phones_id", baseTableName: "organization_telefono", constraintName: "FKE2E4D8808103A6D5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-23") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "organization_telefono", constraintName: "FKE2E4D880E8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-24") {
		addForeignKeyConstraint(baseColumnNames: "proof_of_payment_id", baseTableName: "payment", constraintName: "FKD11C320694034B2D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-25") {
		addForeignKeyConstraint(baseColumnNames: "surcharge_id", baseTableName: "payment", constraintName: "FKD11C3206A4005301", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "surcharge", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-26") {
		addForeignKeyConstraint(baseColumnNames: "payment_id", baseTableName: "payment_link_payment", constraintName: "FK9A2B205AFC696181", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payment", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-27") {
		addForeignKeyConstraint(baseColumnNames: "payment_link_payments_id", baseTableName: "payment_link_payment", constraintName: "FK9A2B205A974758E8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payment_link", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-28") {
		addForeignKeyConstraint(baseColumnNames: "concept_id", baseTableName: "payment_scheme", constraintName: "FKCCBFCDFE9070EE41", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "concept", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-29") {
		addForeignKeyConstraint(baseColumnNames: "surcharge_id", baseTableName: "payment_scheme", constraintName: "FKCCBFCDFEA4005301", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "surcharge", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-30") {
		addForeignKeyConstraint(baseColumnNames: "discount_id", baseTableName: "payment_scheme_discount", constraintName: "FK6042B6628A731973", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "discount", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-31") {
		addForeignKeyConstraint(baseColumnNames: "payment_scheme_discounts_id", baseTableName: "payment_scheme_discount", constraintName: "FK6042B6623014995B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payment_scheme", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1410360948202-32") {
		addForeignKeyConstraint(baseColumnNames: "organization_id", baseTableName: "surcharge", constraintName: "FK5204E504C1CA67B3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organization", referencesUniqueColumn: "false")
	}

  
  changeSet(author: "makingdevs (generated)", id: "1410360948203-1") {
    sql("insert into organization select id,version,date_created,last_updated,nombre from organizacion") 
    sql("insert into concept select * from concepto")
    sql("insert into surcharge select * from recargo")   
    sql("insert into discount select id,version,cantidad,date_created,nombre_de_descuento,last_updated,organizacion_id,porcentaje,dias_previos_para_cancelar_descuento from descuento")
    sql("insert into payment select id,version,descuento_aplicable,recargos_acumulados,date_created,fecha_de_vencimiento,last_updated,cantidad_de_pago,concepto_de_pago,fecha_de_pago,estatus_de_pago,tipo_de_pago,comprobante_de_pago_id,referencia,recargo_id,transaction_id from pago")
    sql("insert into applicable_discount select id,version,descuento_aplicable_status,date_created,descuento_id,fecha_de_expiracion,last_updated,pago_id from descuento_aplicable")
    sql("insert into payment_scheme select id,version,concepto_id,cantidad_de_pago,recargo_id from esquema_de_pago")
    sql("insert into payment_scheme_discount select * from esquema_de_pago_descuento")
    sql("insert into payment_link(version,payment_ref,type) select 0,id,\"${Dependiente.class.simpleName}\" from dependiente") 
    sql("insert into payment_link_payment select pl.id,pp.pago_id from payable_pago pp inner join payment_link pl on pp.payable_pagos_id=pl.payment_ref")
  }

}
