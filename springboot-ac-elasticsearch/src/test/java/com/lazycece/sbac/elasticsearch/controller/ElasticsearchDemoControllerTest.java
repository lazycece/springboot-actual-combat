package com.lazycece.sbac.elasticsearch.controller;

import com.lazycece.sbac.elasticsearch.entity.Book;
import com.lazycece.sbac.elasticsearch.repository.BookEsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDemoControllerTest implements Consumer<Book>{


    @Resource
    ElasticsearchTemplate elasticsearchTemplate;
    @Resource
    private BookEsRepository bookEsRepository;

	@Test
	public void testElasticsearch() {
        Iterable<Book> books = bookEsRepository.findAll();
        books.forEach(this);
        System.out.println("==================");
	}

	@Test
    public void testElasticsearchInsert(){
	    Book book = Book.builder()
                .name("elasticsearch")
                .page(1000000).reportTime(new Date())
                .desc("report a elasticsearch boot")
                .build();
	    bookEsRepository.save(book);
        System.out.println("finish insert a book of 'elasticsearch'");
    }

    @Override
    public void accept(Book book) {
        System.out.println(book.toString());
    }

    @Override
    public Consumer<Book> andThen(Consumer<? super Book> after) {
        return null;
    }
}
