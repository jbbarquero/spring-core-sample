package com.malsolo.springframework.core.sample;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MyCustomService implements CustomService {
	
	final private static Logger logger = LoggerFactory.getLogger(MyCustomService.class);
	
	private DataSource dataSource;

	private String message;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
	
	@PostConstruct
	public void postConstructMethod() {
		logger.debug("postConstructMethod() called");
	}

	public void initMethod() {
		logger.debug("initMethod() called");
	}
}
