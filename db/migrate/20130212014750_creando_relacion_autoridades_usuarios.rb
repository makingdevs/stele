class CreandoRelacionAutoridadesUsuarios < ActiveRecord::Migration
  def up
    create_table :autoridads_usuarios, :id => false do |t|
      t.integer :autoridad_id
      t.integer :usuario_id
    end
  end

  def down
    drop_table :autoridads_usuarios
  end
end
