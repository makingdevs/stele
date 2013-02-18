class PerfilsController < ApplicationController

  respond_to :html

  def new
    @perfil = Perfil.new
    @perfil.usuario = usuario
    respond_with [usuario, @perfil]
  end

  def create
    @perfil = Perfil.new(params[:perfil])
    new_was_successful = @perfil.save

    respond_with [usuario, @perfil] do |format|
      format.html {
        if new_was_successful
          redirect_to(usuario_path(usuario), :notice => "El perfil ha sido creado")
        else
          render 'new'
        end
      }
    end
  end

  private
  
    def usuario
      Usuario.find(params[:usuario_id])
    end
end
