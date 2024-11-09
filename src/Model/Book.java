package Model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String imgLink;

    // Конструктор для создания книги
    public Book(int id, String title, String author, String imgLink) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imgLink = imgLink;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImgLink() {
        return imgLink;
    }
}
