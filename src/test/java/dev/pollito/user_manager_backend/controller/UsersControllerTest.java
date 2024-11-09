package dev.pollito.user_manager_backend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import dev.pollito.user_manager_backend.model.SortDirection;
import dev.pollito.user_manager_backend.model.User;
import dev.pollito.user_manager_backend.model.UserRequestBody;
import dev.pollito.user_manager_backend.model.UserRequestBodyMinimumRequired;
import dev.pollito.user_manager_backend.model.UserSortProperty;
import dev.pollito.user_manager_backend.model.Users;
import dev.pollito.user_manager_backend.service.UsersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UsersControllerTest {
  @InjectMocks private UsersController usersController;

  @Mock private UsersService usersService;

  @Test
  void whenFindAllThenReturnOk() {
    when(usersService.findAll(any(PageRequest.class), anyString())).thenReturn(mock(Users.class));
    ResponseEntity<Users> response =
        usersController.findAll(0, 10, UserSortProperty.ID, SortDirection.ASC, "brand");
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  void whenDeleteByIdThenReturnNotImplemented() {
    assertEquals(HttpStatus.NOT_IMPLEMENTED, usersController.deleteById(1L).getStatusCode());
  }

  @Test
  void whenFindByIdThenReturnNotImplemented() {
    when(usersService.findById(anyLong())).thenReturn(mock(User.class));
    ResponseEntity<User> response = usersController.findById(1L);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  void whenPartialUpdateByIdThenReturnNotImplemented() {
    assertEquals(
        HttpStatus.NOT_IMPLEMENTED,
        usersController.partialUpdateById(1L, mock(UserRequestBody.class)).getStatusCode());
  }

  @Test
  void whenUpdateByIdThenReturnNotImplemented() {
    assertEquals(
        HttpStatus.NOT_IMPLEMENTED,
        usersController.updateById(1L, mock(UserRequestBodyMinimumRequired.class)).getStatusCode());
  }

  @Test
  void whenCreateThenReturnNotImplemented() {
    assertEquals(
        HttpStatus.NOT_IMPLEMENTED,
        usersController.create(mock(UserRequestBodyMinimumRequired.class)).getStatusCode());
  }
}
