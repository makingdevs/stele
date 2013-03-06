package com.stele

class User {

  String email
  String password

  static constraints = {
    email email: true, blank: false
    password password: true, blank: false, minSize: 6
  }
}
