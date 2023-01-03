package br.marksouzza.expensetrackerapi.implementation;

import br.marksouzza.expensetrackerapi.domain.User;
import br.marksouzza.expensetrackerapi.domain.UserModel;
import br.marksouzza.expensetrackerapi.exception.ItemAlreadyExistsException;
import br.marksouzza.expensetrackerapi.exception.ResourceNotFoundException;
import br.marksouzza.expensetrackerapi.repository.UserRepository;
import br.marksouzza.expensetrackerapi.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    public User create(UserModel userModel) {
        if (userRepo.existsByEmail(userModel.getEmail())) {
            throw new ItemAlreadyExistsException("User is already registered with email: " + userModel.getEmail());
        }
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        return userRepo.save(user);
    }

    @Override
    public User read(Long id) throws ResourceNotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id: " + id));
    }

    @Override
    public User update(UserModel user, Long id) throws ResourceNotFoundException {
        User existingUser = read(id);
        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
        return userRepo.save(existingUser);
    }

    @Override
    public void delete(Long id){
        User existingUser = read(id);
        userRepo.delete(existingUser);
    }
}
