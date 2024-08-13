package hackathon.hackathon.controller;

import hackathon.hackathon.dto.QuestSaveRequestDto;
import hackathon.hackathon.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quest")
public class QuestController {
    private final QuestService questService;

    @Autowired
    QuestController(QuestService questService) {
        this.questService = questService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createQuest(@RequestBody QuestSaveRequestDto questSaveRequestDto) {
        questService.createQuest(questSaveRequestDto);
        return ResponseEntity.ok().build();
    }
}
