import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
public class Main
{
    public static void main(String[] args)
    {
        Map<Integer, String> m = new TreeMap<Integer, String>();
        Set s1, s2;
        Collection c;
        Iterator it1, it2, it3;
        m.put(new Integer(1), "one");
        m.put(new Integer(2), "too");
        m.put(new Integer(2), "two");
        m.put(new Integer(3), "three");
        m.put(new Integer(4), "four");
        m.put(new Integer(5), "five");
        s1 = m.entrySet(); // Set of Map.Entry - keys and values
        it1 = s1.iterator();
        while (it1.hasNext())
            System.out.println(it1.next());
// prints key and value
        s2 = m.keySet(); // Set of Integer keys
        it2 = s2.iterator();
        while (it2.hasNext())
            System.out.println(it2.next()); // prints Integer key
        c = m.values(); // Collection of String values
        it3 = c.iterator();
        while (it3.hasNext())
            System.out.println(it3.next()); // prints String values
    }
}