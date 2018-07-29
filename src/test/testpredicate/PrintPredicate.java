package test.testpredicate;

/**
 * Created by Administrator on 2018/6/20.
 */
public interface PrintPredicate<T> {

    String accept(T entity);
}
