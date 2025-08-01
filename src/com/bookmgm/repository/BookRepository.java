package com.bookmgm.repository;

import java.util.List;
import com.bookmgm.model.BookVO;

public interface BookRepository {
	public boolean insert(BookVO book);
	public boolean update(BookVO book);
	public boolean remove(String id);
	public boolean remove(BookVO book);
	public int getCount();
	public List<BookVO> selectAll();
	public BookVO select(String id);
}
