import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.JDKRandomGenerator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class MySubmain {

    public static void main(String[] args) {
        System.out.println("Hello from submain");

        Pair<String, String> myPair = new ImmutablePair<String, String>("student_submodule", "Ana");
        System.out.println(myPair.getLeft() + " is " + myPair.getRight());

        GaussianRandomGenerator gaussianRandomGenerator = new GaussianRandomGenerator(new JDKRandomGenerator());
        System.out.println("Your next double is " + gaussianRandomGenerator.nextNormalizedDouble());

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build(); // setare "browser" (clientul)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .timeout(Duration.ofSeconds(20))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
