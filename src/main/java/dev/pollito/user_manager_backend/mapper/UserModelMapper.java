package dev.pollito.user_manager_backend.mapper;

import dev.pollito.user_manager_backend.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserModelMapper {
  List<User> map(List<com.typicode.jsonplaceholder.model.User> users);
}
