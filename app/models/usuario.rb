class Usuario < ActiveRecord::Base
  attr_accessible :email, :password
  
  has_many :perfiles
end
