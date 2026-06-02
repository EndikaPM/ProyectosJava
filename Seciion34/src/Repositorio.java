import java.sql.Connection;
import java.util.List;

public interface Repositorio <T>{
    void add(T t);
    List<T>listar();
    void delete(Long t);
    void update(T t);
}
