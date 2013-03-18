package com.stele

class Dependent {

  Profile profile

  static belongsTo = User
  static hasMany = [courses : Course, users : User]
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    profile nullable: true
  }
}
