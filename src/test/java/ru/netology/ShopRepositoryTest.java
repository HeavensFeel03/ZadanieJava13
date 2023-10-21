package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product item1 = new Product(1, "Картошка", 50);
    Product item2 = new Product(2, "Морковка", 80);
    Product item3 = new Product(3, "Лук", 90);

    @BeforeEach
    public void setup() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
    }

    @Test
    public void shouldAllProduct() {
        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Product[] expected = {item3};
        Product[] actual = new Product[]{repo.findById(3)};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }

    @Test
    public void shouldRemoveById() {
        Product[] expected = {item1, item3};
        Product[] actual = repo.removeById(2);

        Assertions.assertArrayEquals(expected, actual);
    }


}
