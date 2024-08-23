package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class journalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;
    @GetMapping()
    public List<JournalEntry> getAll()
    {
    return journalEntryService.getAll();
    }
    @PostMapping()
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry)
    {myEntry.setDate(LocalDateTime.now());
    journalEntryService.saveEntry(myEntry);
    return myEntry;
    }
    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId)
    {
   return journalEntryService.findById(myId).orElse(null);
    }
    @DeleteMapping("/id/{myId}")
    public boolean deleteById(@PathVariable ObjectId myId)
    {
    journalEntryService.deleteById(myId);
        return true;
    }
    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalById (@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry)
    {
        JournalEntry old=  journalEntryService.findById(myId).orElse(null);
        if(old!=null)
        {
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
        }
        journalEntryService.saveEntry(old);
        return old ;
    }
}
