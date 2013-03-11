package com.stele

class Dependent {

  Profile profile

  static hasMany = [courses : Course]
  
  Date dateCreated
  Date lastUpdated

  static constraints = {
    profile nullable: true
  }
}
