import feign.RequestLine;

import java.util.List;

public interface PostClient {

    @RequestLine("GET")
    List<PostResource> findAll();

    @RequestLine("GET")
    String findAsString();

}
