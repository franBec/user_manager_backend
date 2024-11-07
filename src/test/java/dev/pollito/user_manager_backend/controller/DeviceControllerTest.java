package dev.pollito.user_manager_backend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.pollito.user_manager_backend.model.Device;
import dev.pollito.user_manager_backend.model.DeviceRequestBody;
import dev.pollito.user_manager_backend.model.DeviceRequestBodyRequiredProperties;
import dev.pollito.user_manager_backend.model.DeviceSortProperty;
import dev.pollito.user_manager_backend.model.Devices;
import dev.pollito.user_manager_backend.model.SortDirection;
import dev.pollito.user_manager_backend.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class DeviceControllerTest {
  @InjectMocks private DeviceController deviceController;

  @Mock private DeviceService deviceService;

  @Test
  void whenAddDeviceThenReturnCreated() {
    when(deviceService.addDevice(any(DeviceRequestBodyRequiredProperties.class)))
        .thenReturn(mock(Device.class));

    ResponseEntity<Device> response =
        deviceController.addDevice(mock(DeviceRequestBodyRequiredProperties.class));
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  void whenDeleteDeviceThenReturnNoContent() {
    doNothing().when(deviceService).deleteDevice(anyInt());
    ResponseEntity<Void> response = deviceController.deleteDevice(1);
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    assertNull(response.getBody());
    verify(deviceService).deleteDevice(anyInt());
  }

  @Test
  void whenGetAllThenReturnOk() {
    when(deviceService.getAll(any(PageRequest.class), anyString())).thenReturn(mock(Devices.class));
    ResponseEntity<Devices> response =
        deviceController.getAll(0, 10, DeviceSortProperty.ID, SortDirection.ASC, "brand");
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  void whenGetDeviceThenReturnOk() {
    when(deviceService.getDevice(anyInt())).thenReturn(mock(Device.class));
    ResponseEntity<Device> response = deviceController.getDevice(1);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  void whenPartialUpdateDeviceThenReturnOk() {
    when(deviceService.partialUpdateDevice(anyInt(), any(DeviceRequestBody.class)))
        .thenReturn(mock(Device.class));
    ResponseEntity<Device> response =
        deviceController.partialUpdateDevice(1, mock(DeviceRequestBody.class));
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }

  @Test
  void whenUpdateDeviceThenReturnOk() {
    when(deviceService.updateDevice(anyInt(), any(DeviceRequestBodyRequiredProperties.class)))
        .thenReturn(mock(Device.class));
    ResponseEntity<Device> response =
        deviceController.updateDevice(1, mock(DeviceRequestBodyRequiredProperties.class));
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
  }
}
