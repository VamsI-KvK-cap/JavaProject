package com.example.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiService {

    public void initializeSystemOptions() throws IOException {
        String response = callExternalApi("http://example.com/api/IOCHP01L1R");
        handleResponse(response);
    }

    public void finalizeSystemOptions() throws IOException {
        String response = callExternalApi("http://example.com/api/UTCHP01");
        handleResponse(response);
    }

    private String callExternalApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error: " + responseCode);
        }

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        return response.toString();
    }

    private void handleResponse(String response) {
        // Process the response as needed
    }
}