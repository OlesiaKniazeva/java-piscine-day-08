package school21.spring.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Component("UsersServiceImpl")
public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;
    final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    SecureRandom rnd;

    @Autowired
    UsersServiceImpl(@Qualifier("usersRepositoryJdbcTemplate") UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        rnd = new SecureRandom();
    }

    private String passwordGenerator(int len) {
        StringBuilder sb = new StringBuilder(len);
            for( int i = 0; i < len; i++ )
                sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
            return sb.toString();
    }

    @Override
    public String signUp(String email) {
        String password = passwordGenerator(10);
        usersRepository.save(new User(null, email, password));
        return password;
    }

    @Override
    public User findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public void save(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void update(User entity) {
        usersRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        usersRepository.delete(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
