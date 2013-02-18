class PerfilsController < ApplicationController

  respond_to :html

  def new
    @perfil = Perfil.new
    respond_with [usuario, @perfil]
  end

  def create
  end

  private
  
    def usuario
      Usuario.find(params[:usuario_id])
    end
end
