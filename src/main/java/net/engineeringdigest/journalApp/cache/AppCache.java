package net.engineeringdigest.journalApp.cache;

import net.engineeringdigest.journalApp.Entity.ConfigJournalAppEntity;
import net.engineeringdigest.journalApp.Repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    @Autowired
    ConfigJournalAppRepository configJournalAppRepository;
    private Map<String, String> appCache;
    @PostConstruct
    public void init()
    {
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for (ConfigJournalAppEntity entry:all)
        {

        }
    }
}
