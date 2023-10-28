package org.yesser.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.yesser.model.User;
import org.yesser.service.GenericServiceImpl;
import org.yesser.service.IGenericService;
import org.yesser.utils.Global;
import org.yesser.utils.HibernateUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
    @FXML
    TextField txtPassword;
    @FXML TextField txtUser;
    User usuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuario = new User();
        crearUsuario();
    }

    public void ingresarAlSistema(ActionEvent actionEvent) {
        if (txtUser.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al iniciar sesion");
            alert.setContentText("Por favor, complete todos los campos");
            alert.showAndWait();
        } else {
            System.out.println("Ingresando al sistema");
            String nickUser = txtUser.getText();
            String claveUser = txtPassword.getText();

            if (getUsuariobyNick(nickUser,claveUser)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("Inicio de sesion completado");
                alert.setContentText("Abriendo el sistema");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al iniciar sesion");
                alert.setContentText("Datos incorrectos");
                alert.showAndWait();
            }
        }
    }

    public boolean getUsuariobyNick(String nick, String password) {
        ObservableList<User> usuarios = Global.getUsuarios();
        for (User us : usuarios) {
            if (us.getNick().equals(nick) && us.getClave().equals(password)) {
                this.usuario = us;
                return true;
            }
        }
        return false;
    }

    public void mostrarInicio(ActionEvent actionEvent) {
    }

    public void crearUsuario() {
        try {
            ObservableList<User> usuarios = Global.getUsuarios();
            if (usuarios.isEmpty()) {
                User usuario = new User();
                usuario.setNombres("Yesser Joel");
                usuario.setApellidos("Miranda Guillen");
                usuario.setNick("yesser");
                usuario.setClave("123456");

                IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil
                        .getSessionFactory());
                usuarioService.save(usuario);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
