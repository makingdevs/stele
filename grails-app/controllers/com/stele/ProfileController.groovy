package com.stele

class ProfileController {

  def scaffold = Profile

  def savingUserProfile() {
    Profile profile = new Profile(params)
    profile.save()
    
    User user = User.get(params.userId)
    user.profile = profile
    user.save()
    user
  }

}
