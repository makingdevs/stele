class CreatePerfils < ActiveRecord::Migration
  def change
    create_table :perfils do |t|
      t.string :perfil

      t.timestamps
    end
  end
end
