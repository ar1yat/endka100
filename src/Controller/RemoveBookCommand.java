package Controller;

import Model.BookService;

public class RemoveBookCommand implements Command {
    private BookService bookService;
    private int bookId;

    // Конструктор для удаления книги по ID
    public RemoveBookCommand(BookService bookService, int bookId) {
        this.bookService = bookService;
        this.bookId = bookId;
    }

    // Реализация метода execute для удаления книги
    @Override
    public void execute() {
        bookService.removeBook(bookId);  // Удаляем книгу по ID
    }
}
