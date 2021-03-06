/**
 * Created by Magdalena Polak on 11.05.2016.
 */
public class HashEntry {
    private int key;
    private String value;

    HashEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Klucz: " + key + " Wartosc: " + value;
    }
}