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
            // Попытка добавить книгу через BookService
            bookService.addBook(book);
            logger.info("Book added successfully: " + book.getTitle());
        } catch (IllegalArgumentException e) {
            // Логируем ошибку, если книга имеет недопустимые данные
            logger.severe("Invalid book data: " + e.getMessage());
        } catch (Exception e) {
            // Логируем ошибки общего характера
            logger.severe("Failed to add book: " + e.getMessage());
            // Опционально, выводим стек ошибок для отладки
            logger.severe("Exception Stack Trace: ");
            for (StackTraceElement element : e.getStackTrace()) {
                logger.severe(element.toString());
            }
        }
    }
}
