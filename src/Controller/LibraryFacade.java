package Controller;

import Model.Book;
import Model.BookService;
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
    public void addBook(String title, String author, String imgLink) {
        try {
            // Получаем ID книги
            int id = getNextBookId();
            // Создаем объект книги
            Book book = new Book(id, title, author, imgLink);
            // Создаем команду с книгой
            AddBookCommand addCommand = new AddBookCommand(bookService, book);
            addCommand.execute();  // Выполняем команду добавления книги
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
