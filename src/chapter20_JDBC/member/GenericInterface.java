package chapter20_JDBC.member;

import java.util.List;

// <T> 해당 타입으로 변경
public interface GenericInterface<T> {
	public int insert(T entitiy);
	public List<T> listAll();
	public T search(int id);
	public List<T> search(String name);
	public int update(T entitiy);
	public int delete(int id);
}
