class DependientesController < ApplicationController

  respond_to :html

  def index
    @usuario = Usuario.find(params[:usuario_id])
    respond_with @usuario
  end

  def new
    @usuario = Usuario.find(params[:usuario_id])
    @perfil = Perfil.new
    respond_with @perfil
  end

  def create
    @usuario = Usuario.find(params[:usuario_id])
    redirect_to(usuario_dependientes_path(@usuario), :notice => "El perfil ha sido creado")
  end

end
