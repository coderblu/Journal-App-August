package net.engineeringdigest.journalApp.cache;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    private Map<String, String> appCache;
    @PostConstruct
    public void init()
    {
        List<ConfigJournalAppEntity> all = confi
    }
}
