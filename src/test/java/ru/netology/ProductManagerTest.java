package ru.netology;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Financier", 799, "Dreiser");
    Book book2 = new Book(2, "The Richest Man in Babylon", 899, "George Samuel Clayson");
    Book book3 = new Book(3, "Book of Jungle", 999, "Joseph Rudyard Kipling");
    Book book4 = new Book(4, "Instruction for Iphone 12", 1299, "Non author");
    Book book5 = new Book(5, "Financier or not", 799, "Dreiser");
    Book book6 = new Book(6, "Financier", 799, "Dreiser or not");
    Book book3 = new Book(7, "The Jungle book", 999, "Joseph Rudyard Kipling");
    Book book4 = new Book(8, "Instruction for Iphone 12", 1299, "Non author");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
    }

    
    

    @Test

    public void shouldSearchNameBook() {
        Product[] actual = manager.searchBy("The Richest Man in Babylon");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAuthorBook() {
        Product[] actual = manager.searchBy("Dreiser");
        Product[] expected = new Product[]{book1, book5};
        assertArrayEquals(expected, actual);
    }

    @Test
    /*Falling test*/
    public void shouldSearchNameTwoBook() {
        Product[] actual = manager.searchBy("Financier");
        Product[] expected = new Product[]{book1, book6};
        assertArrayEquals(expected, actual);
    }
}


