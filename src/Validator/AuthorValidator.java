package Validator;

import Model.Book;

public class AuthorValidator extends BookValidator {
    @Override
    public boolean validate(Book book) {
        return book.getAuthor() != null && !book.getAuthor().isEmpty();
    }
}
