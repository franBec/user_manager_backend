package dev.pollito.user_manager_backend.controller;

import dev.pollito.user_manager_backend.api.UsersApi;
import dev.pollito.user_manager_backend.model.SortDirection;
import dev.pollito.user_manager_backend.model.User;
import dev.pollito.user_manager_backend.model.UserSortProperty;
import dev.pollito.user_manager_backend.model.Users;
import dev.pollito.user_manager_backend.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {
  private final UsersService usersService;

  @Override
  public ResponseEntity<Users> findAll(
      Integer pageNumber,
      Integer pageSize,
      @NotNull UserSortProperty sortProperty,
      @NotNull SortDirection sortDirection,
      String q) {
    return ResponseEntity.ok(
        usersService.findAll(
            PageRequest.of(
                pageNumber,
                pageSize,
                Sort.Direction.fromString(sortDirection.getValue()),
                sortProperty.getValue()),
            q));
  }

  @Override
  public ResponseEntity<User> findById(Long id) {
    return ResponseEntity.ok(usersService.findById(id));
  }
}
