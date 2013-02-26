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
    usuario = Usuario.find(params[:usuario_id])

    perfil = Perfil.new(params[:perfil])
    perfil_was_successful = perfil.save

    if perfil_was_successful
      dependiente = Dependiente.new
      dependiente.perfil = perfil
      dependiente.usuarios << usuario
      dependiente.save
      redirect_to(usuario_dependientes_path(usuario), :notice => "El dependiente ha sido agregado")
    else
      render 'new'
    end
  end

end
