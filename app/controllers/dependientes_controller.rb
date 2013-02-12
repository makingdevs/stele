class DependientesController < ApplicationController
  # GET /dependientes
  # GET /dependientes.json
  def index
    @dependientes = Dependiente.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @dependientes }
    end
  end

  # GET /dependientes/1
  # GET /dependientes/1.json
  def show
    @dependiente = Dependiente.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @dependiente }
    end
  end

  # GET /dependientes/new
  # GET /dependientes/new.json
  def new
    @dependiente = Dependiente.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @dependiente }
    end
  end

  # GET /dependientes/1/edit
  def edit
    @dependiente = Dependiente.find(params[:id])
  end

  # POST /dependientes
  # POST /dependientes.json
  def create
    @dependiente = Dependiente.new(params[:dependiente])

    respond_to do |format|
      if @dependiente.save
        format.html { redirect_to @dependiente, notice: 'Dependiente was successfully created.' }
        format.json { render json: @dependiente, status: :created, location: @dependiente }
      else
        format.html { render action: "new" }
        format.json { render json: @dependiente.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /dependientes/1
  # PUT /dependientes/1.json
  def update
    @dependiente = Dependiente.find(params[:id])

    respond_to do |format|
      if @dependiente.update_attributes(params[:dependiente])
        format.html { redirect_to @dependiente, notice: 'Dependiente was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @dependiente.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /dependientes/1
  # DELETE /dependientes/1.json
  def destroy
    @dependiente = Dependiente.find(params[:id])
    @dependiente.destroy

    respond_to do |format|
      format.html { redirect_to dependientes_url }
      format.json { head :no_content }
    end
  end
end
