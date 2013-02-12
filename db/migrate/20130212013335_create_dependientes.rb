class CreateDependientes < ActiveRecord::Migration
  def change
    create_table :dependientes do |t|
      t.integer :perfil_id

      t.timestamps
    end
  end
end
