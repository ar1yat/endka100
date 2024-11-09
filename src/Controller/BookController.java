package Controller;

import Model.Book;
import Model.BookService;
import Validator.BookValidator;

import java.util.Collection;
import java.util.List;

public class BookController {
    private BookService bookService;

    public BookController() {
        this.bookService = BookService.getInstance(); // Получаем экземпляр BookService
    }

    // Метод для добавления книги
    public void addBook(int nextBookId, String title, String author, String imgLink, String type) {
        // Валидация данных
        if (BookValidator.isValid(new Book(0, type, title, author, imgLink))) {
            // Если данные валидны, создаем книгу
            int id = bookService.getAllBooks().size() + 1;  // Получаем следующий ID книги
            Book book = new Book(id, type, title, author, imgLink);
            AddBookCommand addCommand = new AddBookCommand(bookService, book);
            addCommand.execute();  // Выполняем команду добавления книги
        } else {
            // Если данные невалидны, выводим ошибку
            System.out.println("Invalid input. Please check your data.");
        }
    }

    // Метод для получения всех книг
    public List<Book> getBooks() {
        return bookService.getAllBooks();  // Получаем все книги через BookService
    }

    // Метод для удаления книги
    public void removeBook(int id) {
        bookService.removeBook(id); // Удаляем книгу по ID
    }

    // Метод для получения всех книг в виде коллекции
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();  // Возвращаем все книги как коллекцию
    }
}
