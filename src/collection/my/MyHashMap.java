package collection.my;

/**
 * @author lb
 */
public class MyHashMap<K, V> {
    /**
     * 数组的长度
     */
    private int size;
    /**
     * 元素数组
     */
    private Entry[] table;
    /**
     * 数组的默认初始长度
     */
    private final int CAPACITY = 8;

    /**
     * 初始化数组容量
     */
    public MyHashMap() {
        this.table = new Entry[CAPACITY];
    }

    /**
     * 获取数组长度
     *
     * @return 数组长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 数组中的节点
     *
     * @param <K> key
     * @param <V> value
     */
    static class Entry<K, V> {
        final int hash;

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        final K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 根据key获取value
     *
     * @param key key
     * @return value
     */
    public Object get(Object key) {
        int hash = key.hashCode();
        int i = hash % CAPACITY;
        for (Entry<K, V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }


    public Object put(K key, V value) {
        int hash = key.hashCode();
        int i = hash % CAPACITY;

        for (Entry<K, V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        addEntry(hash, key, value, i);

        return null;
    }

    void addEntry(int hash, K key, V value, int index) {
        Entry entry = new Entry(hash, key, value, table[index]);
        table[index] = entry;
        size++;
    }

    public static void main(String[] args) {
        MyHashMap mapHashMap = new MyHashMap();
        mapHashMap.put("213", "123");
        System.out.println(mapHashMap.get("213"));
    }
}
