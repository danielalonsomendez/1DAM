package ej2;


import java.io.Serializable;

class AccesoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String nombre;

    // ***** Constructor *****
    public AccesoUsuario() {
    }

    // ***** Getters & Setters *****
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ***** toString *****
    @Override
    public String toString() {
        return "AccesoUsuario [id=" + id + ", nombre=" + nombre + "]";
    }

    // ***** Métodos *****
    public boolean equals(Object object) {
        if (!(object instanceof AccesoUsuario)) {
            return false;
        }

        AccesoUsuario otroUsuario = (AccesoUsuario) object;
        if ((this.id == 0 && otroUsuario.id != 0) ||
            (this.id != 0 && this.id != otroUsuario.id)) {
            return false;
        }

        if ((this.nombre == null && otroUsuario.nombre != null) ||
            (this.nombre != null && !this.nombre.equals(otroUsuario.nombre))) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + (int) (id ^ (id >>> 32));
        hash = 31 * hash + (nombre == null ? 0 : nombre.hashCode());
        return hash;
    }
}
