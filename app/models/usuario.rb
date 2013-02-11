class Usuario < ActiveRecord::Base
  attr_accessible :email, :password

  has_and_belongs_to_many :perfils
end
