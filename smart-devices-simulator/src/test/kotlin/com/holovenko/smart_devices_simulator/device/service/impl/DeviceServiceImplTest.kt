package com.holovenko.smart_devices_simulator.device.service.impl

import com.holovenko.smart_devices_simulator.device.repository.DeviceRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any

@ExtendWith(MockitoExtension::class)
internal class DeviceServiceImplTest {

    @Mock
    private lateinit var deviceRepository: DeviceRepository

    @InjectMocks
    private lateinit var deviceService: DeviceServiceImpl

    @Test
    fun `correct amount of save call was made to repository`() {
        deviceService.createRandomDevices(5)
        verify(deviceRepository, times(5)).create(any())
    }

}