package com.malsolo.springframework.core.sample;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MyCustomService implements CustomService {

    final private static Logger logger = LoggerFactory.getLogger(MyCustomService.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private String message;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /* (non-Javadoc)
     * @see com.malsolo.springframework.core.sample.CustomService#run()
     */
    public void run() {
        try {
            System.out.println("\n\n"
                    + this.message
                    + " : "
                    + (this.dataSource == null ? "No DataSource"
                    : this.dataSource.getConnection().getMetaData().getDatabaseProductName())
                    + "\n\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void info() {
        int i = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM  INFORMATION_SCHEMA.TABLES", Integer.class);
        System.out.printf("\n\nNumber of tables: %d\n\n", i);
    }

    @PostConstruct
    public void postConstructMethod() {
        logger.debug("postConstructMethod() called");
    }

    public void initMethod() {
        logger.debug("initMethod() called");
    }

}
