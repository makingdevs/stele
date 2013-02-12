class AutoridadsController < ApplicationController
  # GET /autoridads
  # GET /autoridads.json
  def index
    @autoridads = Autoridad.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @autoridads }
    end
  end

  # GET /autoridads/1
  # GET /autoridads/1.json
  def show
    @autoridad = Autoridad.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @autoridad }
    end
  end

  # GET /autoridads/new
  # GET /autoridads/new.json
  def new
    @autoridad = Autoridad.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @autoridad }
    end
  end

  # GET /autoridads/1/edit
  def edit
    @autoridad = Autoridad.find(params[:id])
  end

  # POST /autoridads
  # POST /autoridads.json
  def create
    @autoridad = Autoridad.new(params[:autoridad])

    respond_to do |format|
      if @autoridad.save
        format.html { redirect_to @autoridad, notice: 'Autoridad was successfully created.' }
        format.json { render json: @autoridad, status: :created, location: @autoridad }
      else
        format.html { render action: "new" }
        format.json { render json: @autoridad.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /autoridads/1
  # PUT /autoridads/1.json
  def update
    @autoridad = Autoridad.find(params[:id])

    respond_to do |format|
      if @autoridad.update_attributes(params[:autoridad])
        format.html { redirect_to @autoridad, notice: 'Autoridad was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @autoridad.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /autoridads/1
  # DELETE /autoridads/1.json
  def destroy
    @autoridad = Autoridad.find(params[:id])
    @autoridad.destroy

    respond_to do |format|
      format.html { redirect_to autoridads_url }
      format.json { head :no_content }
    end
  end
end
