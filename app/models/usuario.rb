# == Schema Information
#
# Table name: usuarios
#
#  id         :integer          not null, primary key
#  email      :string(255)
#  password   :string(255)
#  created_at :datetime         not null
#  updated_at :datetime         not null
#

class Usuario < ActiveRecord::Base
  attr_accessible :email, :password

  has_and_belongs_to_many :perfils
end
