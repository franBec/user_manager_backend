package dev.pollito.user_manager_backend.service.impl;

import dev.pollito.user_manager_backend.mapper.UserModelMapper;
import dev.pollito.user_manager_backend.model.User;
import dev.pollito.user_manager_backend.model.Users;
import dev.pollito.user_manager_backend.repository.UserRepository;
import dev.pollito.user_manager_backend.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
  private final UserRepository userRepository;
  private final UserModelMapper userModelMapper;

  @Override
  public User findById(Long id) {
    return userModelMapper.map(userRepository.findById(id).orElseThrow());
  }

  @Override
  public Users findAll(PageRequest pageRequest, String q) {
    return userModelMapper.map(userRepository.findAllByQueryContainingIgnoreCase(pageRequest, q));
  }
}
