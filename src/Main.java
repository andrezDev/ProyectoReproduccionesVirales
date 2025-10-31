import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List cuentas = new List();
        Cuenta cuenta = null;

        String menu[] = {"Registrar cuenta", "Iniciar sesión", "Ingresar video", "Buscar video", "Reproducir video",
                "Ver reproducciones", "Cuenta de cobro", "Top 10 reproducciones", "Realizar sorteo", "Sugerencias",
                "Premios por reproducciones", "Otras", "Exit"};
        String[] estados = {"activo", "suspendido", "inactivo"};
        String[] tipos = {"musical", "academico", "pelicula", "publicitario", "otro"};

        String option, username, contrasenia, estado, nombre, id, descripcion, tipo,duracion;

        do {
            option = (String) JOptionPane.showInputDialog(null, "Seleccionar opción", "",
                    1, null, menu, menu[0]);
            switch (option) {

                case "Registrar cuenta" -> {

                    nombre = JOptionPane.showInputDialog("Ingresar nombre");
                    id = JOptionPane.showInputDialog("Ingresar id");
                    username = JOptionPane.showInputDialog("Ingresar username");

                    if (cuentas.verificarCuenta(username))
                        JOptionPane.showMessageDialog(null, "Cuenta existente");

                    contrasenia = JOptionPane.showInputDialog("Ingresar contraseña:");
                    Usuario usuario = new Usuario(nombre, id);
                    cuenta = new Cuenta(username, usuario, contrasenia);
                    cuentas.AddLast(cuenta);
                    JOptionPane.showMessageDialog(null, "Cuenta de " + nombre + " creada exitosamente");

                }

                case "Iniciar sesión" -> {

                    id = JOptionPane.showInputDialog("Ingresar id");
                    contrasenia = JOptionPane.showInputDialog("Ingresar contraseña:");

                     cuenta = cuentas.iniciarSesion(id, contrasenia);

                    if(cuenta != null)
                        JOptionPane.showMessageDialog(null, "Sesión iniciada");
                    else
                        JOptionPane.showMessageDialog(null, "Id o contraseña no válidos");
                }

                case "Ingresar video" -> {

                    if(cuenta == null) {
                        JOptionPane.showMessageDialog(null, "Iniciar sesión");
                    }

                    cuenta.incrementarContador();
                    int numConsecutivo = cuenta.getContador();
                    id = cuenta.getUsuario().getId() + String.format("%04d", numConsecutivo );
                    nombre = JOptionPane.showInputDialog("Ingresar nombre del video:");
                    descripcion = JOptionPane.showInputDialog("Descripción del video");
                    tipo = (String) JOptionPane.showInputDialog(null, "Seleccionar opción", "",
                            1, null, tipos, tipos[0]);
                    duracion = JOptionPane.showInputDialog("Duración del video:");

                    Video video = new Video(id,nombre,descripcion,tipo, duracion);
                    cuenta.getSubidos().push(video);
                    JOptionPane.showMessageDialog(null, "El vieo ha sido agregado exitosamente");


                }
            }

        }
        while (!option.equals("Exit"));








    }
}
