package Controller;

import Model.Book;
import Model.BookService;
import Validator.BookValidator;

import java.util.List;
import java.util.logging.Logger;

public class LibraryFacade {
    private static final Logger logger = Logger.getLogger(LibraryFacade.class.getName());
    private BookService bookService;
    private NotificationService notificationService;

    public LibraryFacade() {
        bookService = BookService.getInstance();  // Получаем единственный экземпляр BookService
        notificationService = new NotificationService();  // Создаем NotificationService
        bookService.addObserver(notificationService);  // Подписка на уведомления
    }

    public List<Book> getBooks() {
        return bookService.getAllBooks();  // Возвращаем все книги
    }

    // Метод для добавления книги
    public void addBook(String type, String title, String author, String imgLink) {
        try {
            int id = getNextBookId();
            Book book = new Book(id, type, title, author, imgLink);

            // Валидация книги перед добавлением
            if (BookValidator.isValid(book)) {
                AddBookCommand addCommand = new AddBookCommand(bookService, book);
                addCommand.execute();  // Выполняем команду добавления книги
                logger.info("Book added successfully: " + book);
            } else {
                logger.warning("Failed to add book due to validation errors.");
            }
        } catch (Exception e) {
            logger.severe("Failed to add book: " + e.getMessage());
        }
    }

    // Метод для удаления книги
    public void removeBook(int id) {
        try {
            bookService.removeBook(id);  // Удаляем книгу
            logger.info("Book removed with ID: " + id);
        } catch (Exception e) {
            logger.severe("Failed to remove book: " + e.getMessage());
        }
    }

    // Получение следующего уникального ID книги
    private int getNextBookId() {
        return bookService.getAllBooks().size() + 1;
    }
}
