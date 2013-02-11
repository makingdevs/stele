class CreateDatoPersonals < ActiveRecord::Migration
  def change
    create_table :dato_personals do |t|
      t.string :nombre
      t.string :apellidoPaterno
      t.string :apellidoMaterno
      t.date :fechaDeNacimiento
      t.string :curp
      t.string :genero

      t.timestamps
    end
  end
end
