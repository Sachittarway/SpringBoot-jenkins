package com.lovetolearn.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot!";
    }
    @GetMapping("/getCast")
    public String getMovieCast() {
        String apiUrl = "https://imdb236.p.rapidapi.com/imdb/tt7631058/cast";
        String apiKey = "8517b5345cmsh6de4a4a5c757b90p140a8ejsn3f9ef65ace6c"; 
        String apiHost = "imdb236.p.rapidapi.com";

        try (AsyncHttpClient client = new DefaultAsyncHttpClient()) {
            CompletableFuture<Response> futureResponse = client.prepareGet(apiUrl)
                    .setHeader("x-rapidapi-key", apiKey)
                    .setHeader("x-rapidapi-host", apiHost)
                    .execute()
                    .toCompletableFuture();

            Response response = futureResponse.get(); // Blocking call to get response
            return response.getResponseBody();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return "Error fetching data: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Unexpected error: " + e.getMessage();
        }
    }
}
