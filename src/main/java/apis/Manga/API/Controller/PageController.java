package apis.Manga.API.Controller;

import apis.Manga.API.entity.Page;
import apis.Manga.API.service.PageService;
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

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/auth/page")
public class PageController {

    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public ResponseEntity<List<Page>> getAllPages() {
        return ResponseEntity.ok(pageService.getAllPages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page> getPageById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(pageService.getPage(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Page> createPage(@RequestBody Page page) {
        Page saved = pageService.createPage(page);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Page> updatePage(@PathVariable Long id, @RequestBody Page page) {
        try {
            return ResponseEntity.ok(pageService.updatePage(id, page));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        try {
            pageService.deletePage(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
