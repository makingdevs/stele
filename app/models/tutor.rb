class Tutor < ActiveRecord::Base
  attr_accessible :dato_personal_id, :rfc, :usuario_id

  belongs_to :datoPersonal
  belongs_to :usuario

end
