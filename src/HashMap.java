import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Magdalena Polak on 11.05.2016.
 */
public class HashMap {
    private  int TABLE_SIZE = 10;
    private int SIZE = 0;
    HashEntry[] table;

    HashMap() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public String get(int key) {
        String s;
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return "Pusta";
        else
            s = table[hash].getValue();
            return s ;
    }
    public String get2(int key) {
        String s;
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return "Pusta";
        else
            s = table[hash].getValue();
               return s ;
    }
    public HashEntry getI(int key) {
        HashEntry h;
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
        { hash = (hash + 1) % TABLE_SIZE;}
                return table[hash];
    }
    public HashEntry getI2(int key) {
        HashEntry h;
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;

        h = table[hash];
        return h ;
    }
    public boolean contains(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return false  ;
        else
            return true;
    }
    public boolean contains2(int key) {
        int hash = ((key  + 5*(key+7)) % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return false  ;
        else
            return true;
    }
    public int size()
    {
        return SIZE;
    }
    public boolean empty()
    {
        return SIZE==0;
    }
    public void resize()
    {
        int newSize = isPrime(TABLE_SIZE*2);
        HashEntry [] tableCopy = new HashEntry[newSize];
        int key;
        String value;
        SIZE =0;
        for(int i = 0; i<TABLE_SIZE; i++) {
            HashEntry e = table[i];
            if (e != null) {
                key = e.getKey();
                value = e.getValue();
                int hash = (key % newSize);
                while (tableCopy[hash] != null && tableCopy[hash].getKey() != key)
                    hash = (hash + 1) % newSize;
                tableCopy[hash] = new HashEntry(key, value);
                SIZE++;
            }
        }
        TABLE_SIZE = newSize;
        table = new HashEntry[newSize];
        table = tableCopy;

    }
    public void resize2()    {
        int newSize = isPrime(TABLE_SIZE*2);
        HashEntry [] tableCopy = new HashEntry[newSize];
        int key;
        String value;
        SIZE =0;
        TABLE_SIZE = newSize;
        for(int i = 0; i<TABLE_SIZE; i++)
        {
            HashEntry e = getI(i);
            key = e.getKey();
            value = e.getValue();
            if(e !=null) {
                int hash = ((key + 5 * (key + 7)) % TABLE_SIZE);
                while (tableCopy[hash] != null && tableCopy[hash].getKey() != key)
                    hash = (hash + 1) % TABLE_SIZE;
                table[hash] = new HashEntry(key, value);
                SIZE++;
            }
        }
        table = new HashEntry[TABLE_SIZE];
        table = tableCopy;

    }

    public void put(int key, String value) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new HashEntry(key, value);
        SIZE++;
        if(SIZE>=0.75*TABLE_SIZE)
        {
            resize();
        }
    }
    public void put2(int key, String value) {
        int hash = ((key  + 5*(key+7)) % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new HashEntry(key, value);
        SIZE++;
        if(SIZE>=0.75*TABLE_SIZE)
        {
            resize();
        }
    }
    public void dump()    {
        for(int i = 0; i<TABLE_SIZE; i++)
        {

                System.out.println(table[i]);

        }

    }
    int isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
               n++;
        }
        return n;
    }
    public static void main (String[]args)
    {

        HashMap hashMap = new HashMap();
        hashMap.put(6, "Cos");
        hashMap.put(45, "String");
        hashMap.put(98, "Hashmap");
        hashMap.put(47, "String");
        hashMap.put(95, "Hashmap");
        hashMap.put(40, "String");
        hashMap.put(91, "Hashmap");
        hashMap.dump();
        hashMap.put(99, "Hashmap");
        System.out.println("Break");
        hashMap.dump();
      //  System.out.println(hashMap.get(9));
       System.out.println(hashMap.contains(6));
      /*   System.out.println(hashMap.size());
        System.out.println(hashMap.empty());
        System.out.println(hashMap.isPrime(70));    */

/*
        hashMap.put2(6, "Cos");
        hashMap.put2(9, "Nic");
        hashMap.put2(45, "String");
        hashMap.put2(98, "Hashmap");
        System.out.println(hashMap.get2(9));
        System.out.println(hashMap.contains2(6));
        System.out.println(hashMap.size());
        System.out.println(hashMap.empty());
        hashMap.dump();
        */
    }

}