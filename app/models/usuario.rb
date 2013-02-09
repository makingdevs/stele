class Usuario < ActiveRecord::Base
  attr_accessible :email, :password
end
