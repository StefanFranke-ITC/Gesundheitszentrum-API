package apis.Manga.API.service;

import apis.Manga.API.entity.Page;
import apis.Manga.API.repository.PageRepository;
import apis.Manga.API.response.PageMetaResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageService {

    private final PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    public List<PageMetaResponse> getAllPageMeta() {
        return pageRepository.findAll()
                .stream()
                .map(page -> new PageMetaResponse(page.getTitle(), page.getUrl()))
                .collect(Collectors.toList());
    }

    public Page getPage(Long id) {
        return pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page nicht gefunden mit ID " + id));
    }

    public Page getPageByUrl(String url) {
        return pageRepository.findByUrl(url)
                .orElseThrow(() -> new RuntimeException("Page nicht gefunden mit URL " + url));
    }

    public Page createPage(Page page) {
        if (pageRepository.existsByUrl(page.getUrl())) {
            throw new RuntimeException("Page mit URL " + page.getUrl() + " existiert bereits");
        }
        return pageRepository.save(page);
    }

    public Page updatePage(Long id, Page pageData) {
        Page existing = pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page nicht gefunden mit ID " + id));

        if (pageData.getUrl() != null && pageRepository.existsByUrlAndIdNot(pageData.getUrl(), id)) {
            throw new IllegalArgumentException("Page mit URL " + pageData.getUrl() + " existiert bereits");
        }

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
