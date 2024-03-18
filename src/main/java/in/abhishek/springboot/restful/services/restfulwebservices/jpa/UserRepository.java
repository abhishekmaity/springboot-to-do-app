package in.abhishek.springboot.restful.services.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhishek.springboot.restful.services.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
