package br.marksouzza.expensetrackerapi.service;


import br.marksouzza.expensetrackerapi.domain.User;
import br.marksouzza.expensetrackerapi.domain.UserModel;

public interface UserService {
    User createUser (UserModel user);
    User read (Long id);
}
