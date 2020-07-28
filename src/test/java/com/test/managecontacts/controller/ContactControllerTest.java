package com.test.managecontacts.controller;

import com.test.managecontacts.service.IcontactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContactController.class)
@WithMockUser
public class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IcontactService contactService;

    @Test
    public void getAllContacts() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/contacts");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println(response.getStatus());

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
