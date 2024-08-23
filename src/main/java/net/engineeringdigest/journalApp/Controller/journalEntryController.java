package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntryController {
    private Map<Long, journalEntry> journalEntries = new HashMap<>();
    @GetMapping()
    public List<journalEntry> getAll()
    {
    return new ArrayList<>(journalEntries.values());
    }
    @PostMapping()
    public boolean createEntry(@RequestBody journalEntry myEntry)
    {
    journalEntries.put(myEntry.getId(),myEntry);
    return true;
    }
    @GetMapping("/id/{myId}")
    public journalEntry getJournalEntryById(@PathVariable Long myId)
    {
    return journalEntries.get(myId);
    }
    @DeleteMapping("/id/{myId}")
    public boolean deleteById(@PathVariable Long myId)
    {
        journalEntries.remove(myId);
        return true;
    }
    @PutMapping("/id/{myId}")
    public journalEntry updateJournalById (@PathVariable Long myId,@RequestBody journalEntry myEntry)
    {
        return journalEntries.put(myId,myEntry);
    }
}
