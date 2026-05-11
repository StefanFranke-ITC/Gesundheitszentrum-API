package apis.Manga.API.service;

import apis.Manga.API.entity.Page;
import apis.Manga.API.repository.PageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    private final PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    public Page getPage(Long id) {
        return pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page nicht gefunden mit ID " + id));
    }

    public Page createPage(Page page) {
        return pageRepository.save(page);
    }

    public Page updatePage(Long id, Page pageData) {
        Page existing = pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page nicht gefunden mit ID " + id));

        existing.setContent(pageData.getContent());
        existing.setTitle(pageData.getTitle());
        existing.setUrl(pageData.getUrl());

        return pageRepository.save(existing);
    }

    public void deletePage(Long id) {
        Page existing = pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page nicht gefunden mit ID " + id));
        pageRepository.delete(existing);
    }
}
