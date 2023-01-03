package br.marksouzza.expensetrackerapi.service;


import br.marksouzza.expensetrackerapi.domain.User;
import br.marksouzza.expensetrackerapi.domain.UserModel;

public interface UserService {
    User create (UserModel user);
    User read (Long id);
    User update (UserModel user, Long id);
    void delete (Long id);
}
