class Autoridad < ActiveRecord::Base
  attr_accessible :autoridad

  has_and_belongs_to_many :usuarios
end
