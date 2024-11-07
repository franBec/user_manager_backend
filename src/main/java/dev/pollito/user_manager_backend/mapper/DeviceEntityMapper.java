package dev.pollito.user_manager_backend.mapper;

import dev.pollito.user_manager_backend.entity.Device;
import dev.pollito.user_manager_backend.model.DeviceRequestBodyRequiredProperties;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceEntityMapper {
  Device map(DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties);
}
