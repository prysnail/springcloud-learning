package com.prysnail.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "ribbon-consumer" , method = RequestMethod.GET)
    public String helloConsumer(){
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }

    /**
     * Ribbon负载均衡示例
     *
     */
    class RibbonDemo{
        /**
         *
         * 1. Get请求
         * @return
         */
        public String GetInvoke(){
            /**
             * 一、1.常用方式
             */
            ResponseEntity<String> responseEntity =
                    restTemplate.getForEntity("http://hello-service/hello?name={1}" , String.class , "didi");
            String body = responseEntity.getBody();

            /**
             * 一、2.Map封装参数
             */

            Map<String,String> params = new HashMap<>();
            params.put("name","didi");
            restTemplate.getForEntity("http://hello-service/hello?name={name}",String.class,params);


            /**
             * 二、getForObject
             */
            String res = restTemplate.getForObject("http://hello-service/hello?name={1}",String.class,"didi");

            return res;
        }

        /**
         * 2. Post请求
         * @return
         */
        public String PostInvoke(){
            /**
             * 1.postForEntity
             */
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity("http://hello-service/hello",new String(), String.class);
            String body = responseEntity.getBody();

            /**
             * 2.postForObject
             */

            String res = restTemplate.postForObject("http://hello-service/hello",new String(), String.class);

            /**
             * 3.postForLocation
             */
            URI uri = restTemplate.postForLocation("http://hello-service/hello",new String(), String.class);

            return res;
        }

        /**
         * 3. Put请求
         */
        public void PutInvoke(){
            restTemplate.put("http://hello-service/hello/{1}",new String() , 100L);
        }

        /**
         * 4. Delete请求
         */
        public void DelInvoke(){
            restTemplate.delete("");
        }
    }
}
