import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Magdalena Polak on 10.05.2016.
 */
public class BucketHashtable implements Hashtable {

    private final float _loadFactor;
    private List[] _buckets;

    public BucketHashtable(int initialCapacity, float loadFactor) {
        assert initialCapacity > 0 : "poczatkowa wielkosc porcji musi byc dodatnia";
        assert loadFactor > 0 : ">0";
        _loadFactor = loadFactor;
        _buckets = new List[initialCapacity];
    }
    public void add(int key, String value) {
        List bucket = bucketFor(key);
        if (!bucket.contains(key)) {
            bucket.add(new HashEntry(key, value));
            maintainLoad();
            //System.out.println("added: " + value);
        }
    }
    public boolean contains(Object value) {
        List bucket = _buckets[bucketIndexFor(value)];
              return bucket != null ; //&& bucket.contains(value)
    }
    public int size() {
        int size = 0;
        for (int i = 0; i < _buckets.length; ++i) {
            if (_buckets[i] != null) {
                size += _buckets[i].size();
            }
        }
        return size;
    }
    private List bucketFor(Object value) {
        int bucketIndex = bucketIndexFor(value);
        List bucket = _buckets[bucketIndex];
        if (bucket == null) {
            bucket =  new LinkedList();
            _buckets[bucketIndex] = bucket;
        }
        return bucket;
    }
    private int bucketIndexFor(Object value) {
        assert value != null;
        return Math.abs(value.hashCode() % _buckets.length);
    }
    private void maintainLoad() {
        if (loadFactorExceeded())
            resize();
    }
    private boolean loadFactorExceeded() {
        return size() > _buckets.length * _loadFactor;
    }
    private void resize() {
        BucketHashtable copy = new BucketHashtable(isPrime(_buckets.length * 2), _loadFactor);
        for (int i = 0; i < _buckets.length; ++i) {
            if(_buckets[i] !=null)
            copy.addAll(_buckets[i].iterator());
        }
        _buckets = copy._buckets;
    }
    int isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                n++;
        }
        return n;
    }
    private void addAll(Iterator values){
        assert values!= null;
        while(values.hasNext()) {
            HashEntry h = (HashEntry) values.next();
            add(h.getKey(),h.getValue());
        }
       //     add((HashEntry)values.next().getKey, (HashEntry)values.next().getValue() );
          //  System.out.println(values.current());

    }
    public void print(Iterator values)    {
        assert values!= null;
        while(values.hasNext())

          System.out.println(values.next());


    }
    public boolean empty()
    {
        return size()!= 0 ;
    }
    public Object get(Object key)    {
        List bucket = _buckets[bucketIndexFor(key)];
        return bucket;
    }
    public void dump()    {
        assert _buckets!= null;
        for (int i = 0; i < _buckets.length; ++i) {
            {
                System.out.println( _buckets[i]);
            }
        }
    }

}
