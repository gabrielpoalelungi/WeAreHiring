public class Request<K, V> implements Comparable{
    private K key;
    private V value1, value2;
    private Double score;

    public Request(K key, V value1, V value2, Double score) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.score = score;
    }

    public K getKey() {
        return key;
    }

    public V getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }

    public String toString() {
        return "Key: " + key + " ; Value1: " + value1 + " ; Value2: " +
                value2 + " ;Score: " + score + "\n" + "\n";
    }

    public int compareTo(Object o) {
        Request request = (Request) o;
        return this.score.compareTo(request.score) * (-1);
    }
}
