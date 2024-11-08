package dev.pollito.user_manager_backend.converter;

import dev.pollito.user_manager_backend.model.UserSortProperty;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserSortPropertyConverter implements Converter<String, UserSortProperty> {
  @Override
  public UserSortProperty convert(@NotNull String source) {
    return UserSortProperty.fromValue(source);
  }
}
