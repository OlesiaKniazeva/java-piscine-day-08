package school21.spring.service.services;

import school21.spring.service.repositories.UsersRepository;

public interface UsersService extends UsersRepository {
    String signUp(String email);

}
