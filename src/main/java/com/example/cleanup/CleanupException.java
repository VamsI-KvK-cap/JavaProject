package com.example.cleanup;

public class CleanupException extends RuntimeException {
    public CleanupException(String message) {
        super(message);
    }
}

package com.example.cleanup;

public class CleanupService {
    public void cleanup() {
        try {
            // Cleanup logic here
        } catch (Exception e) {
            throw new CleanupException("Error during cleanup process: " + e.getMessage());
        }
    }
}