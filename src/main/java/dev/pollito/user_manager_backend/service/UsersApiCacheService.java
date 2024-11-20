package dev.pollito.user_manager_backend.service;

import com.typicode.jsonplaceholder.model.User;
import java.util.List;

public interface UsersApiCacheService {
  List<User> getUsers();
}
