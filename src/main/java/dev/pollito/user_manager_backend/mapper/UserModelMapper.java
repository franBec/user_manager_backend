package dev.pollito.user_manager_backend.mapper;

import dev.pollito.user_manager_backend.model.User;
import dev.pollito.user_manager_backend.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserModelMapper {
  User map(dev.pollito.user_manager_backend.entity.User userEntity);

  Users map(Page<dev.pollito.user_manager_backend.entity.User> userPage);
}
