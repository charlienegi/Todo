package com.project.Todo.Repository;

import com.project.Todo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {
    public User findByUsername(String Username);
}
