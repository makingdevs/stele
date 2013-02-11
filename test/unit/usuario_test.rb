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

require 'test_helper'

class UsuarioTest < ActiveSupport::TestCase
  # test "the truth" do
  #   assert true
  # end
end
