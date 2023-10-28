package org.yesser.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.yesser.model.User;
import org.yesser.service.GenericServiceImpl;
import org.yesser.service.IGenericService;
import org.yesser.utils.Global;
import org.yesser.utils.HibernateUtil;

public class PrincipalController {
    public void ingresarAlSistema(ActionEvent actionEvent) {
        System.out.println("Ingresando al sistema");
        crearUsuario();
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
