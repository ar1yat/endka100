package Model;

public class Book {
    private int id;
    private String type;   // Добавлено поле type
    private String title;
    private String author;
    private String imgLink;

    // Конструктор для создания книги
    public Book(int id, String type, String title, String author, String imgLink) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.author = author;
        this.imgLink = imgLink;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getType() {
        return type;    // Геттер для type
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
