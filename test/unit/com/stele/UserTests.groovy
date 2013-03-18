package com.stele

import grails.test.mixin.*
import org.junit.*

@TestFor(User)
class UserTests extends groovy.util.GroovyTestCase {

  void testConstraints() {
    def userConstraints = new User()

    assert !userConstraints.validate()
    assert userConstraints.errors.allErrors*.code == ["nullable"] * 2
  }

}
