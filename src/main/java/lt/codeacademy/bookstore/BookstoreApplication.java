package lt.codeacademy.bookstore;

        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
        System.out.println("Application started");
    }

}

