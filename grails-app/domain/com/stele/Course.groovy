package com.stele

class Course {

  Institute institute
  Degree degree
  
  String group
  String year

  static belongsTo = Dependent
  static hasMany = [dependents : Dependent]

  static constraints {
    group size: 1..10
    year: 1..2
  }

}
