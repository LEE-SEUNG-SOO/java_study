package db;

import java.util.List;

public interface GenericRepositoryInterface<T> {
	public int insert(T entity);
	public int update(T entity);
	public int remove(String id);
	public int getCount();
	public List<T> findAll();
	public T find(String id);
}
