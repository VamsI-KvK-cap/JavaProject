package com.example.systemoptions;

public class SystemOptionsException extends Exception {
    public SystemOptionsException(String message) {
        super(message);
    }

    public SystemOptionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemOptionsException(Throwable cause) {
        super(cause);
    }
}

package com.example.systemoptions;

import java.util.Objects;

public class SystemOptionsService {
    public void initializeOptions() throws SystemOptionsException {
        try {
            // Initialization logic
            validateOptions();
        } catch (IllegalArgumentException e) {
            throw new SystemOptionsException("Validation error during system options initialization", e);
        } catch (Exception e) {
            throw new SystemOptionsException("An error occurred during system options initialization", e);
        }
    }

    private void validateOptions() {
        // Validation logic that may throw IllegalArgumentException
    }
}