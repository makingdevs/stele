# == Schema Information
#
# Table name: dependientes
#
#  id               :integer          not null, primary key
#  dato_personal_id :integer
#  created_at       :datetime         not null
#  updated_at       :datetime         not null
#

class Dependiente < ActiveRecord::Base
  attr_accessible :dato_personal_id

  belongs_to :datoPersonal
  has_and_belongs_to_many :tutors
end
