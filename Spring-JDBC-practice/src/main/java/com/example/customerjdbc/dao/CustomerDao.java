package com.example.customerjdbc.dao;

import com.example.customerjdbc.model.Customer;
import com.example.customerjdbc.rowmapper.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ➕ Додати нового клієнта
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customer (full_name, email, social_security_number) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                customer.getFullName(),
                customer.getEmail(),
                customer.getSocialSecurityNumber());
    }

    // 🔍 Знайти клієнта по ID
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
    }

    // 📝 Оновити клієнта
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET full_name = ?, email = ?, social_security_number = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                customer.getFullName(),
                customer.getEmail(),
                customer.getSocialSecurityNumber(),
                customer.getId());
    }

    // ❌ Видалити клієнта
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // 📋 Отримати список всіх клієнтів
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }
}
