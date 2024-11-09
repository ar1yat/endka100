package Validator;

import Model.Book;

public class TitleValidator extends BookValidator {
    @Override
    public boolean validate(Book book) {
        return book.getTitle() != null && !book.getTitle().isEmpty();
    }
}
