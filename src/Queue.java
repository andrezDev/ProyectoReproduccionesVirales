public class Queue {

    private Node first;
    private Node last;

    public Queue() {
    }

    //Método para saber si está vacío
    public boolean isEmpty() {

        return first == null && last == null;
    }

    //Método para encolar
    public void enqueue(Object data) {
        if(isEmpty()) {
            first = new Node(data);
            last = first;
        }
        else {
            Node n = new Node(data);
            last.setLink(n);
            last = n;
        }
    }

    //Método para desencolar
    public Object dequeue() {

        Object data = null;
        if(!isEmpty()) {
            data = first.getData();
            first = first.getLink();
            if(first == null)
                last = null;
        }
        return data;
    }

}
