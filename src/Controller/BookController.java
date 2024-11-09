package Controller;

import Model.Book;
import Model.BookService;

import java.util.List;

// Контроллер для управления книгами
public class BookController {
    private BookService bookService;

    public BookController() {
        this.bookService = BookService.getInstance();  // Получаем экземпляр BookService
    }

    // Метод для добавления книги через команду
    public void addBook(String type, int id, String title, String author, String imgLink) {
        // Создаем объект Book
        Book book = new Book(bookService.getAllBooks().size() + 1, title, author, imgLink);

        // Создаем команду с правильными параметрами
        AddBookCommand addCommand = new AddBookCommand(bookService, book);
        addCommand.execute();  // Выполняем команду добавления книги
    }

    // Метод для получения всех книг
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();  // Возвращаем все книги
    }

    // Метод для удаления книги через команду
    public void removeBook(int id) {
        RemoveBookCommand removeCommand = new RemoveBookCommand(bookService, id);  // Создаем команду удаления
        removeCommand.execute();  // Выполняем команду удаления книги
    }
}
