require 'test_helper'

class AutoridadsControllerTest < ActionController::TestCase
  setup do
    @autoridad = autoridads(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:autoridads)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create autoridad" do
    assert_difference('Autoridad.count') do
      post :create, autoridad: { autoridad: @autoridad.autoridad }
    end

    assert_redirected_to autoridad_path(assigns(:autoridad))
  end

  test "should show autoridad" do
    get :show, id: @autoridad
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @autoridad
    assert_response :success
  end

  test "should update autoridad" do
    put :update, id: @autoridad, autoridad: { autoridad: @autoridad.autoridad }
    assert_redirected_to autoridad_path(assigns(:autoridad))
  end

  test "should destroy autoridad" do
    assert_difference('Autoridad.count', -1) do
      delete :destroy, id: @autoridad
    end

    assert_redirected_to autoridads_path
  end
end
