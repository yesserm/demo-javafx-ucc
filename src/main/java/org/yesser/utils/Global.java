package org.yesser.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.yesser.model.User;
import org.yesser.service.GenericServiceImpl;
import org.yesser.service.IGenericService;

public class Global {
    public static ObservableList<User> getUsuarios() {
        IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil
                .getSessionFactory());
        return FXCollections.observableArrayList(usuarioService.getAll());
    }
}
