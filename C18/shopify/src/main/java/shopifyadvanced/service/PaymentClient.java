package shopifyadvanced.service;


import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shopifyadvanced.dto.CardModel;

@FeignClient(value="payment",url="http://localhost:8081")
public interface PaymentClient {

    @RequestMapping(method = RequestMethod.POST, value = "/payment")
    public String postCard(@RequestBody CardModel cardModel);

}
