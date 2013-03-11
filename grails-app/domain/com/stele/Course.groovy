package com.stele

class Course {

  Institute institute
  Degree degree
  
  String bracket
  String year

  static belongsTo = Dependent
  static hasMany = [dependents : Dependent]

  Date dateCreated
  Date lastUpdated

  static constraints = {
    bracket size: 1..10
    year size: 1..2
  }
}
