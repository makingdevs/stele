class CreandoRelacionDependienteTutores < ActiveRecord::Migration
  def up
    create_table :dependientes_tutors, :id => false do |t|
      t.integer :dependiente_id 
      t.integer :tutor_id
    end
  end

  def down
    drop_table :dependientes_tutors
  end
end
