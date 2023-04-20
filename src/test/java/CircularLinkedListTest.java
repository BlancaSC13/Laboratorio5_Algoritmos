
import domain.CircularLinkedList;
import domain.Employee;
import org.testng.annotations.Test;

import java.util.Calendar;

public class CircularLinkedListTest {
    @Test
    public void test1(){
        CircularLinkedList list = new CircularLinkedList();
        Calendar calendar = Calendar.getInstance();

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Castillo","Camilo","Informática", calendar.getTime()));
        System.out.println("Primer dato"+list.toString());


        calendar.set(2003,4,19);
        list.add(new Employee(1,"Rojas","Sofía","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Calderón","Mariana","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Perez","Ericka","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Murillo","Daniel","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Villagra","Mauricio","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Campos","Carlos","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Chaves","Johana","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Granados","Fiorella","Informática", calendar.getTime()));

        calendar.set(2003,4,19);
        list.add(new Employee(1,"Coto","María","Informática", calendar.getTime()));

        }
}
