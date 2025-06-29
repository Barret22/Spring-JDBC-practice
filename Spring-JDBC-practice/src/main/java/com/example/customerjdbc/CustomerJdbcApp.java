package com.example.customerjdbc;

import com.example.customerjdbc.dao.CustomerDao;
import com.example.customerjdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CustomerJdbcApp implements CommandLineRunner {

    @Autowired
    private CustomerDao customerDao;

    public static void main(String[] args) {
        SpringApplication.run(CustomerJdbcApp.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Додаємо нового клієнта ===");
        Customer newCustomer = new Customer(0, "Ivan Ivanov", "ivanov@example.com", "123-45-6789");
        customerDao.addCustomer(newCustomer);

        System.out.println("=== Всі клієнти в базі ===");
        List<Customer> customers = customerDao.getAllCustomers();
        customers.forEach(System.out::println);

        System.out.println("=== Шукаємо клієнта за ID = 1 ===");
        Customer found = customerDao.getCustomerById(1);
        System.out.println(found);

        System.out.println("=== Оновлюємо email клієнта ===");
        found.setEmail("ivanov_updated@example.com");
        customerDao.updateCustomer(found);

        System.out.println("=== Після оновлення ===");
        System.out.println(customerDao.getCustomerById(1));

        System.out.println("=== Видаляємо клієнта ===");
        customerDao.deleteCustomer(1);

        System.out.println("=== Клієнти після видалення ===");
        customerDao.getAllCustomers().forEach(System.out::println);
    }
}
