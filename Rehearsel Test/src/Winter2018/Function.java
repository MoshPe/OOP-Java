package Winter2018;

public interface Function<T> extends Iterable<T>{
	boolean add(T x, T y);
	Integer evaluate(T x);
}

