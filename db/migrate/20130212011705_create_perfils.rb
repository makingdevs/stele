class CreatePerfils < ActiveRecord::Migration
  def change
    create_table :perfils do |t|
      t.string :nombre
      t.string :apellidoPaterno
      t.string :apellidoMaterno
      t.string :curp
      t.date :fechaDeNacimiento
      t.string :genero

      t.timestamps
    end
  end
end
