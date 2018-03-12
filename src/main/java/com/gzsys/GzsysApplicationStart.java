package com.gzsys;

import com.gzsys.common.datasources.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class GzsysApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(GzsysApplicationStart.class, args);
	}
}
