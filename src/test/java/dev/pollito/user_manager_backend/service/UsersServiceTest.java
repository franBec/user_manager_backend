package dev.pollito.user_manager_backend.service;

import static dev.pollito.user_manager_backend.MockData.USERS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import dev.pollito.user_manager_backend.mapper.UserModelMapper;
import dev.pollito.user_manager_backend.model.SortDirection;
import dev.pollito.user_manager_backend.model.UserSortProperty;
import dev.pollito.user_manager_backend.model.Users;
import dev.pollito.user_manager_backend.service.impl.UsersApiCacheServiceImpl;
import dev.pollito.user_manager_backend.service.impl.UsersServiceImpl;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {
  @InjectMocks private UsersServiceImpl usersService;
  @Mock private UsersApiCacheServiceImpl usersApi;

  @SuppressWarnings("unused")
  @Spy
  private UserModelMapper userModelMapper = Mappers.getMapper(UserModelMapper.class);

  @BeforeEach
  void setUp() {
    when(usersApi.getUsers()).thenReturn(USERS);
  }

  @Test()
  void whenGetUsersThenReturnUserList() {
    Users response = usersService.findAll(0, 10, UserSortProperty.ID, SortDirection.ASC, null);
    assertEquals(10, response.getTotalElements());
    assertEquals(0, response.getPageable().getPageNumber());
    assertEquals(10, response.getPageable().getPageSize());
    assertEquals(1, response.getContent().getFirst().getId());
    assertEquals(10, response.getContent().getLast().getId());
  }

  @Test()
  void whenGetUsersDescThenReturnUserListDesc() {
    Users response = usersService.findAll(0, 10, UserSortProperty.ID, SortDirection.DESC, null);
    assertEquals(10, response.getContent().getFirst().getId());
    assertEquals(1, response.getContent().getLast().getId());
  }

  @Test
  void whenGetUsersWithQThenReturnSubList() {
    Users lePage0 = usersService.findAll(0, 5, UserSortProperty.ID, SortDirection.ASC, "le");
    Users lePage1 = usersService.findAll(1, 5, UserSortProperty.ID, SortDirection.ASC, "le");
    Users biz = usersService.findAll(0, 10, UserSortProperty.ID, SortDirection.ASC, "biz");
    assertEquals(5, lePage0.getContent().size());
    assertEquals(2, lePage1.getContent().size());
    assertEquals(3, biz.getTotalElements());
  }

  @Test
  void whenSortByPropertyThenReturnSortedList() {
    Users sortByEmail =
        usersService.findAll(0, 10, UserSortProperty.EMAIL, SortDirection.ASC, null);
    Users sortByName = usersService.findAll(0, 10, UserSortProperty.NAME, SortDirection.ASC, null);
    Users sortByUsername =
        usersService.findAll(0, 10, UserSortProperty.USERNAME, SortDirection.ASC, null);

    assertEquals("Chaim_McDermott@dana.io", sortByEmail.getContent().getFirst().getEmail());
    assertEquals("Telly.Hoeger@billy.biz", sortByEmail.getContent().getLast().getEmail());

    assertEquals("Chelsey Dietrich", sortByName.getContent().getFirst().getName());
    assertEquals("Patricia Lebsack", sortByName.getContent().getLast().getName());

    assertEquals("Antonette", sortByUsername.getContent().getFirst().getUsername());
    assertEquals("Samantha", sortByUsername.getContent().getLast().getUsername());
  }

  @Test
  void whenGetUserThenReturnUser() {
    assertNotNull(usersService.findById(1L));
  }

  @Test
  void whenGetUserThatDoesntExistThenThrowException() {
    assertThrows(NoSuchElementException.class, () -> usersService.findById(-1L));
  }
}
