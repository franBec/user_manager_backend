package dev.pollito.user_manager_backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import dev.pollito.user_manager_backend.entity.User;
import dev.pollito.user_manager_backend.mapper.UserModelMapper;
import dev.pollito.user_manager_backend.repository.UserRepository;
import dev.pollito.user_manager_backend.service.impl.UsersServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {
  @InjectMocks private UsersServiceImpl usersService;

  @Mock private UserRepository userRepository;

  @SuppressWarnings("unused")
  @Spy
  private UserModelMapper userModelMapper = Mappers.getMapper(UserModelMapper.class);

  @Test
  void whenFindByIdThenReturnUser() {
    when(userRepository.findById(anyLong())).thenReturn(Optional.of(mock(User.class)));
    assertNotNull(usersService.findById(1L));
  }

  @Test
  void whenFindAllThenReturnUsers() {
    when(userRepository.findAllByQueryContainingIgnoreCase(any(PageRequest.class), anyString()))
        .thenReturn((new PageImpl<>(List.of(), PageRequest.of(0, 10), 0)));
    assertNotNull(usersService.findAll(mock(PageRequest.class), ""));
  }
}
