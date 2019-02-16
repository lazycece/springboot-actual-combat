package com.lazycece.sbac.elasticsearch.controller;

import com.lazycece.sbac.elasticsearch.entity.Book;
import com.lazycece.sbac.elasticsearch.repository.BookEsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2018/10/16
 */
@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchDemoController {

    @Autowired
    private BookEsRepository bookEsRepository;

    @GetMapping("/demo")
    public Object demo() {
        return "welcome to elasticsearch cluster demo ...";
    }

    @GetMapping("/book/add")
    public Object reportBook(Book book) {
        if (book.getName() == null || "".equals(book.getName().trim())) {
            return "report boot fail: name is null ...";
        }
        bookEsRepository.save(book);
        return "report book success ...";
    }

    @GetMapping("/book/info")
    public Object bookInfo(@RequestParam String name) {
        return bookEsRepository.findByName(name);
    }
}
