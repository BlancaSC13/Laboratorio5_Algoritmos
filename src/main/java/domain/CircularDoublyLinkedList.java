package domain;

public class CircularDoublyLinkedList implements List {
    private Node first; //apunta al inicio de la lista
    private Node last;

    public CircularDoublyLinkedList() {
        this.first = this.last = null;
    }

    @Override
    public int size() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int count = 0;
        while (aux != last) {
            count++;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return count;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        while (aux != last) {
            if (util.Utility.compare(aux.data, element) == 0) return true;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return false; //si llego aqui, el elemento no existe
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node aux = first; //apunta al primer nodo de la lista
            //necesito moverme por la lista hasta el final
            while (aux.next != last) {
                aux = aux.next;
            }
            //se sale del while cuando aux.next == null
            aux.next = newNode;
            //hago el doble enlace
            newNode.prev = aux;
            first.prev = newNode;
        }

    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first;
            //hago el doble enlace
            first.prev = newNode;
            first = newNode;
        }
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            //Cuando first.data es mayor que element
            if (util.Utility.compare(first.data, element) > 0) {
                newNode.next = first;
                //hago el doble enlace
                first.prev = newNode;
                first = newNode;
            } else {
                Node prev = first; //rastro o marca
                Node aux = first.next;
                boolean added = false;
                while (aux != last && !added) {
                    if (util.Utility.compare(aux.data, element) > 0) {
                        prev.next = newNode;
                        //hago el doble enlace
                        newNode.prev = prev;
                        newNode.next = aux;
                        aux.prev = newNode;
                        added = true;
                    }
                    prev = aux;
                    aux = aux.next;
                }
                //enlazamos el nodo al final de la lista
                if (!added) {
                    prev.next = newNode;
                    //hago el doble enlace
                    newNode.prev = prev;
                }
            }
        }
        //hago el enlace circular doble
        last.next = first;
        first.prev = last;
    }

    @Override
    public void remove(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Doubly Linked List is empty");
        }
        //Caso 1. El elemento a suprimir es el primero de la lista
        if (util.Utility.compare(first.data, element) == 0) {
            first = first.next;
            first.prev = null; //pq el anterior del 1er nodo quede apuntado a nulo
        } else {
            //Caso 2. El elemento puede estar en cualquier parte
            Node prev = first;
            Node aux = first.next;
            while (aux != null && !(util.Utility.compare(aux.data, element) == 0)) {
                prev = aux;
                aux = aux.next;
            }
            //se sale cuando alcanza nulo o cuando encuentra el elemento
            if (aux != null && util.Utility.compare(aux.data, element) == 0) {
                //desenlaza el nodo con el elemento a eliminar
                prev.next = aux.next;
                //mantengo el doble enlace
                if (aux.next != null)
                    aux.next.prev = prev;
            }
        }
        //mantengo el enlace circular
        last.next = first;
        first.prev = last;
        //ultima validacion
        //que pasa si solo queda un nodo y es el q queremos eliminar
        if (first == last && util.Utility.compare(first.data, element) == 0) {
            clear();
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Object element = first.data;
        first = first.next;
        //hago el enlace circular
        last.next = first;
        first.prev = last;
        return element;
    }

    @Override
    public Object removeLast() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        Node prev = first;
        while (aux.next != last) {
            prev = aux;
            aux = aux.next;
        }
        //aux esta en el ultimo nodo, es el q queremos eliminar
        Object element = aux.data;
        prev.next = first; //re-enlazamos el ult nodo
        first.prev = prev;
        return element;
    }

    @Override
    public void sort() throws ListException {
        if (isEmpty())
            throw new ListException("Circular Doubly Linked List is empty");
        for (int i = 1; i <= size(); i++) {
            for (int j = i + 1; j < size(); j++) {
                if (util.Utility.compare(getNode(j).data, getNode(i).data) < 0) {
                    Object aux = getNode(i).data;
                    getNode(i).data = getNode(j).data;
                    getNode(j).data = aux;
                }//if
            }//for j
        }//for i
    }

    @Override
    public int indexOf(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int index = 1;
        while (aux != last) {
            if (util.Utility.compare(aux.data, element) == 0) return index;
            index++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando estamos en el ult nodo
        if (util.Utility.compare(aux.data, element) == 0) return index;
        return -1; //significa que el elemento no existe
    }

    @Override
    public Object getFirst() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        return this.first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        return this.last.data;
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        if (util.Utility.compare(first.data, element) == 0) {
            return "It's the first, it has no prev";
        }
        Node aux = first;
        while (aux.next != last) {
            if (util.Utility.compare(aux.next.data, element) == 0) {
                return aux.data;
            }
            aux = aux.next; //muevo aux al sgte nodo
        }
        //se sale cuando aux == last
        if (util.Utility.compare(aux.data, element) == 0) {
            return aux.data;
        }
        return "Does not exist in Circular Doubly Linked List";
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        while (aux != last) {
            if (util.Utility.compare(aux.data, element) == 0) {
                if (aux.next != last) return aux.next.data;
                else return "Has no next";
            }
            aux = aux.next; //muevo aux al sgte nodo
        }
        return "Does not exist in Circular Doubly Linked List";
    }

    @Override
    public Node getNode(int index) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int i = 1;
        while (aux != last) {
            if (util.Utility.compare(i, index) == 0) return aux;
            i++;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return null; //si llega aqui, no encontro el nodo
    }

    @Override
    public String toString() {
        String result = "Circular Doubly Linked List Content\n";
        Node aux = first;
        while (aux != last) {
            result += aux.data + " ";
            aux = aux.next; //muevo aux al sgte nodo
        }
        return result;
    }
}
