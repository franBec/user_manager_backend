package dev.pollito.user_manager_backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.pollito.user_manager_backend.entity.Device;
import dev.pollito.user_manager_backend.mapper.DeviceEntityMapper;
import dev.pollito.user_manager_backend.mapper.DeviceModelMapper;
import dev.pollito.user_manager_backend.model.DeviceRequestBody;
import dev.pollito.user_manager_backend.model.DeviceRequestBodyRequiredProperties;
import dev.pollito.user_manager_backend.repository.DeviceRepository;
import dev.pollito.user_manager_backend.service.impl.DeviceServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {
  @InjectMocks private DeviceServiceImpl deviceService;

  @Mock private DeviceRepository deviceRepository;

  @SuppressWarnings("unused")
  @Spy
  private DeviceEntityMapper deviceEntityMapper = Mappers.getMapper(DeviceEntityMapper.class);

  @SuppressWarnings("unused")
  @Spy
  private DeviceModelMapper deviceModelMapper = Mappers.getMapper(DeviceModelMapper.class);

  @Test
  void whenAddDeviceThenReturnDevice() {
    when(deviceRepository.save(any(Device.class))).thenReturn(new Device());
    assertNotNull(deviceService.addDevice(mock(DeviceRequestBodyRequiredProperties.class)));
  }

  @Test
  void whenDeleteDeviceThenReturnNull() {
    when(deviceRepository.existsById(anyLong())).thenReturn(true);
    doNothing().when(deviceRepository).deleteById(anyLong());
    assertNull(deviceService.deleteDevice(1));
    verify(deviceRepository).deleteById(anyLong());
  }

  @Test
  void whenDeleteDeviceThenThrowNoSuchElementException() {
    when(deviceRepository.existsById(anyLong())).thenReturn(false);
    assertThrows(NoSuchElementException.class, () -> deviceService.deleteDevice(1));
  }

  @Test
  void whenGetAllThenReturnDevices() {
    when(deviceRepository.findAllByBrandContainingIgnoreCase(any(PageRequest.class), anyString()))
        .thenReturn((new PageImpl<>(List.of(), PageRequest.of(0, 10), 0)));
    assertNotNull(deviceService.getAll(mock(PageRequest.class), ""));
  }

  @Test
  void whenGetDeviceThenReturnDevice() {
    when(deviceRepository.findById(anyLong())).thenReturn(Optional.ofNullable(mock(Device.class)));
    assertNotNull(deviceService.getDevice(1));
  }

  @Test
  void whenPartialUpdateDeviceThenReturnDevice() {
    Device deviceEntity = mock(Device.class);
    when(deviceRepository.findById(anyLong())).thenReturn(Optional.of(deviceEntity));
    when(deviceRepository.save(any(Device.class))).thenReturn(mock(Device.class));

    DeviceRequestBody deviceRequestBody = mock(DeviceRequestBody.class);
    when(deviceRequestBody.getBrand()).thenReturn("brand");
    when(deviceRequestBody.getName()).thenReturn("name");

    assertNotNull(deviceService.partialUpdateDevice(1, deviceRequestBody));
    verify(deviceEntity).setBrand(anyString());
    verify(deviceEntity).setName(anyString());
  }

  @Test
  void whenUpdateDeviceThenReturnDevice() {
    Device deviceEntity = mock(Device.class);
    when(deviceRepository.findById(anyLong())).thenReturn(Optional.of(deviceEntity));
    when(deviceRepository.save(any(Device.class))).thenReturn(mock(Device.class));

    DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties =
        mock(DeviceRequestBodyRequiredProperties.class);
    when(deviceRequestBodyRequiredProperties.getBrand()).thenReturn("brand");
    when(deviceRequestBodyRequiredProperties.getName()).thenReturn("name");

    assertNotNull(deviceService.updateDevice(1, deviceRequestBodyRequiredProperties));
    verify(deviceEntity).setBrand(anyString());
    verify(deviceEntity).setName(anyString());
  }
}
