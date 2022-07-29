package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.services.UsersService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//
        UsersService service = context.getBean("UsersServiceImpl", UsersService.class);
//
        System.out.println(service.findAll());
        System.out.println("kk");
    }

//    public static void printResult(ApplicationContext context, UsersRepository usersRepository) {
//
//        System.out.println("Find by email result:\n" + usersRepository.findByEmail("byurv@gmail.com").get());
//        System.out.println("Find all result:\n" + usersRepository.findAll());
//        usersRepository.delete(4L);
//        System.out.println("Result after delete:\n" + usersRepository.findAll());
//        System.out.println("Find by id result:\n" + usersRepository.findById(2L));
//        User userToSave = new User(null, "ffffff@mail.ru");
//        usersRepository.save(userToSave);
//        System.out.println("New saved user — updated id: " + userToSave);
//        System.out.println("New saved user in database: " + usersRepository.findById(userToSave.getId()));
//
//        userToSave.setEmail("bbbu@gmail.com");
//        usersRepository.update(userToSave);
//        System.out.println("New updated user in database: " + usersRepository.findById(userToSave.getId()));
//    }
}
