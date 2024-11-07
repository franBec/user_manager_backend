package dev.pollito.user_manager_backend.mapper;

import dev.pollito.user_manager_backend.model.Device;
import dev.pollito.user_manager_backend.model.Devices;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceModelMapper {
  Device map(dev.pollito.user_manager_backend.entity.Device deviceEntity);

  Devices map(Page<dev.pollito.user_manager_backend.entity.Device> devicePage);
}
