package domain;

public class Node {
    public Object data;
    //Node porque es del tipo de la clase, funcionando como apuntador
    public Node prev; //apuntador al nodo anterior
    public Node next; //apuntador al sgte nodo

    public Node() {
        this.prev = this.next = null;
        this.data = null;
    }

    //Constructor
    public Node(Object data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
