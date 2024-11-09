package View;

import Controller.BookController;
import Model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LibraryView extends JFrame {
    private BookController bookController;
    private JTextArea bookListTextArea;
    private JTextField titleField, authorField, imgLinkField, typeField;

    public LibraryView() {
        // Создаем экземпляр контроллера
        bookController = new BookController();

        // Устанавливаем параметры окна
        setTitle("Library Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель для отображения списка книг
        bookListTextArea = new JTextArea();
        bookListTextArea.setEditable(false);
        add(new JScrollPane(bookListTextArea), BorderLayout.CENTER);

        // Панель для добавления новой книги
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Type:"));
        typeField = new JTextField();
        inputPanel.add(typeField);

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Image Link:"));
        imgLinkField = new JTextField();
        inputPanel.add(imgLinkField);

        JButton addButton = new JButton("Add Book");
        inputPanel.add(addButton);

        JButton refreshButton = new JButton("Refresh List");
        inputPanel.add(refreshButton);

        // Панель для удаления книги
        JPanel deletePanel = new JPanel(new BorderLayout());
        deletePanel.add(new JLabel("Enter Book ID to Delete:"), BorderLayout.WEST);
        JTextField deleteField = new JTextField();
        deletePanel.add(deleteField, BorderLayout.CENTER);
        JButton deleteButton = new JButton("Delete Book");
        deletePanel.add(deleteButton, BorderLayout.EAST);

        // Добавляем панели на форму
        add(inputPanel, BorderLayout.NORTH);
        add(deletePanel, BorderLayout.SOUTH);

        // Обработчик для кнопки добавления книги
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = typeField.getText();
                String title = titleField.getText();
                String author = authorField.getText();
                String imgLink = imgLinkField.getText();

                // Вызов контроллера для добавления новой книги
                // Используем getAllBooks().size() + 1 для создания уникального ID
                bookController.addBook(type, getNextBookId(), title, author, imgLink);
                refreshBookList();
            }
        });

        // Обработчик для кнопки обновления списка книг
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshBookList();
            }
        });

        // Обработчик для кнопки удаления книги
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(deleteField.getText());
                    bookController.removeBook(id);
                    refreshBookList();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format.");
                }
            }
        });

        refreshBookList();
    }

    // Метод для получения следующего ID книги
    private int getNextBookId() {
        return bookController.getAllBooks().size() + 1;
    }

    // Метод для обновления списка книг в текстовом поле
    private void refreshBookList() {
        List<Book> books = bookController.getAllBooks();
        StringBuilder bookListText = new StringBuilder("Books in Library:\n");
        for (Book book : books) {
            bookListText.append("ID: ").append(book.getId()).append(", ")
                    .append("Title: ").append(book.getTitle()).append(", ")
                    .append("Author: ").append(book.getAuthor()).append(", ")
                    .append("Image Link: ").append(book.getImgLink()).append("\n");
        }
        bookListTextArea.setText(bookListText.toString());
    }

    public static void main(String[] args) {
        // Запуск приложения
        SwingUtilities.invokeLater(() -> {
            LibraryView libraryView = new LibraryView();
            libraryView.setVisible(true);
        });
    }
}
