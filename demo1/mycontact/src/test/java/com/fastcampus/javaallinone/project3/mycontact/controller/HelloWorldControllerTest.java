package com.fastcampus.javaallinone.project3.mycontact.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //테스트 어노테이션
class HelloWorldControllerTest {

    @Autowired
    private HelloWorldController helloWorldController;
    // 스프링컨텍스트에서 해당 Bean을 주입하겠다는 말

    private MockMvc mockMvc;


    @Test
    void helloWorld(){  //Junit5 이상에서는 public 접근자를 안붙여도된다
        // 빼는 경우 기본접근자로 되며 동일한 패키지 내에서만 접근가능해진다.
//        System.out.println("test"); //sout이라고 치면 System.out.println가 쳐짐
        System.out.println(helloWorldController.helloWorld());
        Assertions.assertEquals(helloWorldController.helloWorld(), "HelloWorld");
        // 검증용 코드
    }

    @Test
    void mockMvcTest() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld"))
        .andDo(MockMvcResultHandlers.print()) // request와 response에 대해 좀더 구체적인 정보를 나오게 함(.andDo)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));

    }

}