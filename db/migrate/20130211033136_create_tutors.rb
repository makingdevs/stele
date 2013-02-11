class CreateTutors < ActiveRecord::Migration
  def change
    create_table :tutors do |t|
      t.string :rfc
      t.integer :dato_personal_id
      t.integer :usuario_id

      t.timestamps
    end
  end
end
