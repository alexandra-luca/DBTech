import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import java.util.List;
import java.util.stream.Collectors;

public class MyPostMain {

    public static void main(String[] args) {
        PostClient postClient = Feign.builder()
                .client(new OkHttpClient())
//                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(PostClient.class))
                .logLevel(Logger.Level.FULL)
                .target(PostClient.class, "https://jsonplaceholder.typicode.com/posts");

//        String strResp = postClient.findAsString();
//        System.out.println("Receied " + strResp);

        List<Post> posts = postClient.findAll().stream()
                .map(PostResource::getPost)
                .collect(Collectors.toList());
        System.out.println("Posts: " + posts.size() + " , " + posts);
        for (Post post: posts
             ) {
            System.out.println("New Post: " + post);
        }
    }
}
