package Controller;

import Model.Book;

public class NotificationService implements Observer {
    @Override
    public void update(Book book) {
        if (book != null) {
            System.out.println("New book added: " + book.getTitle());
        } else {
            System.out.println("A book has been removed.");
        }
    }
}
