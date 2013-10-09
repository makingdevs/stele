databaseChangeLog = {

	changeSet(author: "synergyj (generated)", id: "1381342844937-1") {
		createTable(tableName: "ciclo_escolar") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "ciclo_escolarPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "varchar(80)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "varchar(255)")

			column(name: "fecha_fin", type: "datetime")

			column(name: "fecha_inicio", type: "datetime")

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-2") {
		createTable(tableName: "concepto") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "conceptoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "varchar(150)") {
				constraints(nullable: "false")
			}

			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-3") {
		createTable(tableName: "dependiente") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "dependientePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "camada", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-4") {
		createTable(tableName: "dependiente_pago") {
			column(name: "dependiente_pagos_id", type: "bigint")

			column(name: "pago_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-5") {
		createTable(tableName: "descuento") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "descuentoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "cantidad", type: "decimal(19,2)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "dias_previos_para_cancelar_descuento", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "fecha_de_vencimiento", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "nombre_de_descuento", type: "varchar(150)") {
				constraints(nullable: "false")
			}

			column(name: "porcentaje", type: "decimal(19,2)")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-6") {
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

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "delegacion_municipio", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "estado", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-7") {
		createTable(tableName: "distribucion_institucional") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "distribucion_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
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

			column(name: "last_updated", type: "datetime") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-8") {
		createTable(tableName: "esquema_de_pago") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "esquema_de_paPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "cantidad_de_pago", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "concepto_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "recargo_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-9") {
		createTable(tableName: "esquema_de_pago_descuento") {
			column(name: "esquema_de_pago_descuentos_id", type: "bigint")

			column(name: "descuento_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-10") {
		createTable(tableName: "historial_academico") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "historial_acaPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "dependiente_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "distribucion_institucional_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-11") {
		createTable(tableName: "institucion") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "institucionPK")
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

			column(name: "nombre", type: "varchar(100)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-12") {
		createTable(tableName: "institucion_direccion") {
			column(name: "institucion_direcciones_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-13") {
		createTable(tableName: "institucion_telefono") {
			column(name: "institucion_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-14") {
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

			column(name: "comprobante_de_pago_id", type: "bigint")

			column(name: "concepto_de_pago", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "descuento_aplicable", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "estatus_de_pago", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "fecha_de_pago", type: "datetime")

			column(name: "fecha_de_vencimiento", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "historial_academico_id", type: "bigint")

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "recargo_id", type: "bigint")

			column(name: "recargos_acumulados", type: "decimal(19,2)") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-15") {
		createTable(tableName: "pago_descuento") {
			column(name: "pago_descuentos_id", type: "bigint")

			column(name: "descuento_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-16") {
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

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "fecha_de_nacimiento", type: "datetime")

			column(name: "last_updated", type: "datetime") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-17") {
		createTable(tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-18") {
		createTable(tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-19") {
		createTable(tableName: "recargo") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "recargoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "cantidad", type: "decimal(19,2)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "porcentaje", type: "decimal(19,2)")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-20") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-21") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-22") {
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

			column(name: "percent_transferred", type: "double precision(19)")

			column(name: "protocol", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "aws_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-23") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-24") {
		createTable(tableName: "telefono") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "telefonoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "extension", type: "varchar(6)")

			column(name: "lada", type: "varchar(255)")

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "numero_telefonico", type: "varchar(10)") {
				constraints(nullable: "false")
			}

			column(name: "principal", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "tipo_de_telefono", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-25") {
		createTable(tableName: "usuario") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuarioPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bit") {
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

	changeSet(author: "synergyj (generated)", id: "1381342844937-26") {
		createTable(tableName: "usuario_instituciones") {
			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-27") {
		createTable(tableName: "usuario_rol") {
			column(name: "rol_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-28") {
		addPrimaryKey(columnNames: "options, options_idx", constraintName: "s3asset_optioPK", tableName: "s3asset_options")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-29") {
		addPrimaryKey(columnNames: "usuario_id, institucion_id", tableName: "usuario_instituciones")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-30") {
		addPrimaryKey(columnNames: "rol_id, usuario_id", constraintName: "usuario_rolPK", tableName: "usuario_rol")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-31") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "concepto", constraintName: "FKDD3FD3078C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-32") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "dependiente", constraintName: "FKCFA005D782201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-33") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "dependiente", constraintName: "FKCFA005D72AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-34") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_pagos_id", baseTableName: "dependiente_pago", constraintName: "FKF0EC2401A6C34CA1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-35") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "dependiente_pago", constraintName: "FKF0EC2401836F0678", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-36") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "descuento", constraintName: "FK598EC6E88C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-37") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-38") {
		addForeignKeyConstraint(baseColumnNames: "concepto_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F7EDC28B8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "concepto", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-39") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F5B63A0FC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-40") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE2815EDCC1C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-41") {
		addForeignKeyConstraint(baseColumnNames: "esquema_de_pago_descuentos_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE2883FFBAB2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "esquema_de_pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-42") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB89F4E613C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-43") {
		addForeignKeyConstraint(baseColumnNames: "distribucion_institucional_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB8CE969931", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "distribucion_institucional", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-44") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DAA649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-45") {
		addForeignKeyConstraint(baseColumnNames: "institucion_direcciones_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DA53AFD0FD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-46") {
		addForeignKeyConstraint(baseColumnNames: "institucion_telefonos_id", baseTableName: "institucion_telefono", constraintName: "FK5143770AFB39D8BC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-47") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "institucion_telefono", constraintName: "FK5143770AE8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-48") {
		addForeignKeyConstraint(baseColumnNames: "comprobante_de_pago_id", baseTableName: "pago", constraintName: "FK3462993F5C68BA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-49") {
		addForeignKeyConstraint(baseColumnNames: "historial_academico_id", baseTableName: "pago", constraintName: "FK34629999E9EB39", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "historial_academico", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-50") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "pago", constraintName: "FK3462995B63A0FC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-51") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "pago_descuento", constraintName: "FKD92078C215EDCC1C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-52") {
		addForeignKeyConstraint(baseColumnNames: "pago_descuentos_id", baseTableName: "pago_descuento", constraintName: "FKD92078C2A257AA20", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-53") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27DA649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-54") {
		addForeignKeyConstraint(baseColumnNames: "perfil_direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27D165511C1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-55") {
		addForeignKeyConstraint(baseColumnNames: "perfil_telefonos_id", baseTableName: "perfil_telefono", constraintName: "FK88B678073F1CC492", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-56") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "perfil_telefono", constraintName: "FK88B67807E8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-57") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "recargo", constraintName: "FK4080C1698C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-58") {
		addForeignKeyConstraint(baseColumnNames: "options", baseTableName: "s3asset_options", constraintName: "FKE6010E2F42CEF82A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-59") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "usuario", constraintName: "FKF814F32E82201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-60") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-61") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E862AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-62") {
		addForeignKeyConstraint(baseColumnNames: "rol_id", baseTableName: "usuario_rol", constraintName: "FK3118953EF83C55FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rol", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-63") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_rol", constraintName: "FK3118953E2AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-64") {
		createIndex(indexName: "FKDD3FD3078C0A9FFC", tableName: "concepto") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-65") {
		createIndex(indexName: "FKCFA005D72AB2F39E", tableName: "dependiente") {
			column(name: "usuario_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-66") {
		createIndex(indexName: "FKCFA005D782201412", tableName: "dependiente") {
			column(name: "perfil_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-67") {
		createIndex(indexName: "FKF0EC2401836F0678", tableName: "dependiente_pago") {
			column(name: "pago_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-68") {
		createIndex(indexName: "FKF0EC2401A6C34CA1", tableName: "dependiente_pago") {
			column(name: "dependiente_pagos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-69") {
		createIndex(indexName: "FK598EC6E88C0A9FFC", tableName: "descuento") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-70") {
		createIndex(indexName: "FK4B3D26CA8C0A9FFC", tableName: "distribucion_institucional") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-71") {
		createIndex(indexName: "FK8DEE0F7F5B63A0FC", tableName: "esquema_de_pago") {
			column(name: "recargo_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-72") {
		createIndex(indexName: "FK8DEE0F7F7EDC28B8", tableName: "esquema_de_pago") {
			column(name: "concepto_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-73") {
		createIndex(indexName: "FKC12BBE2815EDCC1C", tableName: "esquema_de_pago_descuento") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-74") {
		createIndex(indexName: "FKC12BBE2883FFBAB2", tableName: "esquema_de_pago_descuento") {
			column(name: "esquema_de_pago_descuentos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-75") {
		createIndex(indexName: "FK75CB2FB89F4E613C", tableName: "historial_academico") {
			column(name: "dependiente_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-76") {
		createIndex(indexName: "FK75CB2FB8CE969931", tableName: "historial_academico") {
			column(name: "distribucion_institucional_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-77") {
		createIndex(indexName: "FK6F9EC3DA53AFD0FD", tableName: "institucion_direccion") {
			column(name: "institucion_direcciones_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-78") {
		createIndex(indexName: "FK6F9EC3DAA649AEE2", tableName: "institucion_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-79") {
		createIndex(indexName: "FK5143770AE8FC8D12", tableName: "institucion_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-80") {
		createIndex(indexName: "FK5143770AFB39D8BC", tableName: "institucion_telefono") {
			column(name: "institucion_telefonos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-81") {
		createIndex(indexName: "FK3462993F5C68BA", tableName: "pago") {
			column(name: "comprobante_de_pago_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-82") {
		createIndex(indexName: "FK3462995B63A0FC", tableName: "pago") {
			column(name: "recargo_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-83") {
		createIndex(indexName: "FK34629999E9EB39", tableName: "pago") {
			column(name: "historial_academico_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-84") {
		createIndex(indexName: "FKD92078C215EDCC1C", tableName: "pago_descuento") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-85") {
		createIndex(indexName: "FKD92078C2A257AA20", tableName: "pago_descuento") {
			column(name: "pago_descuentos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-86") {
		createIndex(indexName: "FK268BE27D165511C1", tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-87") {
		createIndex(indexName: "FK268BE27DA649AEE2", tableName: "perfil_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-88") {
		createIndex(indexName: "FK88B678073F1CC492", tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-89") {
		createIndex(indexName: "FK88B67807E8FC8D12", tableName: "perfil_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-90") {
		createIndex(indexName: "FK4080C1698C0A9FFC", tableName: "recargo") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-91") {
		createIndex(indexName: "url_unique_1381342844875", tableName: "requestmap", unique: "true") {
			column(name: "url")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-92") {
		createIndex(indexName: "authority_unique_1381342844878", tableName: "rol", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-93") {
		createIndex(indexName: "idx_asset_status", tableName: "s3asset") {
			column(name: "aws_status")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-94") {
		createIndex(indexName: "FKE6010E2F42CEF82A", tableName: "s3asset_options") {
			column(name: "options")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-95") {
		createIndex(indexName: "option_name_idx", tableName: "s3asset_options") {
			column(name: "options_idx")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-96") {
		createIndex(indexName: "FKF814F32E82201412", tableName: "usuario") {
			column(name: "perfil_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-97") {
		createIndex(indexName: "username_unique_1381342844887", tableName: "usuario", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-98") {
		createIndex(indexName: "FKF5FF5E862AB2F39E", tableName: "usuario_instituciones") {
			column(name: "usuario_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-99") {
		createIndex(indexName: "FKF5FF5E868C0A9FFC", tableName: "usuario_instituciones") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-100") {
		createIndex(indexName: "FK3118953E2AB2F39E", tableName: "usuario_rol") {
			column(name: "usuario_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381342844937-101") {
		createIndex(indexName: "FK3118953EF83C55FE", tableName: "usuario_rol") {
			column(name: "rol_id")
		}
	}
}
