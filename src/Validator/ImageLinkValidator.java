package Validator;

import Model.Book;

public class ImageLinkValidator extends BookValidator {
    @Override
    public boolean validate(Book book) {
        return book.getImgLink() != null && !book.getImgLink().isEmpty();
    }
}
