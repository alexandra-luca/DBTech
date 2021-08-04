package shopifyadvanced.components;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("user")
@Log
@Primary
public class ProdBean {

    public ProdBean()
    {
        System.out.println("Prod bean constructor");
    }



    @PostConstruct
    void pc()
    {
        log.info("User");
    }
}
