package uz.isystem.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.market.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findAllByIdAndDeletedAtIsNull(Integer id);
}
