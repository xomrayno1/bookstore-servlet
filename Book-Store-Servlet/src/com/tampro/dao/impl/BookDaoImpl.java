package com.tampro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tampro.dao.BookDao;
import com.tampro.dao.RootDao;
import com.tampro.model.Authors;
import com.tampro.model.Books;
import com.tampro.service.AuthorService;
import com.tampro.service.impl.AuthorServiceImpl;

public class BookDaoImpl extends RootDao implements BookDao{

	AuthorService authorService = new AuthorServiceImpl();
	@Override
	public Books getBookById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql  = "select * from books where  book_ID =  ?";
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books() ;
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				return books;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public Books getBookByIdBook(int idBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> getAllBook() {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql  = "select * from books ";
		try {
			connection = getConnection();
			 statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			List<Books> list = new ArrayList<Books>();
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books();
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public List<Books> getAllBookByIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		String sql  = "select * from books where book_Category_Code = ?";
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idCategory);
			ResultSet rs = statement.executeQuery();
			List<Books> list = new ArrayList<Books>();
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books();
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public boolean deletBookById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBook(Books book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBook(Books book) {
		String sql = "INSERT INTO BOOKS(ISBN,book_title,publication_Date,book_Comments,author_ID,book_Category_Code,images,price,createdate)"
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getISBN());
			statement.setString(2, book.getTitle());
			statement.setDate(3, book.getPublication_date());
			statement.setString(4, book.getComments());
			statement.setInt(5, book.getAuthor().getId());
			statement.setInt(6, book.getCategory_Id());
			statement.setString(7, book.getImages());
			statement.setInt(8, book.getPrice());
			statement.setDate(9, book.getCreate_Date());
			statement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

	@Override
	public List<Books> getAllBooksNews() {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql  = "SELECT * FROM `book-store`.books order by  createdate desc limit 12";
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			List<Books> list = new ArrayList<Books>();
			
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books();
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		
	}

	@Override
	public List<Books> getAllBookByIdCategoryPagination(int idCategory,int start, int end) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "SELECT * FROM `book-store`.books where book_Category_Code = ?   limit ?,? ";
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idCategory);
			statement.setInt(2, start);
			statement.setInt(3, end);
			ResultSet rs = statement.executeQuery();
			List<Books> list = new ArrayList<Books>();
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books();
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	
	}

	@Override
	public List<Books> getAllBookBySearch(String name) {
		String sql = "select * from books where books.book_Title like ? ";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, "%" + name+"%");
			ResultSet rs = statement.executeQuery();
			List<Books> list = new ArrayList<Books>();
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books();
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	
	}

	@Override
	public List<Books> getAllBookBySearchPagination(String name, int start, int end) {
		
		String sql = "select * from books where books.book_Title like  '%'?'%' limit ?,? ";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2,start);
			statement.setInt(3, end);
			ResultSet rs = statement.executeQuery();
			List<Books> list = new ArrayList<Books>();
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books();
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public List<Books> getAllBook(int start, int end) {
		String sql ="SELECT * FROM books order by books.book_ID DESC limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);					
			statement.setInt(1, start);
			statement.setInt(2, end);
			ResultSet rs = statement.executeQuery();
			List<Books> list = new ArrayList<Books>();
			while(rs.next()) {
				int idAuthor = rs.getInt("author_ID");
				Authors authors = authorService.getAuthorsById(idAuthor);
				Books books = new Books();
				books.setId(rs.getInt("book_ID"));
				books.setISBN(rs.getString("ISBN"));
				books.setTitle(rs.getString("book_Title"));
				books.setImages(rs.getString("images"));
				books.setComments(rs.getString("book_Comments"));
				books.setAuthor(authors);
				books.setCategory_Id(rs.getInt("book_Category_Code"));
				books.setPublication_date(rs.getDate("publication_Date"));
				books.setPrice(rs.getInt("price"));
				books.setCreate_Date(rs.getDate("createdate"));
				list.add(books);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public List<Books> getAllBookSearch(String name, String category, String dateTo, String dateFrom) {
		String sqlQ =" select * from books where  `createdate` between '2020-07-05' and '2020-07-13' AND  `book_Category_Code`= 6    and  books.book_Title like  '%d%' ";
		StringBuilder builder = new StringBuilder("select * from books where ");
		if(dateTo != null || dateFrom != null ) {
			builder.append("`createdate` between "+dateTo+" and "+dateFrom);
		}
		if(category != null) {
			builder.append(" AND  `book_Category_Code`= 6  and ");
		} 
		if(name != null) {
			builder.append("  and  books.book_Title like  '%'?'%' "); 
		} 
		
		
		
		return null;
	}

}
