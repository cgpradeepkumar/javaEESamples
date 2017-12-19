package sample.demo.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.demo.database.jpa.Role;

/**
 * Created by pkumar on 29/6/17.
 */
public interface RoleRepository extends JpaRepository<Role, String> {

    List<Role> findAll();
}
