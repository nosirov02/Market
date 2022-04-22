package uz.isystem.market.service;

import org.springframework.stereotype.Service;
import uz.isystem.market.exception.ServerBadRequestException;
import uz.isystem.market.model.UserType;
import uz.isystem.market.repository.UserTypeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserTypeServise {
    private final UserTypeRepository userTypeRepository;

    public UserTypeServise(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;}
    public UserType get(Integer id){
        return getEntity(id);
    }

    public List<UserType> getByName(String name){
        List<UserType> userType = userTypeRepository.findAllByName(name);
        if(userType.isEmpty()){
            return null;
        }
        return userType;
    }

    public Boolean create(UserType userType){
        userType.setCreatedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        return true;
    }

    public UserType update(Integer id, UserType userType) {
        getEntity(id);
        userType.setUpdatedAt(LocalDateTime.now());
        userType.setId(id);
        userTypeRepository.save(userType);
            return userType;
    }
    public void delete(Integer id){
        UserType userType = getEntity(id);
        userType.setDeletedAt(LocalDateTime.now());
        userType.setStatus(String.valueOf(false));
        userTypeRepository.save(userType);
    }
    public UserType getEntity(Integer id){
        Optional<UserType> optional = userTypeRepository.findById(id);

        if(optional.isEmpty() || optional.get().getDeletedAt() != null){
            throw new ServerBadRequestException("user not  found");
        }
        return optional.get();
    }
}
