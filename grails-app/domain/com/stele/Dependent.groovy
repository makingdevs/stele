package com.stele

class Dependent {

  Profile profile

  static hasMany = [courses : Course]

  static constraints = {
    profile nullable: true
  }
}
