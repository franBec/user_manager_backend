package dev.pollito.user_manager_backend.service;

import dev.pollito.user_manager_backend.model.Users;
import org.springframework.data.domain.PageRequest;

public interface UsersService {
  Users findAllByQueryContainingIgnoreCase(PageRequest pageRequest, String q);
}
