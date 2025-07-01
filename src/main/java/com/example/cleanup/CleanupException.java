package com.example.cleanup;

public class CleanupException extends Exception {
    public CleanupException(String message) {
        super(message);
    }

    public CleanupException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.example.cleanup;

import java.util.List;

public class CleanupService {
    public void cleanup() throws CleanupException {
        try {
            List<String> resources = getResourcesToCleanup();
            for (String resource : resources) {
                releaseResource(resource);
            }
        } catch (Exception e) {
            throw new CleanupException("Error during cleanup process: " + e.getMessage(), e);
        }
    }

    private List<String> getResourcesToCleanup() {
        // Implementation to retrieve resources
        return List.of("resource1", "resource2");
    }

    private void releaseResource(String resource) {
        // Implementation to release the resource
    }
}