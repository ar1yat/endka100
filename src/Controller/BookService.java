package Model;

import Controller.Observer;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static BookService instance;
    private List<Book> books;
    private List<Observer> observers = new ArrayList<>();

    // Приватный конструктор для реализации шаблона Singleton
    private BookService() {
        books = new ArrayList<>();
    }

    // Метод для получения единственного экземпляра BookService
    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    // Добавление книги
    public void addBook(Book book) {
        books.add(book);
        notifyObservers(book);  // Уведомление наблюдателей о добавлении книги
    }

    // Получение всех книг
    public List<Book> getAllBooks() {
        return books;
    }

    // Удаление книги по id
    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        notifyObservers(null);  // Уведомление наблюдателей об удалении книги
    }

    // Добавление наблюдателя
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Уведомление всех наблюдателей об изменении
    private void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
