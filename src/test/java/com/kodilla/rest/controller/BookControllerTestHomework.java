package com.kodilla.rest.controller;

import com.kodilla.rest.controller.BookController;
import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BookControllerTestHomework {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    private BookController bookController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bookController = new BookController(bookService);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void shouldAddBook() throws Exception {

        // Given
        String jsonBook = "{\"title\":\"The Catcher in the Rye\",\"author\":\"J.D. Salinger\"}";

        // When
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBook))
                // Then
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Add additional assertions or verifications if needed
    }
}