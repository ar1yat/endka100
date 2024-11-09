package Controller;

import Model.Book;
import Model.BookService;
import java.util.logging.Logger;

public class AddBookCommand implements Command {
    private static final Logger logger = Logger.getLogger(AddBookCommand.class.getName());
    private BookService bookService;
    private Book book;

    // Конструктор, который принимает BookService и Book
    public AddBookCommand(BookService bookService, Book book) {
        this.bookService = bookService;
        this.book = book;
    }

    // Реализация метода execute для добавления книги
    @Override
    public void execute() {
        try {
            bookService.addBook(book);  // Добавляем книгу в BookService
            logger.info("Book added: " + book.getTitle());
        } catch (Exception e) {
            logger.severe("Failed to add book: " + e.getMessage());
        }
    }
}
