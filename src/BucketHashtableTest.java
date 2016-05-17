/**
 * Created by Magdalena Polak on 10.05.2016.
 */
public class BucketHashtableTest  {
    protected Hashtable createTable(int capacity){
        return new BucketHashtable(capacity,0.75f);
    }
    public static void main (String []args)
    {
        BucketHashtableTest b = new BucketHashtableTest();
        Hashtable h = b.createTable(10);
        h.add(1, "ELVIS");
        h.add(2, "LEVIS");
        h.add(5, "BLA");
        h.add(7, "NICC");
        h.add(4 ,"CINC");
        h.add(9, "TAK");
        h.add(9, "nie");
        h.add(45, "cokolwiek");
        h.add(18, "nednkjd");
        System.out.println(h.contains(5));
        System.out.println(h.get(5));
        h.dump();
        System.out.println();


    }

};
