package dev.pollito.user_manager_backend.controller;

import dev.pollito.user_manager_backend.api.UsersApi;
import dev.pollito.user_manager_backend.model.SortDirection;
import dev.pollito.user_manager_backend.model.User;
import dev.pollito.user_manager_backend.model.UserRequestBody;
import dev.pollito.user_manager_backend.model.UserRequestBodyMinimumRequired;
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
  public ResponseEntity<Void> deleteById(Long id) {
    return UsersApi.super.deleteById(id);
  }

  @Override
  public ResponseEntity<User> findById(Long id) {
    return ResponseEntity.ok(usersService.findById(id));
  }

  @Override
  public ResponseEntity<User> partialUpdateById(Long id, UserRequestBody userRequestBody) {
    return UsersApi.super.partialUpdateById(id, userRequestBody);
  }

  @Override
  public ResponseEntity<User> updateById(
      Long id, UserRequestBodyMinimumRequired userRequestBodyMinimumRequired) {
    return UsersApi.super.updateById(id, userRequestBodyMinimumRequired);
  }

  @Override
  public ResponseEntity<User> create(
      UserRequestBodyMinimumRequired userRequestBodyMinimumRequired) {
    return UsersApi.super.create(userRequestBodyMinimumRequired);
  }
}
