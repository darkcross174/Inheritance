package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldSearchNameBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager();
        Book book1 = new Book(1, "Financier", 799, "Dreiser");
        Book book2 = new Book(2, "The Richest Man in Babylon", 899, "George Samuel Clayson");
        Book book3 = new Book(3, "The Jungle book", 999, "Joseph Rudyard Kipling");
        Book book4 = new Book(4, "Instruction for Iphone 12", 1299, "Non author");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("The Richest Man in Babylon");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthorBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager();
        Book book1 = new Book(1, "Financier", 799, "Dreiser");
        Book book2 = new Book(2, "The Richest Man in Babylon", 899, "George Samuel Clayson");
        Book book3 = new Book(3, "The Jungle book", 999, "Joseph Rudyard Kipling");
        Book book4 = new Book(4, "Instruction for Iphone 12", 1299, "Non author");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Dreiser");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager();
        Book book1 = new Book(1, "Financier", 799, "Dreiser");
        Book book2 = new Book(2, "The Richest Man in Babylon", 899, "George Samuel Clayson");
        Book book3 = new Book(3, "Financier", 999, "Non author");
        Book book4 = new Book(4, "Instruction for Iphone 12", 1299, "Non author");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Financier");
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }
}

