public class List {

    private Node head;

    //Método constructor: inicializa la lista como vacía
    public List() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    //Método que verifica si la lista está vacía
    public boolean isEmpty() {
        return head == null;
    }

    //Método que agrega un nodo al inicio de la lista
    public void AddFirst(Object data) {
        if(isEmpty()){
            //Si la lista está vacía, se crea el primer nodo
            head = new Node(data);
        }
        else {
            //Si ya existen nodos, el nuevo nodo apunta al nodo actual y se convierte en la nueva cabeza
            Node n = new Node(data);
            n.setLink(head);
            head = n;
        }
    }

    //Método que convierte la lista en una cadena para mostrar su contenido
    @Override
    public String toString() {
        String text = "";
        Node aux = head;

        //Recorre cada nodo de la lista concatenando los datos
        while(aux != null) {
            text = text + aux.getData() + "\n";
            aux = aux.getLink();
        }
        return text;
    }

    //Método que devuelve el último nodo de la lista
    public Node Last() {
        Node aux = head, last = null;

        //Recorre hasta el último nodo
        while(aux != null) {
            last = aux;
            aux = aux.getLink();
        }
        return last;
    }

    // Método para agregar nodo al final de la lista
    public void AddLast(Object data){
        if(isEmpty())
            //Si está vacía, el nuevo nodo es la cabeza
            head = new Node(data);
        else
            //Si no, el último nodo apunta al nuevo nodo
            Last().setLink(new Node(data));
    }

    //Método que cuenta la cantidad de nodos en la lista
    public int Size() {
        int cont = 0;
        Node aux = head;

        //Recorre la lista incrementando el contador
        while(aux != null) {
            cont ++;
            aux = aux.getLink();
        }
        return cont;
    }

    //Método que busca al nodo anterior
    public Node Previous(Node search) {
        Node aux = head, pre = null;

        //Recorre hasta encontrar el nodo buscado, guardando el nodo anterior
        while(aux != null && aux != search) {
            pre = aux;
            aux = aux.getLink();
        }
        return pre;
    }

    //Método que inserta un nodo en una posición específica de la lista
    public void AddPosition(Object data, int position) {

        if(position == 1) {
            //Si la posición es 1, se agrega al inicio
            AddFirst(data);
        }
        else {
            if(position == Size() + 1)
                //Si la posición es la siguiente al último, se agrega al final
                AddLast(data);
            else {
                //Si es una posición intermedia, se recorre hasta llegar a esa posición
                int count = 1;
                Node aux = head;
                while(aux != null && count < position) {
                    count ++;
                    aux = aux.getLink();
                }

                //Se crea el nuevo nodo y se inserta entre el nodo anterior y el actual
                Node n = new Node(data);
                n.setLink(aux);
                Previous(aux).setLink(n);
            }

        }

    }

    public boolean DeleteFirst() {
        if(!isEmpty()) {
            head = head.getLink();
            return true;
        }
        return false;
    }

    public boolean DeleteLast() {
        if(!isEmpty()){
            Node last = Last();
            Node pre = Previous(last);
            if(pre != null){
                pre.setLink(null);
            }
            else {
                head = null;
            }
            return true;
        }
        return false;
    }

    public boolean DeletePosition(int position) {
        if(!isEmpty()) {
            if(position == 1)
                return DeleteFirst();
            else {
                if(position == Size())
                    return DeleteLast();
                else {
                    int count = 1;
                    Node aux = head;
                    while(aux != null && count < position){
                        count ++;
                        aux = aux.getLink();
                    }
                    Node pre = Previous(aux);
                    pre.setLink(aux.getLink());
                    return true;
                }
            }

        }
        return false;
    }
    public boolean verificarCuenta(String username) {
        Node aux = head;
        while (aux != null) {
            Cuenta cuenta = (Cuenta) aux.getData();
            if (cuenta.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
            aux = aux.getLink();
        }
        return false;
    }

    public Cuenta iniciarSesion(String id, String contrasenia) {
        Node aux = head;
        while (aux != null) {
            Cuenta cuenta = (Cuenta) aux.getData();
            if (cuenta.getUsuario().getId().equalsIgnoreCase(id) &&
                    cuenta.getContrasenia().equalsIgnoreCase(contrasenia)) {
                return cuenta;
            }
            aux = aux.getLink();
        }
        return null;
    }

}
