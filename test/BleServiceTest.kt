package com.pixelwatch.core

import org.junit.Test
import org.junit.Assert.*

class BleServiceTest {
    @Test
    fun testInit() {
        val context = /* get test Context */
        val bleService = BleService(context)
        assertNotNull(bleService)
    }
}
