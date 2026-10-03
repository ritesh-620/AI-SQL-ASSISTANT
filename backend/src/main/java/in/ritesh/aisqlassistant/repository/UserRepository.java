package in.ritesh.aisqlassistant.repository;


import in.ritesh.aisqlassistant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
