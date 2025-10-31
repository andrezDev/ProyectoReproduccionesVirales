public class Stack {

    private Node top;

    public Stack() {
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Object data) {
        if (isEmpty())
            top = new Node(data);
        else {
            Node n = new Node(data);
            n.setLink(top);
            top = n;
        }
    }

    public Object pop() {
        Object data = null;
        if(!isEmpty()) {
            data = top.getData();
            top = top.getLink();
        }
        return data;
    }
}
