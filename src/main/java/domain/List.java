package domain;

public interface List {
    public int size() throws ListException; // Devuelve el número de elementos en la lista

    public void clear(); //Remueve todos los elementos de la lista

    public boolean isEmpty(); // true si la lista está vacía

    public boolean contains(Object element) throws ListException; //true si el elemento existe en la lista

    public void add(Object element); // inserta un elemento al final de la lista

    public void addFirst(Object element); //inserta un elemento al incio de la lista

    public void addLast(Object element); //inserta un elemento al final de la lista

    public void addInSortedList(Object element); // inserta un elemento a la lista en forma ordenada

    public void remove(Object element) throws ListException; //Suprime un elemento de la lista

    public Object removeFirst() throws ListException; //suprime y retorna el primer elemento de la lista

    public Object removeLast() throws ListException; //suprime y retorna el ultimo elemento de la lista

    public void sort() throws ListException; //ordena la lista

    public int indexOf(Object element) throws ListException; //devuelve la posicion del elemento en la lista

    public Object getFirst() throws ListException; //Devuelve el primer elemento de la lista

    public Object getLast() throws ListException; //Devuelve el último elemento de la lista

    public Object getPrev(Object element) throws ListException; //Devuelve el elemento anterior al actual en la lista

    public Object getNext(Object element) throws ListException; //Devuelve el elemento posterior al actual en la lista

    public Node getNode(int index) throws ListException; //Devuelve el nodo de la posicion indicada
}
