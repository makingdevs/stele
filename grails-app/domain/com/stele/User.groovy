package com.stele

class User {

  String email
  String password

  Date dateCreated
  Date lastUpdated

  Profile profile

  static hasMany = [dependents : Dependent]

  static constraints = {
    email email: true, blank: false
    password password: true, blank: false, minSize: 6
    profile nullable: true
  }
}
