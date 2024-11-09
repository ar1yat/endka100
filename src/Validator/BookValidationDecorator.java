package Validator;

import Model.Book;

import java.util.List;

public class BookValidationDecorator extends BookValidator {
    private List<BookValidator> validators;

    public BookValidationDecorator() {
        this.validators = List.of(new TitleValidator(), new AuthorValidator(), new ImageLinkValidator());
    }

    @Override
    public boolean validate(Book book) {
        for (BookValidator validator : validators) {
            if (!validator.validate(book)) {
                return false;  // Если хотя бы один валидатор не прошел, возвращаем false
            }
        }
        return true;  // Если все валидаторы прошли, возвращаем true
    }
}
