package com.example.cleanup;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CleanupServiceTest {

    private final CleanupService cleanupService = new CleanupService();

    @Test
    void testFinalizeSystemOptionsSuccessful() {
        SystemOptions options = new SystemOptions();
        options.setSomeProperty("value");

        assertDoesNotThrow(() -> cleanupService.finalizeSystemOptions(options));
    }

    @Test
    void testFinalizeSystemOptionsNullOptions() {
        assertThrows(CleanupException.class, () -> cleanupService.finalizeSystemOptions(null));
    }

    @Test
    void testFinalizeSystemOptionsEmptyOptions() {
        SystemOptions options = new SystemOptions();
        options.setSomeProperty("");

        assertThrows(CleanupException.class, () -> cleanupService.finalizeSystemOptions(options));
    }

    @Test
    void testFinalizeSystemOptionsMalformedOptions() {
        SystemOptions options = new SystemOptions();
        options.setSomeProperty("malformed");

        assertThrows(CleanupException.class, () -> cleanupService.finalizeSystemOptions(options));
    }

    @Test
    void testFinalizeSystemOptionsThrowsException() {
        SystemOptions options = mock(SystemOptions.class);
        doThrow(new RuntimeException("Error")).when(options).validate();

        assertThrows(CleanupException.class, () -> cleanupService.finalizeSystemOptions(options));
    }

    @Test
    void testFinalizeSystemOptionsHandlesSpecificException() {
        SystemOptions options = mock(SystemOptions.class);
        doThrow(new IllegalArgumentException("Invalid argument")).when(options).validate();

        assertThrows(CleanupException.class, () -> cleanupService.finalizeSystemOptions(options));
    }
}