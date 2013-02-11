# == Schema Information
#
# Table name: perfils
#
#  id         :integer          not null, primary key
#  perfil     :string(255)
#  created_at :datetime         not null
#  updated_at :datetime         not null
#

class Perfil < ActiveRecord::Base
  attr_accessible :perfil

  has_and_belongs_to_many :usuarios
end
