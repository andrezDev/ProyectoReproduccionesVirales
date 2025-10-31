public class Cuenta {

    private String username;
    private Usuario usuario;
    private String contrasenia;
    private String estado;
    private Stack subidos;
    private Queue vistos;

    public Cuenta(String username, Usuario usuario, String contrasenia) {
        this.username = username;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.subidos = new Stack();
        this.vistos = new Queue();
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Stack getSubidos() {
        return subidos;
    }

    public void setSubidos(Stack subidos) {
        this.subidos = subidos;
    }

    public Queue getVistos() {
        return vistos;
    }

    public void setVistos(Queue vistos) {
        this.vistos = vistos;
    }
}
