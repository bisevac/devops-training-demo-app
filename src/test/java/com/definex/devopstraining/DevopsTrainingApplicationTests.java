package com.definex.devopstraining;

import com.definex.devopstraining.data.dao.BookRepository;
import com.definex.devopstraining.data.model.Book;
import com.definex.devopstraining.service.BookService;
import com.definex.devopstraining.service.model.BookDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DevopsTrainingApplicationTests {

   @Autowired
    private BookService bookservice;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void getBookTest(){
        Mockito.when(bookRepository.findAll()).thenReturn(Stream.of(new Book(), new Book()).collect(Collectors.toList()));
        List<BookDto> bookList = bookservice.findAll();
        assertEquals(2,bookList.size());
    }
}
