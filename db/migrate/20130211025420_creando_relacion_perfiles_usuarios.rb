class CreandoRelacionPerfilesUsuarios < ActiveRecord::Migration
  def up
    create_table :perfils_usuarios, :id => false do |t|
      t.integer :usuario_id 
      t.integer :perfil_id 
    end
  end

  def down
    drop_table :perfils_usuarios
  end
end
