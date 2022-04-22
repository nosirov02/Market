package uz.isystem.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.isystem.market.model.UserType;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Integer > {

    @Query("select u from UserType u where u.name = ?1")
    List<UserType> findAllByName(String name);

    @Query("select u from UserType u where u.id = ?1")
    Optional<UserType> findById(Integer id);
}
