package com.example.reclaim;

import com.example.reclaim.service.ReclaimService;

public class ReclaimController {
    public static void main(String[] args) {
        String systemOptions = parseArguments(args);
        ReclaimService reclaimService = new ReclaimService();
        reclaimService.processReclaim(systemOptions);
    }

    private static String parseArguments(String[] args) {
        // Implement argument parsing logic here
        return args.length > 0 ? args[0] : "";
    }
}