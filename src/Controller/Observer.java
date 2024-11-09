package Controller;

import Model.Book;

public interface Observer {
    void update(Book book);  // Метод обновления, который вызывается при изменении данных
}
