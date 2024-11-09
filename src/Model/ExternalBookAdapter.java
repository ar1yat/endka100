package Model;

public class ExternalBookAdapter extends Book {
    // Адаптер для преобразования ExternalBook в объект Book
    public ExternalBookAdapter(ExternalBook externalBook) {
        super(externalBook.getUniqueCode(), externalBook.getBookName(), externalBook.getBookAuthor(), externalBook.getBookImgLink());
    }
}
