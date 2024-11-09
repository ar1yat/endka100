package Validator;

import Model.Book;

public abstract class BookValidator {
    public static boolean isValid(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            System.out.println("Ошибка: Title не может быть пустым.");
            return false;
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            System.out.println("Ошибка: Author не может быть пустым.");
            return false;
        }
        if (book.getType() == null || book.getType().isEmpty()) {
            System.out.println("Ошибка: Type не может быть пустым.");
            return false;
        }
        if (book.getImgLink() == null || book.getImgLink().isEmpty()) {
            System.out.println("Ошибка: Image Link не может быть пустым.");
            return false;
        }
        return true;
    }

    public abstract boolean validate(Book book);
}
