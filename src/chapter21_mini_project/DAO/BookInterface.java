package chapter21_mini_project.DAO;

import java.util.List;

public interface BookInterface<T> {
	public int insert(T entity);
	public int update(T entity);
	public int remove(String cid);
	public int remove(String cid, String bid);
	public int getCount(String cid);
	public List<T> findAll();
	public List<T> findAll(String cid);
	public T find(String bid);
	public T find(String cid, String bid);
	public void close();
}
