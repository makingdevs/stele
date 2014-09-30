databaseChangeLog = {

	changeSet(author: "makingdevs (generated)", id: "1385648898160-1") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-2") {
		sql("set storage_engine=InnoDB;")
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

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "organizacion_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-3") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "dependiente") {
			column(name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "dependientePK")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-4") {
		sql("set storage_engine=InnoDB;")
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

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "nombre_de_descuento", type: "varchar(150)") {
				constraints(nullable: "false")
			}

			column(name: "organizacion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "porcentaje", type: "decimal(19,2)")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-5") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "descuento_aplicable") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "descuento_aplPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "descuento_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "descuento_aplicable_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "fecha_de_expiracion", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "pago_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-6") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-7") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-8") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-9") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "esquema_de_pago_descuento") {
			column(name: "esquema_de_pago_descuentos_id", type: "bigint")

			column(name: "descuento_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-10") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-11") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "organizacion") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "organizacionPK")
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

			column(name: "class", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-12") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "organizacion_direccion") {
			column(name: "organizacion_direcciones_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-13") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "organizacion_telefono") {
			column(name: "organizacion_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-14") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-15") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "payable") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "payablePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-16") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "payable_pago") {
			column(name: "payable_pagos_id", type: "bigint")

			column(name: "pago_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-17") {
		sql("set storage_engine=InnoDB;")
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

			column(name: "avatar_id", type: "bigint")

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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-18") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-19") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-20") {
		sql("set storage_engine=InnoDB;")
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

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "organizacion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "porcentaje", type: "decimal(19,2)")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-21") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-22") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-23") {
		sql("set storage_engine=InnoDB;")
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

			column(name: "percent_transferred", type: "double(19,0)")

			column(name: "protocol", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "aws_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-24") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-25") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-26") {
		sql("set storage_engine=InnoDB;")
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

	changeSet(author: "makingdevs (generated)", id: "1385648898160-27") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "usuario_instituciones") {
			column(name: "institucion_id", type: "bigint")

			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-28") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "usuario_rol") {
			column(name: "rol_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-64") {
		createIndex(indexName: "FKDD3FD3073E78BE13", tableName: "concepto") {
			column(name: "organizacion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-65") {
		createIndex(indexName: "FKCFA005D72AB2F39E", tableName: "dependiente") {
			column(name: "usuario_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-66") {
		createIndex(indexName: "FKCFA005D782201412", tableName: "dependiente") {
			column(name: "perfil_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-67") {
		createIndex(indexName: "FK598EC6E83E78BE13", tableName: "descuento") {
			column(name: "organizacion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-68") {
		createIndex(indexName: "FK6332753A3A058EF3", tableName: "descuento_aplicable") {
			column(name: "pago_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-69") {
		createIndex(indexName: "FK6332753AF2105881", tableName: "descuento_aplicable") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-70") {
		createIndex(indexName: "FK4B3D26CA8C0A9FFC", tableName: "distribucion_institucional") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-71") {
		createIndex(indexName: "FK8DEE0F7F531802A1", tableName: "esquema_de_pago") {
			column(name: "recargo_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-72") {
		createIndex(indexName: "FK8DEE0F7F7DB3FBB3", tableName: "esquema_de_pago") {
			column(name: "concepto_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-73") {
		createIndex(indexName: "FKC12BBE28398B8C97", tableName: "esquema_de_pago_descuento") {
			column(name: "esquema_de_pago_descuentos_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-74") {
		createIndex(indexName: "FKC12BBE28F2105881", tableName: "esquema_de_pago_descuento") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-75") {
		createIndex(indexName: "FK75CB2FB89F4E613C", tableName: "historial_academico") {
			column(name: "dependiente_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-76") {
		createIndex(indexName: "FK75CB2FB8CE969931", tableName: "historial_academico") {
			column(name: "distribucion_institucional_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-77") {
		createIndex(indexName: "FK126F2D955BBE1F94", tableName: "organizacion_direccion") {
			column(name: "organizacion_direcciones_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-78") {
		createIndex(indexName: "FK126F2D95A649AEE2", tableName: "organizacion_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-79") {
		createIndex(indexName: "FKC3169EFD364AC93", tableName: "organizacion_telefono") {
			column(name: "organizacion_telefonos_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-80") {
		createIndex(indexName: "FKC3169EFE8FC8D12", tableName: "organizacion_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-81") {
		createIndex(indexName: "FK3462993F5C68BA", tableName: "pago") {
			column(name: "comprobante_de_pago_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-82") {
		createIndex(indexName: "FK346299531802A1", tableName: "pago") {
			column(name: "recargo_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-83") {
		createIndex(indexName: "FK34215AB63A058EF3", tableName: "payable_pago") {
			column(name: "pago_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-84") {
		createIndex(indexName: "FK34215AB6D65FEFA6", tableName: "payable_pago") {
			column(name: "payable_pagos_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-85") {
		createIndex(indexName: "FKC4E369CC73BBF74D", tableName: "perfil") {
			column(name: "avatar_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-86") {
		createIndex(indexName: "FK268BE27D165511C1", tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-87") {
		createIndex(indexName: "FK268BE27DA649AEE2", tableName: "perfil_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-88") {
		createIndex(indexName: "FK88B678073F1CC492", tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-89") {
		createIndex(indexName: "FK88B67807E8FC8D12", tableName: "perfil_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-90") {
		createIndex(indexName: "FK4080C1693E78BE13", tableName: "recargo") {
			column(name: "organizacion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-91") {
		createIndex(indexName: "url_unique_1385648898060", tableName: "requestmap", unique: "true") {
			column(name: "url")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-92") {
		createIndex(indexName: "authority_unique_1385648898067", tableName: "rol", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-93") {
		createIndex(indexName: "idx_asset_status", tableName: "s3asset") {
			column(name: "aws_status")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-94") {
		createIndex(indexName: "FKE6010E2F42CEF82A", tableName: "s3asset_options") {
			column(name: "options")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-95") {
		createIndex(indexName: "option_name_idx", tableName: "s3asset_options") {
			column(name: "options_idx")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-96") {
		createIndex(indexName: "FKF814F32E82201412", tableName: "usuario") {
			column(name: "perfil_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-97") {
		createIndex(indexName: "username_unique_1385648898077", tableName: "usuario", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-98") {
		createIndex(indexName: "FKF5FF5E862AB2F39E", tableName: "usuario_instituciones") {
			column(name: "usuario_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-99") {
		createIndex(indexName: "FKF5FF5E868C0A9FFC", tableName: "usuario_instituciones") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-100") {
		createIndex(indexName: "FK3118953E2AB2F39E", tableName: "usuario_rol") {
			column(name: "usuario_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-101") {
		createIndex(indexName: "FK3118953EF83C55FE", tableName: "usuario_rol") {
			column(name: "rol_id")
		}
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-29") {
		addPrimaryKey(columnNames: "options, options_idx", constraintName: "s3asset_optioPK", tableName: "s3asset_options")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-30") {
		addPrimaryKey(columnNames: "rol_id, usuario_id", constraintName: "usuario_rolPK", tableName: "usuario_rol")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-31") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "concepto", constraintName: "FKDD3FD3073E78BE13", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-32") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "dependiente", constraintName: "FKCFA005D782201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-33") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "dependiente", constraintName: "FKCFA005D72AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-34") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "descuento", constraintName: "FK598EC6E83E78BE13", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-35") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "descuento_aplicable", constraintName: "FK6332753AF2105881", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-36") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "descuento_aplicable", constraintName: "FK6332753A3A058EF3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-37") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-38") {
		addForeignKeyConstraint(baseColumnNames: "concepto_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F7DB3FBB3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "concepto", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-39") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F531802A1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-40") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE28F2105881", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-41") {
		addForeignKeyConstraint(baseColumnNames: "esquema_de_pago_descuentos_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE28398B8C97", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "esquema_de_pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-42") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB89F4E613C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-43") {
		addForeignKeyConstraint(baseColumnNames: "distribucion_institucional_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB8CE969931", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "distribucion_institucional", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-44") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "organizacion_direccion", constraintName: "FK126F2D95A649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-45") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_direcciones_id", baseTableName: "organizacion_direccion", constraintName: "FK126F2D955BBE1F94", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-46") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_telefonos_id", baseTableName: "organizacion_telefono", constraintName: "FKC3169EFD364AC93", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-47") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "organizacion_telefono", constraintName: "FKC3169EFE8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-48") {
		addForeignKeyConstraint(baseColumnNames: "comprobante_de_pago_id", baseTableName: "pago", constraintName: "FK3462993F5C68BA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-49") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "pago", constraintName: "FK346299531802A1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-50") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "payable_pago", constraintName: "FK34215AB63A058EF3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-51") {
		addForeignKeyConstraint(baseColumnNames: "payable_pagos_id", baseTableName: "payable_pago", constraintName: "FK34215AB6D65FEFA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payable", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-52") {
		addForeignKeyConstraint(baseColumnNames: "avatar_id", baseTableName: "perfil", constraintName: "FKC4E369CC73BBF74D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-53") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27DA649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-54") {
		addForeignKeyConstraint(baseColumnNames: "perfil_direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27D165511C1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-55") {
		addForeignKeyConstraint(baseColumnNames: "perfil_telefonos_id", baseTableName: "perfil_telefono", constraintName: "FK88B678073F1CC492", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-56") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "perfil_telefono", constraintName: "FK88B67807E8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-57") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "recargo", constraintName: "FK4080C1693E78BE13", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-58") {
		addForeignKeyConstraint(baseColumnNames: "options", baseTableName: "s3asset_options", constraintName: "FKE6010E2F42CEF82A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-59") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "usuario", constraintName: "FKF814F32E82201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-60") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-61") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E862AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-62") {
		addForeignKeyConstraint(baseColumnNames: "rol_id", baseTableName: "usuario_rol", constraintName: "FK3118953EF83C55FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rol", referencesUniqueColumn: "false")
	}

	changeSet(author: "makingdevs (generated)", id: "1385648898160-63") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_rol", constraintName: "FK3118953E2AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	include file: 'add-relation-account-transactionBanking.groovy'
  include file: 'agregando-referencia-pago.groovy'
  include file: 'agregando-payable-con-implements.groovy'
  include file: 'cambiando-extends-institucion.groovy'
  include file: 'agregando-foreign-keys.groovy'
  include file: 'agregando-autoincrement.groovy' 
}
