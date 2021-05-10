package ContainerTesting.containers;

import Student.Student;
import Repository.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
class ContainersApplicationTests {

	@Autowired
	private Repository studentRepository;

	@Container
	public static PostgreSQLContainer container = new PostgreSQLContainer("postgres")
			.withUsername("duke")
			.withPassword("password")
			.withDatabaseName("test");

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.username", container::getUsername);
	}

	@Test
	void contextLoads() {

		Student student = new Student();
		student.setName("Antonio");
		student.setAge(30);
		student.setNmec(12345);
		studentRepository.save(student);

		System.out.println("Context loads!");

	}

}
