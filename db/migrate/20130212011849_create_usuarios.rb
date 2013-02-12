class CreateUsuarios < ActiveRecord::Migration
  def change
    create_table :usuarios do |t|
      t.string :email
      t.string :password
      t.integer :perfil_id

      t.timestamps
    end
  end
end
