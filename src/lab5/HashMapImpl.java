package lab5;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl<V> implements HashMap<String, V> {

    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private ArrayList<LinkedList<Pair<String, V>>> table;

    public HashMapImpl() {
        table = new ArrayList<>();

        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }



    private long hashByString(String value) {
        long hash = 0;

        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }

        return hash;
    }

    @Override
    public void put(String key, V value) {

        int index = (int) hashByString(key);

        LinkedList<Pair<String, V>> list = table.get(index);

        for (Pair<String, V> pair : list) {

            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }

        list.add(new Pair<>(key, value));
    }

    @Override
    public V getValue(String key) {

        int index = (int) hashByString(key);

        LinkedList<Pair<String, V>> list = table.get(index);

        for (Pair<String, V> pair : list) {

            if (pair.key.equals(key)) {
                return pair.value;
            }
        }

        return null;
    }

    @Override
    public V delete(String key) {

        int index = (int) hashByString(key);

        LinkedList<Pair<String, V>> list = table.get(index);

        for (Pair<String, V> pair : list) {

            if (pair.key.equals(key)) {
                V deletedValue = pair.value;

                list.remove(pair);

                return deletedValue;
            }
        }

        return null;
    }
}