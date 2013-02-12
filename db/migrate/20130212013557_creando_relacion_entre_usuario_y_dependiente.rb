class CreandoRelacionEntreUsuarioYDependiente < ActiveRecord::Migration
  def up
    create_table :dependientes_usuarios, :id => false do |t|
      t.integer :dependiente_id
      t.integer :usuario_id
    end
  end

  def down
    drop_table :dependientes_usuarios
  end
end
