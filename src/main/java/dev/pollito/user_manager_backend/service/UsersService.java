package dev.pollito.user_manager_backend.service;

import dev.pollito.user_manager_backend.model.User;
import dev.pollito.user_manager_backend.model.Users;
import org.springframework.data.domain.PageRequest;

public interface UsersService {
  User findById(Long id);

  Users findAllByQueryContainingIgnoreCase(PageRequest pageRequest, String q);
}
