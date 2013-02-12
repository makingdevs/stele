require 'test_helper'

class DependientesControllerTest < ActionController::TestCase
  setup do
    @dependiente = dependientes(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:dependientes)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create dependiente" do
    assert_difference('Dependiente.count') do
      post :create, dependiente: { perfil_id: @dependiente.perfil_id }
    end

    assert_redirected_to dependiente_path(assigns(:dependiente))
  end

  test "should show dependiente" do
    get :show, id: @dependiente
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @dependiente
    assert_response :success
  end

  test "should update dependiente" do
    put :update, id: @dependiente, dependiente: { perfil_id: @dependiente.perfil_id }
    assert_redirected_to dependiente_path(assigns(:dependiente))
  end

  test "should destroy dependiente" do
    assert_difference('Dependiente.count', -1) do
      delete :destroy, id: @dependiente
    end

    assert_redirected_to dependientes_path
  end
end
