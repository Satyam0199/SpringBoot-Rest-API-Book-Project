package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookServices {

//------------------------------Response Entity Api Start---------------------------------------------------
//    private static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(101, "Java", "Abc"));
//        list.add(new Book(102, "C++", "Abc"));
//        list.add(new Book(103, "Python", "Abc"));
//    }
//------------------------------Response Entity Api End---------------------------------------------------

//------------------------------SpringBoot JPA Data Start---------------------------------------------------
	@Autowired
	private BookRepository bookRepository;

//------------------------------SpringBoot JPA Data Start---------------------------------------------------

//------------------------------Response Entity Api getAll Book Start---------------------------------------------------

	// get all books
//    public List<Book> getallBooks()
//    {
//    	return list;
//    }
//------------------------------Response Entity Api getAll Book End---------------------------------------------------

//------------------------------SpringBoot JPA Data Get all Book Start---------------------------------------------------
	public List<Book> getallBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

//------------------------------SpringBoot JPA Data Get all Book End---------------------------------------------------

//------------------------------Response Entity Api get BookById Start---------------------------------------------------

	// get single book by id

//    public Book getBookById(int id)
//    {
//    	Book book=null;
//    	try {
//    		book = list.stream().filter(e->e.getId()==id).findFirst().get();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//    	return book;
//    }
//------------------------------Response Entity Api get BookById Start---------------------------------------------------

// ------------------------------SpringBoot JPA Data Get BookByIdStart---------------------------------------------------

  public Book getBookById(int id)
  {
  	Book book=null;
  	try {
  		book=this.bookRepository.findById(id);

  	} catch (Exception e) {
			// TODO: handle exception
		}
  	return book;
  }  
//------------------------------SpringBoot JPA Data Get BookById End---------------------------------------------------

//------------------------------Response Entity Api Adding Books Start---------------------------------------------------

	// adding the books
//    public Book addBook(Book b)
//    {
//    	list.add(b);
//    	return b;
//    }
	// ------------------------------Response Entity Api Adding Books
	// Start---------------------------------------------------

	// ------------------------------SpringBoot JPA Data Adding Books
	// Start---------------------------------------------------

	// adding the books
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}

//------------------------------SpringBoot JPA Data Adding Books End---------------------------------------------------

//------------------------------Response Entity Api Delete Books Start---------------------------------------------------

	// delete book method
//    public void deleteBook(int bid)
//    {
//    	list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
//    }

//------------------------------Response Entity Api Delete Books End---------------------------------------------------

//------------------------------SpringBoot JPA Data Delete Books Start---------------------------------------------------

	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
	}
//------------------------------SpringBoot JPA Data Delete Books End---------------------------------------------------

//------------------------------Response Entity Api Update Books Start---------------------------------------------------

	// update Book
//	public void updateBook(Book book, int bookId) {
//		list.stream().map(b -> {
//			if (b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
//
//	}
//
//}

//------------------------------Response Entity Api Update Books End---------------------------------------------------
//update Book
	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
	}

}