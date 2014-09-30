databaseChangeLog = {

  changeSet(author: "gamaliel (generated)", id: "1412054998484-1") {
    sql("alter table historial_academico drop foreign key FK75CB2FB89F4E613C")
    sql("alter table dependiente MODIFY id BIGINT AUTO_INCREMENT")
    sql("alter table historial_academico add constraint FK75CB2FB89F4E613C foreign key(dependiente_id) references dependiente(id)")
  }

}
