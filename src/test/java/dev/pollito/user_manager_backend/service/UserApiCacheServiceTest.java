package dev.pollito.user_manager_backend.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.typicode.jsonplaceholder.api.UserApi;
import com.typicode.jsonplaceholder.model.User;
import dev.pollito.user_manager_backend.service.impl.UsersApiCacheServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserApiCacheServiceTest {
  @InjectMocks private UsersApiCacheServiceImpl usersApiCacheService;
  @Mock private UserApi userApi;

  @Test
  void whenDelegateIsCalledThenExpectedBehaviour() {
    when(userApi.getUsers()).thenReturn(List.of(mock(User.class)));
    assertFalse(usersApiCacheService.getUsers().isEmpty());
  }
}
