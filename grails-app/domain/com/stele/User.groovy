package com.stele

class User {

  String email
  String password

  Date dateCreated
  Date lastUpdated

  static belongsTo = [profile : Profile]

  static constraints = {
    email email: true, blank: false
    password password: true, blank: false, minSize: 6
  }
}
