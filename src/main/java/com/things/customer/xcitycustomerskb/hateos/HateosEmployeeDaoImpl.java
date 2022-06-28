package com.things.customer.xcitycustomerskb.hateos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class HateosEmployeeDaoImpl extends JdbcDaoSupport implements HateosEmployeeDAO {

    private final DataSource dataSource;

    @Autowired
    public HateosEmployeeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<HateosEmployee> getAllEmployees() {
        String sql = "SELECT * FROM KB_EMPLOYEES ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<HateosEmployee> resultList = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            HateosEmployee emp = new HateosEmployee();
            emp.setId((Integer) row.get("id"));
            emp.setFirstName((String) row.get("first_name"));
            emp.setLastName((String) row.get("last_name"));
            emp.setEmail((String) row.get("email"));

            // for adding self link.
            Link selfLink = WebMvcLinkBuilder.linkTo(HateosEmployee.class).slash("v1").withSelfRel();
            Link eachItemizeLink = WebMvcLinkBuilder
                    .linkTo(HateosEmployee.class)
                    .slash("hateos")
                    .slash("v1")
                    .slash(emp.getId())
                    .withRel("transaction");
            emp.add(selfLink);
            emp.add(eachItemizeLink);

            resultList.add(emp);
        }

        return resultList;
    }

    @Override
    public HateosEmployee getEmployeeById(Integer id) {
        String sql = "SELECT * FROM KB_EMPLOYEES  WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<HateosEmployee>() {
            @Override
            public HateosEmployee mapRow(ResultSet rs, int rwNumber) throws SQLException {
                HateosEmployee emp = new HateosEmployee();
                emp.setId(id); //this will come from path variable in url
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));

                // for adding self link.
                Link selfLink = WebMvcLinkBuilder.linkTo(HateosEmployee.class).slash("hateos").slash("v1").slash(id).withSelfRel();
                emp.add(selfLink);
                if(true){ // value present in cache
                    JobDetail jobDetail = new JobDetail(id, JobDetail.JobState.COMPLETED.name());
                    emp.setStatus(jobDetail);
                    return emp;
                }
                else{
                    HateosEmployee empe =new HateosEmployee();
                    JobDetail jobDetail = new JobDetail(id, JobDetail.JobState.FAILED.name());
                    empe.setStatus(jobDetail);
                    return empe;
                }

            }
        });
    }

    @Override
    public JobDetail getEmployeeByIdUsingJobDetail(Integer id) {
        JobDetail jobDetail = new JobDetail(id, JobDetail.JobState.PROCESSING.name());
        // for adding self link.
        Link selfLink = WebMvcLinkBuilder.linkTo(JobDetail.class).slash("hateos").slash("v1").slash(id).withSelfRel();
        jobDetail.add(selfLink);
        return jobDetail;

        /**
         * put job details in cache as Processing...
         * If processing took longer than 10 sec then failed else completed
         *
         */


    }

}
