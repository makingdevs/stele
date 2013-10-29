databaseChangeLog = {

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-1") { 
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-1") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-2") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-2") {
>>>>>>> feature/170
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

<<<<<<< HEAD
			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
=======
			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "organizacion_id", type: "bigint") {
>>>>>>> feature/170
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-3") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-3") {
>>>>>>> feature/170
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "dependiente") {
			column(name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "dependientePK")
			}

<<<<<<< HEAD
			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

=======
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-4") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "dependiente_pago") {
			column(name: "dependiente_pagos_id", type: "bigint")
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-4") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "descuento") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "descuentoPK")
			}
>>>>>>> feature/170

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

	changeSet(author: "synergyj (generated)", id: "1382377180282-5") {
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-5") {
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

	changeSet(author: "synergyj (generated)", id: "1381352462661-6") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-6") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-7") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-7") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-8") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-8") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-9") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-9") {
>>>>>>> feature/170
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "esquema_de_pago_descuento") {
			column(name: "esquema_de_pago_descuentos_id", type: "bigint")

			column(name: "descuento_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-10") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-10") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-11") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "institucion") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-11") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "organizacion") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-12") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "institucion_direccion") {
			column(name: "institucion_direcciones_id", type: "bigint")
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-12") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "organizacion_direccion") {
			column(name: "organizacion_direcciones_id", type: "bigint")
>>>>>>> feature/170

			column(name: "direccion_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-13") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "institucion_telefono") {
			column(name: "institucion_telefonos_id", type: "bigint")
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-13") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "organizacion_telefono") {
			column(name: "organizacion_telefonos_id", type: "bigint")
>>>>>>> feature/170

			column(name: "telefono_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-14") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-14") {
>>>>>>> feature/170
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

<<<<<<< HEAD
			column(name: "historial_academico_id", type: "bigint")

=======
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-15") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "pago_descuento") {
			column(name: "pago_descuentos_id", type: "bigint")

			column(name: "descuento_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-16") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-15") {
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

	changeSet(author: "synergyj (generated)", id: "1382377180282-16") {
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "payable_pago") {
			column(name: "payable_pagos_id", type: "bigint")

			column(name: "pago_id", type: "bigint")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-17") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-17") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-18") {
>>>>>>> feature/170
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id", type: "bigint")

			column(name: "direccion_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-18") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-19") {
>>>>>>> feature/170
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id", type: "bigint")

			column(name: "telefono_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-19") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-20") {
>>>>>>> feature/170
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

<<<<<<< HEAD
			column(name: "institucion_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
=======
			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "organizacion_id", type: "bigint") {
>>>>>>> feature/170
				constraints(nullable: "false")
			}

			column(name: "porcentaje", type: "decimal(19,2)")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-20") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-21") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-21") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-22") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-22") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-23") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-23") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-24") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-24") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-25") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-25") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-26") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-26") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-27") {
>>>>>>> feature/170
		sql("set storage_engine=InnoDB;")
		createTable(tableName: "usuario_instituciones") {
			column(name: "institucion_id", type: "bigint")

			column(name: "usuario_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-27") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-28") {
>>>>>>> feature/170
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

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-64") {
		createIndex(indexName: "FKDD3FD3078C0A9FFC", tableName: "concepto") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-65") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-63") {
		createIndex(indexName: "FKDD3FD3073E78BE13", tableName: "concepto") {
			column(name: "organizacion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-64") {
>>>>>>> feature/170
		createIndex(indexName: "FKCFA005D72AB2F39E", tableName: "dependiente") {
			column(name: "usuario_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-66") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-65") {
>>>>>>> feature/170
		createIndex(indexName: "FKCFA005D782201412", tableName: "dependiente") {
			column(name: "perfil_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-67") {
		createIndex(indexName: "FKF0EC2401836F0678", tableName: "dependiente_pago") {
			column(name: "pago_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-68") {
		createIndex(indexName: "FKF0EC2401A6C34CA1", tableName: "dependiente_pago") {
			column(name: "dependiente_pagos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-69") {
		createIndex(indexName: "FK598EC6E88C0A9FFC", tableName: "descuento") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-70") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-66") {
		createIndex(indexName: "FK598EC6E83E78BE13", tableName: "descuento") {
			column(name: "organizacion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-67") {
		createIndex(indexName: "FK6332753A3A058EF3", tableName: "descuento_aplicable") {
			column(name: "pago_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-68") {
		createIndex(indexName: "FK6332753AF2105881", tableName: "descuento_aplicable") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-69") {
>>>>>>> feature/170
		createIndex(indexName: "FK4B3D26CA8C0A9FFC", tableName: "distribucion_institucional") {
			column(name: "institucion_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-71") {
		createIndex(indexName: "FK8DEE0F7F5B63A0FC", tableName: "esquema_de_pago") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-70") {
		createIndex(indexName: "FK8DEE0F7F531802A1", tableName: "esquema_de_pago") {
>>>>>>> feature/170
			column(name: "recargo_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-72") {
		createIndex(indexName: "FK8DEE0F7F7EDC28B8", tableName: "esquema_de_pago") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-71") {
		createIndex(indexName: "FK8DEE0F7F7DB3FBB3", tableName: "esquema_de_pago") {
>>>>>>> feature/170
			column(name: "concepto_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-73") {
		createIndex(indexName: "FKC12BBE2815EDCC1C", tableName: "esquema_de_pago_descuento") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-74") {
		createIndex(indexName: "FKC12BBE2883FFBAB2", tableName: "esquema_de_pago_descuento") {
			column(name: "esquema_de_pago_descuentos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-75") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-72") {
		createIndex(indexName: "FKC12BBE28398B8C97", tableName: "esquema_de_pago_descuento") {
			column(name: "esquema_de_pago_descuentos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-73") {
		createIndex(indexName: "FKC12BBE28F2105881", tableName: "esquema_de_pago_descuento") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-74") {
>>>>>>> feature/170
		createIndex(indexName: "FK75CB2FB89F4E613C", tableName: "historial_academico") {
			column(name: "dependiente_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-76") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-75") {
>>>>>>> feature/170
		createIndex(indexName: "FK75CB2FB8CE969931", tableName: "historial_academico") {
			column(name: "distribucion_institucional_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-77") {
		createIndex(indexName: "FK6F9EC3DA53AFD0FD", tableName: "institucion_direccion") {
			column(name: "institucion_direcciones_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-78") {
		createIndex(indexName: "FK6F9EC3DAA649AEE2", tableName: "institucion_direccion") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-76") {
		createIndex(indexName: "FK126F2D955BBE1F94", tableName: "organizacion_direccion") {
			column(name: "organizacion_direcciones_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-77") {
		createIndex(indexName: "FK126F2D95A649AEE2", tableName: "organizacion_direccion") {
>>>>>>> feature/170
			column(name: "direccion_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-79") {
		createIndex(indexName: "FK5143770AE8FC8D12", tableName: "institucion_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-80") {
		createIndex(indexName: "FK5143770AFB39D8BC", tableName: "institucion_telefono") {
			column(name: "institucion_telefonos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-81") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-78") {
		createIndex(indexName: "FKC3169EFD364AC93", tableName: "organizacion_telefono") {
			column(name: "organizacion_telefonos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-79") {
		createIndex(indexName: "FKC3169EFE8FC8D12", tableName: "organizacion_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-80") {
>>>>>>> feature/170
		createIndex(indexName: "FK3462993F5C68BA", tableName: "pago") {
			column(name: "comprobante_de_pago_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-82") {
		createIndex(indexName: "FK3462995B63A0FC", tableName: "pago") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-81") {
		createIndex(indexName: "FK346299531802A1", tableName: "pago") {
>>>>>>> feature/170
			column(name: "recargo_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-83") {
		createIndex(indexName: "FK34629999E9EB39", tableName: "pago") {
			column(name: "historial_academico_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-84") {
		createIndex(indexName: "FKD92078C215EDCC1C", tableName: "pago_descuento") {
			column(name: "descuento_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-85") {
		createIndex(indexName: "FKD92078C2A257AA20", tableName: "pago_descuento") {
			column(name: "pago_descuentos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-86") {
		createIndex(indexName: "FK268BE27D165511C1", tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-87") {
		createIndex(indexName: "FK268BE27DA649AEE2", tableName: "perfil_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-88") {
		createIndex(indexName: "FK88B678073F1CC492", tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-89") {
		createIndex(indexName: "FK88B67807E8FC8D12", tableName: "perfil_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-90") {
		createIndex(indexName: "FK4080C1698C0A9FFC", tableName: "recargo") {
			column(name: "institucion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-91") {
		createIndex(indexName: "url_unique_1381352462564", tableName: "requestmap", unique: "true") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-82") {
		createIndex(indexName: "FK34215AB63A058EF3", tableName: "payable_pago") {
			column(name: "pago_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-83") {
		createIndex(indexName: "FK34215AB6D65FEFA6", tableName: "payable_pago") {
			column(name: "payable_pagos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-84") {
		createIndex(indexName: "FK268BE27D165511C1", tableName: "perfil_direccion") {
			column(name: "perfil_direccion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-85") {
		createIndex(indexName: "FK268BE27DA649AEE2", tableName: "perfil_direccion") {
			column(name: "direccion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-86") {
		createIndex(indexName: "FK88B678073F1CC492", tableName: "perfil_telefono") {
			column(name: "perfil_telefonos_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-87") {
		createIndex(indexName: "FK88B67807E8FC8D12", tableName: "perfil_telefono") {
			column(name: "telefono_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-88") {
		createIndex(indexName: "FK4080C1693E78BE13", tableName: "recargo") {
			column(name: "organizacion_id")
		}
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-89") {
		createIndex(indexName: "url_unique_1382377180085", tableName: "requestmap", unique: "true") {
>>>>>>> feature/170
			column(name: "url")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-92") {
		createIndex(indexName: "authority_unique_1381352462570", tableName: "rol", unique: "true") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-90") {
		createIndex(indexName: "authority_unique_1382377180091", tableName: "rol", unique: "true") {
>>>>>>> feature/170
			column(name: "authority")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-93") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-91") {
>>>>>>> feature/170
		createIndex(indexName: "idx_asset_status", tableName: "s3asset") {
			column(name: "aws_status")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-94") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-92") {
>>>>>>> feature/170
		createIndex(indexName: "FKE6010E2F42CEF82A", tableName: "s3asset_options") {
			column(name: "options")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-95") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-93") {
>>>>>>> feature/170
		createIndex(indexName: "option_name_idx", tableName: "s3asset_options") {
			column(name: "options_idx")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-96") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-94") {
>>>>>>> feature/170
		createIndex(indexName: "FKF814F32E82201412", tableName: "usuario") {
			column(name: "perfil_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-97") {
		createIndex(indexName: "username_unique_1381352462582", tableName: "usuario", unique: "true") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-95") {
		createIndex(indexName: "username_unique_1382377180103", tableName: "usuario", unique: "true") {
>>>>>>> feature/170
			column(name: "username")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-98") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-96") {
>>>>>>> feature/170
		createIndex(indexName: "FKF5FF5E862AB2F39E", tableName: "usuario_instituciones") {
			column(name: "usuario_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-99") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-97") {
>>>>>>> feature/170
		createIndex(indexName: "FKF5FF5E868C0A9FFC", tableName: "usuario_instituciones") {
			column(name: "institucion_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-100") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-98") {
>>>>>>> feature/170
		createIndex(indexName: "FK3118953E2AB2F39E", tableName: "usuario_rol") {
			column(name: "usuario_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-101") {
=======
	changeSet(author: "synergyj (generated)", id: "1382377180282-99") {
>>>>>>> feature/170
		createIndex(indexName: "FK3118953EF83C55FE", tableName: "usuario_rol") {
			column(name: "rol_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "synergyj (generated)", id: "1381352462661-28") {
		addPrimaryKey(columnNames: "options, options_idx", constraintName: "s3asset_optioPK", tableName: "s3asset_options")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-29") {
		addPrimaryKey(columnNames: "usuario_id, institucion_id", tableName: "usuario_instituciones")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-30") {
		addPrimaryKey(columnNames: "rol_id, usuario_id", constraintName: "usuario_rolPK", tableName: "usuario_rol")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-31") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "concepto", constraintName: "FKDD3FD3078C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-32") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "dependiente", constraintName: "FKCFA005D782201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-33") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "dependiente", constraintName: "FKCFA005D72AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-34") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_pagos_id", baseTableName: "dependiente_pago", constraintName: "FKF0EC2401A6C34CA1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-35") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "dependiente_pago", constraintName: "FKF0EC2401836F0678", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-36") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "descuento", constraintName: "FK598EC6E88C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-37") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-38") {
		addForeignKeyConstraint(baseColumnNames: "concepto_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F7EDC28B8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "concepto", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-39") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F5B63A0FC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-40") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE2815EDCC1C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-41") {
		addForeignKeyConstraint(baseColumnNames: "esquema_de_pago_descuentos_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE2883FFBAB2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "esquema_de_pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-42") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB89F4E613C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-43") {
		addForeignKeyConstraint(baseColumnNames: "distribucion_institucional_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB8CE969931", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "distribucion_institucional", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-44") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DAA649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-45") {
		addForeignKeyConstraint(baseColumnNames: "institucion_direcciones_id", baseTableName: "institucion_direccion", constraintName: "FK6F9EC3DA53AFD0FD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-46") {
		addForeignKeyConstraint(baseColumnNames: "institucion_telefonos_id", baseTableName: "institucion_telefono", constraintName: "FK5143770AFB39D8BC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-47") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "institucion_telefono", constraintName: "FK5143770AE8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-48") {
		addForeignKeyConstraint(baseColumnNames: "comprobante_de_pago_id", baseTableName: "pago", constraintName: "FK3462993F5C68BA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-49") {
		addForeignKeyConstraint(baseColumnNames: "historial_academico_id", baseTableName: "pago", constraintName: "FK34629999E9EB39", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "historial_academico", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-50") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "pago", constraintName: "FK3462995B63A0FC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-51") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "pago_descuento", constraintName: "FKD92078C215EDCC1C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-52") {
		addForeignKeyConstraint(baseColumnNames: "pago_descuentos_id", baseTableName: "pago_descuento", constraintName: "FKD92078C2A257AA20", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-53") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27DA649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-54") {
		addForeignKeyConstraint(baseColumnNames: "perfil_direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27D165511C1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-55") {
		addForeignKeyConstraint(baseColumnNames: "perfil_telefonos_id", baseTableName: "perfil_telefono", constraintName: "FK88B678073F1CC492", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-56") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "perfil_telefono", constraintName: "FK88B67807E8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-57") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "recargo", constraintName: "FK4080C1698C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-58") {
		addForeignKeyConstraint(baseColumnNames: "options", baseTableName: "s3asset_options", constraintName: "FKE6010E2F42CEF82A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-59") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "usuario", constraintName: "FKF814F32E82201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-60") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "institucion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-61") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E862AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-62") {
		addForeignKeyConstraint(baseColumnNames: "rol_id", baseTableName: "usuario_rol", constraintName: "FK3118953EF83C55FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rol", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1381352462661-63") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_rol", constraintName: "FK3118953E2AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	include file: 'cambios-faltantes.groovy'
=======

	changeSet(author: "synergyj (generated)", id: "1382377180282-29") {
		addPrimaryKey(columnNames: "options, options_idx", constraintName: "s3asset_optioPK", tableName: "s3asset_options")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-30") {
		addPrimaryKey(columnNames: "rol_id, usuario_id", constraintName: "usuario_rolPK", tableName: "usuario_rol")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-31") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "concepto", constraintName: "FKDD3FD3073E78BE13", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-32") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "dependiente", constraintName: "FKCFA005D782201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-33") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "dependiente", constraintName: "FKCFA005D72AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-34") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "descuento", constraintName: "FK598EC6E83E78BE13", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-35") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "descuento_aplicable", constraintName: "FK6332753AF2105881", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-36") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "descuento_aplicable", constraintName: "FK6332753A3A058EF3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-37") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "distribucion_institucional", constraintName: "FK4B3D26CA8C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-38") {
		addForeignKeyConstraint(baseColumnNames: "concepto_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F7DB3FBB3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "concepto", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-39") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "esquema_de_pago", constraintName: "FK8DEE0F7F531802A1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-40") {
		addForeignKeyConstraint(baseColumnNames: "descuento_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE28F2105881", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "descuento", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-41") {
		addForeignKeyConstraint(baseColumnNames: "esquema_de_pago_descuentos_id", baseTableName: "esquema_de_pago_descuento", constraintName: "FKC12BBE28398B8C97", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "esquema_de_pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-42") {
		addForeignKeyConstraint(baseColumnNames: "dependiente_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB89F4E613C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "dependiente", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-43") {
		addForeignKeyConstraint(baseColumnNames: "distribucion_institucional_id", baseTableName: "historial_academico", constraintName: "FK75CB2FB8CE969931", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "distribucion_institucional", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-44") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "organizacion_direccion", constraintName: "FK126F2D95A649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-45") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_direcciones_id", baseTableName: "organizacion_direccion", constraintName: "FK126F2D955BBE1F94", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-46") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_telefonos_id", baseTableName: "organizacion_telefono", constraintName: "FKC3169EFD364AC93", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-47") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "organizacion_telefono", constraintName: "FKC3169EFE8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-48") {
		addForeignKeyConstraint(baseColumnNames: "comprobante_de_pago_id", baseTableName: "pago", constraintName: "FK3462993F5C68BA", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-49") {
		addForeignKeyConstraint(baseColumnNames: "recargo_id", baseTableName: "pago", constraintName: "FK346299531802A1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recargo", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-50") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "payable_pago", constraintName: "FK34215AB63A058EF3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pago", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-51") {
		addForeignKeyConstraint(baseColumnNames: "payable_pagos_id", baseTableName: "payable_pago", constraintName: "FK34215AB6D65FEFA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payable", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-52") {
		addForeignKeyConstraint(baseColumnNames: "direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27DA649AEE2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "direccion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-53") {
		addForeignKeyConstraint(baseColumnNames: "perfil_direccion_id", baseTableName: "perfil_direccion", constraintName: "FK268BE27D165511C1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-54") {
		addForeignKeyConstraint(baseColumnNames: "perfil_telefonos_id", baseTableName: "perfil_telefono", constraintName: "FK88B678073F1CC492", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-55") {
		addForeignKeyConstraint(baseColumnNames: "telefono_id", baseTableName: "perfil_telefono", constraintName: "FK88B67807E8FC8D12", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telefono", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-56") {
		addForeignKeyConstraint(baseColumnNames: "organizacion_id", baseTableName: "recargo", constraintName: "FK4080C1693E78BE13", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-57") {
		addForeignKeyConstraint(baseColumnNames: "options", baseTableName: "s3asset_options", constraintName: "FKE6010E2F42CEF82A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "s3asset", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-58") {
		addForeignKeyConstraint(baseColumnNames: "perfil_id", baseTableName: "usuario", constraintName: "FKF814F32E82201412", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "perfil", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-59") {
		addForeignKeyConstraint(baseColumnNames: "institucion_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E868C0A9FFC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "organizacion", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-60") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_instituciones", constraintName: "FKF5FF5E862AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-61") {
		addForeignKeyConstraint(baseColumnNames: "rol_id", baseTableName: "usuario_rol", constraintName: "FK3118953EF83C55FE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "rol", referencesUniqueColumn: "false")
	}

	changeSet(author: "synergyj (generated)", id: "1382377180282-62") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_rol", constraintName: "FK3118953E2AB2F39E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", referencesUniqueColumn: "false")
	}

>>>>>>> feature/170
}


