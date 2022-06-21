package com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall;

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
    public void insertEmployee(Employee emp, Integer id) {
        String sql = "INSERT INTO KB_EMPLOYEES " +
                "(id, first_name, last_name, email) VALUES (?, ?, ?,?)";
        getJdbcTemplate().update(sql, id, emp.getFirstName(), emp.getLastName(), emp.getEmail());
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        String sql = "INSERT INTO KB_EMPLOYEES " + "(id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Employee employee = employees.get(i);
                ps.setInt(1, employee.getId());
                ps.setString(2, employee.getFirstName());
                ps.setString(3, employee.getLastName());
                ps.setString(4, employee.getEmail());
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

        List<Employee> resultList = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Employee emp = new Employee();
            emp.setId((Integer) row.get("id"));
            emp.setFirstName((String) row.get("first_name"));
            emp.setLastName((String) row.get("last_name"));
            emp.setEmail((String) row.get("email"));
            resultList.add(emp);
        }

        return resultList;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql = "SELECT * FROM KB_EMPLOYEES  WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Employee emp = new Employee();
                emp.setId(id); //this will come from path variable in url
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                return emp;
            }
        });
    }
}
