package dev.pollito.user_manager_backend.service;

import dev.pollito.user_manager_backend.model.Device;
import dev.pollito.user_manager_backend.model.DeviceRequestBody;
import dev.pollito.user_manager_backend.model.DeviceRequestBodyRequiredProperties;
import dev.pollito.user_manager_backend.model.Devices;
import org.springframework.data.domain.PageRequest;

public interface DeviceService {
  Device addDevice(DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties);

  Void deleteDevice(Integer id);

  Devices getAll(PageRequest pageRequest, String brand);

  Device getDevice(Integer id);

  Device partialUpdateDevice(Integer id, DeviceRequestBody deviceRequestBody);

  Device updateDevice(
      Integer id, DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties);
}
