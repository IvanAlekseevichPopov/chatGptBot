package com.telegram.bot.Repository;

import com.telegram.bot.Entity.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByExternalId(@NotBlank Long id);
}
