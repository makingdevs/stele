class Dependiente < ActiveRecord::Base
  attr_accessible :dato_personal_id

  belongs_to :datoPersonal
  has_and_belongs_to_many :tutors
end
