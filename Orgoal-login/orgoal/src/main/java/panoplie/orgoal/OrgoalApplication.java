package panoplie.orgoal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"panoplie.orgoal.repository"})
@SpringBootApplication
public class OrgoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgoalApplication.class, args);
	}

}
