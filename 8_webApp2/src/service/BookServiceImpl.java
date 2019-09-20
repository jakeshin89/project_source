package service;

import java.util.List;

import dao.BookDao;
import vo.BookVO;

public class BookServiceImpl implements BookService{
//BookService �������̽� ������ Imple

	BookDao dao;

	public BookServiceImpl() {}

	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}
	
	public BookDao getDao() {
		return dao;
	}

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public List<BookVO> bookList() {
		return dao.getBookRec();
	}

	@Override
	public int addBook(BookVO vo) throws Exception {
		return dao.insertBook(vo);
	}

	@Override
	public int deleteBook(int bookid) {
		return dao.deleteBook(bookid);
	}

	@Override
	public int updateBook(BookVO vo) {
		return dao.updateBook(vo);
	}
	
}
