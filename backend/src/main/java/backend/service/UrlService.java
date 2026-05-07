package backend.service;

import backend.entity.Url;
import backend.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public Url shortenUrl(String originalUrl) {

        String shortCode = generateShortCode();

        Url url = Url.builder()
                .originalUrl(originalUrl)
                .shortCode(shortCode)
                .clickCount(0L)
                .createdAt(LocalDateTime.now())
                .build();

        return urlRepository.save(url);
    }

    public String getOriginalUrl(String shortCode) {

        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        url.setClickCount(url.getClickCount() + 1);

        urlRepository.save(url);

        return url.getOriginalUrl();
    }

    private String generateShortCode() {

        String characters =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder shortCode = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 6; i++) {

            shortCode.append(
                    characters.charAt(random.nextInt(characters.length()))
            );
        }

        return shortCode.toString();
    }
}