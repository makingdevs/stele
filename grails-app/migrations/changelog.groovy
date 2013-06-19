databaseChangeLog = {

	changeSet(author: "sohjiro (generated)", id: "1371500328616-1") {
		createTable(tableName: "ciclo_escolar") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "ciclo_escolarPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "fecha_fin", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "fecha_inicio", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-2") {
		createTable(tableName: "dependiente") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "dependientePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "camada", type: "varchar(10)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "matricula", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "perfil_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-3") {
		createTable(tableName: "dependiente_pago") {
			column(name: "dependiente_pagos_id", type: "bigint")

			column(name: "pago_id", type: "bigint")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-4") {
		createTable(tableName: "direccion") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "direccionPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "calle", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "ciudad", type: "varchar(255)")

			column(name: "codigo_postal", type: "varchar(6)") {
				constraints(nullable: "false")
			}

			column(name: "colonia", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "delegacion_municipio", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "estado", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "numero_exterior", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "numero_interior", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-5") {
		createTable(tableName: "distribucion_institucional") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "distribucion_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "grado", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "grupo", type: "varchar(10)") {
				constraints(nullable: "false")
			}

			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "nivel_de_estudio", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "turno", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-6") {
		createTable(tableName: "historial_academico") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "historial_acaPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "dependiente_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "distribucion_institucional_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-7") {
		createTable(tableName: "institucion") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "institucionPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "varchar(100)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-8") {
		createTable(tableName: "institucion_direccion") {
			column(name: "institucion_direcciones_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-9") {
		createTable(tableName: "institucion_telefono") {
			column(name: "institucion_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-10") {
		createTable(tableName: "pago") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pagoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "cantidad_de_pago", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "concepto_de_pago", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "estatus_de_pago", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "fecha_de_pago", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "historial_academico_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "tipo_de_pago", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "transaction_id", type: "varchar(20)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-11") {
		createTable(tableName: "perfil") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "perfilPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "apellido_materno", type: "varchar(50)")

			column(name: "apellido_paterno", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "avatar", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "fecha_de_nacimiento", type: "timestamp")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "sexo", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-12") {
		createTable(tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-13") {
		createTable(tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-14") {
		createTable(tableName: "requestmap") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "requestmapPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "config_attribute", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-15") {
		createTable(tableName: "rol") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-16") {
		createTable(tableName: "s3asset") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "s3assetPK")
			}

			column(name: "bucket", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "bytes_per_second", type: "bigint")

			column(name: "bytes_transfered", type: "bigint")

			column(name: "description", type: "varchar(255)")

			column(name: "host_name", type: "varchar(255)")

			column(name: "aws_key", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_modified", type: "bigint")

			column(name: "length", type: "bigint")

			column(name: "local_path", type: "varchar(255)")

			column(name: "local_url", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "mime_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "percent_transferred", type: "double(19)")

			column(name: "protocol", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "aws_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-17") {
		createTable(tableName: "s3asset_options") {
			column(name: "options", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "options_idx", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "options_elt", type: "varchar(200)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-18") {
		createTable(tableName: "telefono") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "telefonoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "extension", type: "varchar(6)")

			column(name: "lada", type: "varchar(255)")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "numero_telefonico", type: "varchar(10)") {
				constraints(nullable: "false")
			}

			column(name: "principal", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "tipo_de_telefono", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-19") {
		createTable(tableName: "usuario") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuarioPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "perfil_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-20") {
		createTable(tableName: "usuario_instituciones") {
			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-21") {
		createTable(tableName: "usuario_rol") {
			column(name: "rol_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-22") {
		addPrimaryKey(columnNames: "options, options_idx", constraintName: "s3asset_optioPK", tableName: "s3asset_options")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-23") {
		addPrimaryKey(columnNames: "usuario_id, institucion_id", tableName: "usuario_instituciones")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-24") {
		addPrimaryKey(columnNames: "rol_id, usuario_id", constraintName: "usuario_rolPK", tableName: "usuario_rol")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-25") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "dependiente", constraintName: "FKCFA005D73AA07618", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-26") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "dependiente", constraintName: "FKCFA005D72AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-27") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_pagos_id", baseTableName: "dependiente_pago", constraintName: "FKF0EC2401A6C34CA1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-28") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "dependiente_pago", constraintName: "FKF0EC2401836F0678", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-29") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-30") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB89F4E613C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-31") {
		addForeignKeyConstraint(baseColumnNames: "distribucion_institucional_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB8CE969931", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "distribucion_institucional", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-32") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DA4A58C71C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-33") {
		addForeignKeyConstraint(baseColumnNames: "institucion_direcciones_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DA53AFD0FD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-34") {
		addForeignKeyConstraint(baseColumnNames: "institucion_telefonos_id", baseTableName: "institucion_telefono", constraintName: "FK5143770AFB39D8BC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-35") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "institucion_telefono", constraintName: "FK5143770A82EC8598", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-36") {
		addForeignKeyConstraint(baseColumnNames: "historial_academico_id", baseTableName: "pago", constraintName: "FK34629999E9EB39", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "historial_academico", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-37") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27D4A58C71C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-38") {
		addForeignKeyConstraint(baseColumnNames: "perfil_direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27DCED573C7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-39") {
		addForeignKeyConstraint(baseColumnNames: "perfil_telefonos_id", baseTableName: "perfil_telefono", constraintName: "FK88B67807F79D2698", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-40") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "perfil_telefono", constraintName: "FK88B6780782EC8598", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-41") {
		addForeignKeyConstraint(baseColumnNames: "options", baseTableName: "s3asset_options", constraintName: "FKE6010E2F42CEF82A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-42") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "usuario", constraintName: "FKF814F32E3AA07618", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-43") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-44") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E862AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-45") {
		addForeignKeyConstraint(baseColumnNames: "rol_id", baseTableName: "usuario_rol", constraintName: "FK3118953EF83C55FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rol", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-46") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_rol", constraintName: "FK3118953E2AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-47") {
		createIndex(indexName: "url_unique_1371500328492", tableName: "requestmap", unique: "true") {
			column(name: "url")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-48") {
		createIndex(indexName: "authority_unique_1371500328500", tableName: "rol", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-49") {
		createIndex(indexName: "idx_asset_status", tableName: "s3asset") {
			column(name: "aws_status")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-50") {
		createIndex(indexName: "option_name_idx", tableName: "s3asset_options") {
			column(name: "options_idx")
		}
	}

	changeSet(author: "sohjiro (generated)", id: "1371500328616-51") {
		createIndex(indexName: "username_unique_1371500328526", tableName: "usuario", unique: "true") {
			column(name: "username")
		}
	}
}
