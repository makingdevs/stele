# == Schema Information
#
# Table name: tutors
#
#  id               :integer          not null, primary key
#  rfc              :string(255)
#  dato_personal_id :integer
#  usuario_id       :integer
#  created_at       :datetime         not null
#  updated_at       :datetime         not null
#

class Tutor < ActiveRecord::Base
  attr_accessible :dato_personal_id, :rfc, :usuario_id

  belongs_to :datoPersonal
  belongs_to :usuario

  has_and_belongs_to_many :dependientes
end
