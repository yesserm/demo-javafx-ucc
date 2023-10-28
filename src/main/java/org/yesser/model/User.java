package org.yesser.model;

import javax.persistence.*;

@Entity
@Table(name = "userucc", schema = "ucc")
public class User extends Identificador{
    @Column(name = "nombres", length = 60)
    private String nombres;

    @Column(name = "apellidos", length = 60)
    private String apellidos;

    @Column(name = "nick", length = 20)
    private String nick;

    @Column(name = "clave", length = 100)
    private String clave;

    public User(){}

    public User(String nombres, String apellidos, String nick, String clave){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
        this.nick = nick;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombres + '\'' +
                ", nickusuario='" + nick + '\'' +
                ", password='" + clave + '\'' +
                '}';
    }
}
