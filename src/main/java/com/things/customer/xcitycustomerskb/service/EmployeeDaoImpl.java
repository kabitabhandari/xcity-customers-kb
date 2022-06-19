package com.things.customer.xcitycustomerskb.service;

import com.things.customer.xcitycustomerskb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDAO {

    private final DataSource dataSource;

    @Autowired
    public EmployeeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO KB_EMPLOYEES " +
                "(id, first_name, last_name) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, emp.getId(), emp.getFirstName(), emp.getLastName());
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        String sql = "INSERT INTO KB_EMPLOYEES " + "(id, first_name, last_name) VALUES (?, ?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Employee employee = employees.get(i);
                ps.setInt(1, employee.getId());
                ps.setString(2, employee.getFirstName());
                ps.setString(3, employee.getLastName());
            }

            public int getBatchSize() {
                return employees.size();
            }
        });

    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM KB_EMPLOYEES ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Employee emp = new Employee();
            emp.setId((Integer) row.get("id"));
            emp.setFirstName((String) row.get("first_name"));
            emp.setLastName((String) row.get("last_name"));
            result.add(emp);
        }

        return result;
    }

    @Override
    public Employee getEmployeeById(String id) {
        String sql = "SELECT * FROM KB_EMPLOYEES  WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Employee emp = new Employee();
                emp.setFirstName(rs.getString("empName"));
                emp.setLastName(rs.getString("empName"));
                return emp;
            }
        });
    }
}
