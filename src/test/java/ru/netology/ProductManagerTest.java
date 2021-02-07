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
    Book book1 = new Book(1, "Financier", 899, "Dreiser");
    Book book2 = new Book(2, "The richest man in Babylon", 799, "George Samuel Clayson");
    Book book3 = new Book(3, "Book of the Jungle", 599, "Joseph Rudyard Kipling");
    Book book4 = new Book(4, "Instruction for iPhone 12", 99, "Non author");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
    }

    @Test
    public void shouldSearchNameBook() {
        Product[] actual = manager.searchBy("The richest man in Babylon");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAuthorBook() {
        Product[] actual = manager.searchBy("Dreiser");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

}


