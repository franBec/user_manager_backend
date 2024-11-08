package dev.pollito.user_manager_backend.mapper;

import dev.pollito.user_manager_backend.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserModelMapper {
  Users map(Page<dev.pollito.user_manager_backend.entity.User> userPage);
}
