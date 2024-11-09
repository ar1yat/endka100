package Model;

public class BookFactory {
    // Фабричный метод для создания книг разных типов
    public static Book createBook(String type, int id, String title, String author, String imgLink) {
        if (type.equalsIgnoreCase("Science")) {
            return new ScienceBook(id, title, author, imgLink);
        } else if (type.equalsIgnoreCase("Literature")) {
            return new LiteratureBook(id, title, author, imgLink);
        } else {
            return new Book(id, title, author, imgLink, imgLink);
        }
    }
}

// Классы-наследники для конкретных типов книг
class ScienceBook extends Book {
    public ScienceBook(int id, String title, String author, String imgLink) {
        super(id, title, author, imgLink, imgLink);
    }
}

class LiteratureBook extends Book {
    public LiteratureBook(int id, String title, String author, String imgLink) {
        super(id, title, author, imgLink, imgLink);
    }
}
