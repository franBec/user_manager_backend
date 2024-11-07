package dev.pollito.user_manager_backend.repository;

import dev.pollito.user_manager_backend.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeviceRepository extends JpaRepository<Device, Long> {
  @Query(
      "SELECT d FROM Device d WHERE :brand IS NULL OR :brand = '' OR LOWER(d.brand) LIKE LOWER(CONCAT('%', :brand, '%'))")
  Page<Device> findAllByBrandContainingIgnoreCase(Pageable pageable, @Param("brand") String brand);
}
