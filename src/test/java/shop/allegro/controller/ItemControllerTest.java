package shop.allegro.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("상품 등록 페이지 등록 테스트")
    @WithMockUser(username = "admin", roles = "ADMIN")
    // 회원 이름이 admin 이고 role 이 ADMIN 인 유저가 로그인된 상태로 테스트할 수 있게 해주는 어노ㅔ이션
    public void itemFormTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new"))  //상품 등록 페이지에 get 요청
                .andDo(print())     // 요청과 응답 메세지를 확인할 수 있도록 콘솔창에 출력
                .andExpect(status().isOk());    // 응답 상태 코드가 정상인지 확인
    }

    @Test
    @DisplayName("상품 등록 페이지 일반 권한 등록 테스트")
    @WithMockUser(username = "user", roles = "USER")
    public void itemFormNotAdminTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}