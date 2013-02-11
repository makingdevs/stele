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

require 'test_helper'

class TutorTest < ActiveSupport::TestCase
  # test "the truth" do
  #   assert true
  # end
end
