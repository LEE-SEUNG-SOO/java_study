package com.bookmgm.repository;

import java.util.List;
import com.bookmgm.model.Book;

public interface BookRepository {
	public boolean insert(Book book);
	public boolean update(Book book);
	public boolean remove(String id);
	public boolean remove(Book book);
	public int getCount();
	public List<Book> selectAll();
	public Book select(String id);
}
