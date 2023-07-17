
package Modelo;

public class Empleado {
    int id;
    String password;
    String nom;
    String tel;
    String estado;
    String user;

    public Empleado() {
    }

    public Empleado(int id, String password, String nom, String tlf, String estado, String user) {
        this.id = id;
        this.password = password;
        this.nom = nom;
        this.tel = tlf;
        this.estado = estado;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTlf() {
        return tel;
    }

    public void setTlf(String tlf) {
        this.tel = tlf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}

