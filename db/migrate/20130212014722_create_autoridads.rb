class CreateAutoridads < ActiveRecord::Migration
  def change
    create_table :autoridads do |t|
      t.string :autoridad

      t.timestamps
    end
  end
end
