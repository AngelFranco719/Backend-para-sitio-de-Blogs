package com.web.bloggs.blog;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @CrossOrigin
    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{ID}")
    public ResponseEntity<Blog> getBlogByID(@PathVariable Long ID) {
        Optional<Blog> selectedBlog = blogRepository.findById(ID);
        return selectedBlog.map((ResponseEntity::ok)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        Blog nuevoBlog = blogRepository.save(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoBlog);
    }

    @CrossOrigin
    @DeleteMapping("/{ID}")
    public ResponseEntity<Blog> deleteBlogByID(@PathVariable Long ID) {
        if (!blogRepository.existsById(ID)) {
            return ResponseEntity.notFound().build();
        } else {
            blogRepository.deleteById(ID);
            return ResponseEntity.ok().build();
        }
    }

    @CrossOrigin
    @PutMapping("/{ID}")
    public ResponseEntity<Blog> updateElementByID(@PathVariable Long ID, @RequestBody Blog blog) {
        if(!blogRepository.existsById(ID)){
            return ResponseEntity.notFound().build(); 
        }
        else{
            blog.setID_Blog(ID);
            Blog updatedBlog=blogRepository.save(blog); 
            return ResponseEntity.ok(updatedBlog); 
        }
    }

}
