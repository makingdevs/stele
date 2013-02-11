# == Schema Information
#
# Table name: dato_personals
#
#  id                :integer          not null, primary key
#  nombre            :string(255)
#  apellidoPaterno   :string(255)
#  apellidoMaterno   :string(255)
#  fechaDeNacimiento :date
#  curp              :string(255)
#  genero            :string(255)
#  created_at        :datetime         not null
#  updated_at        :datetime         not null
#

class DatoPersonal < ActiveRecord::Base
  attr_accessible :apellidoMaterno, :apellidoPaterno, :curp, :fechaDeNacimiento, :genero, :nombre
end
