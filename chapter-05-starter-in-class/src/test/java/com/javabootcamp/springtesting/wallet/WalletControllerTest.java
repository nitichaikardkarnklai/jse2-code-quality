package com.javabootcamp.springtesting.wallet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {
    MockMvc mockMvc;

    @Mock
    WalletService walletService;
    @BeforeEach
    void setUp() {
        WalletController walletController = new WalletController(walletService);
        mockMvc = MockMvcBuilders.standaloneSetup(walletController)
//                .alwaysDo(print()) // for investigation
                .build();
    }

    @Test
    @DisplayName("when perform on GET: /api/wallets/me should return Hello, Wallet!")
    void walletMessage() throws Exception {
        mockMvc.perform(get("/api/wallets/me"))
                .andExpect(jsonPath("$.message", is("Hello, Wallet!")))
                .andExpect(status().isOk());
    }
}