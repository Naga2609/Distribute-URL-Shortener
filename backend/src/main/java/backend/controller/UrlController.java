package backend.controller;

import backend.entity.Url;
import backend.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/shorten")
    public Url shortenUrl(@RequestParam String originalUrl) {

        return urlService.shortenUrl(originalUrl);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(
            @PathVariable String shortCode
    ) {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        return ResponseEntity
                .status(302)
                .header(HttpHeaders.LOCATION, originalUrl)
                .build();
    }
}