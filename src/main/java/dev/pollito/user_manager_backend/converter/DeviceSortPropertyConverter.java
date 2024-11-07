package dev.pollito.user_manager_backend.converter;

import dev.pollito.user_manager_backend.model.DeviceSortProperty;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DeviceSortPropertyConverter implements Converter<String, DeviceSortProperty> {
  @Override
  public DeviceSortProperty convert(@NotNull String source) {
    return DeviceSortProperty.fromValue(source);
  }
}
