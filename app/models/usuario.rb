class Usuario < ActiveRecord::Base
  attr_accessible :email, :password
  # attr_accessible :title, :body
end
