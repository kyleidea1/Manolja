package hackathon.hackathon.controller;

import hackathon.hackathon.domain.Quest;
import hackathon.hackathon.dto.QuestSaveRequestDto;
import hackathon.hackathon.dto.QuestResponseDto;
import hackathon.hackathon.dto.RewardSaveRequestDto;
import hackathon.hackathon.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestController {
    private final QuestService questService;

    @Autowired
    QuestController(QuestService questService) {
        this.questService = questService;
    }


    @PostMapping("/quest/create")
    public ResponseEntity<?> createQuest(@RequestBody QuestSaveRequestDto questSaveRequestDto) {
        questService.createQuest(questSaveRequestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reward/create")
    public ResponseEntity<?> createReward(@RequestBody RewardSaveRequestDto rewardSaveRequestDto) {
        questService.createReward(rewardSaveRequestDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/quest/today")
    public ResponseEntity<QuestResponseDto> getTodayQuest() {
        return ResponseEntity.ok().body(questService.getTodayQuest());
    }

    @GetMapping("/quest/complete/{uuid}")
    public ResponseEntity<List<QuestResponseDto>> getCompleteQuest(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok().body(questService.getCompleteQuest(uuid));
    }

    @GetMapping("/quest/setComplete/{uuid}")
    public ResponseEntity<?> setCompleteQuest(@PathVariable("uuid") String uuid) {
        questService.setCompleteQuest(uuid);
        return ResponseEntity.ok().build();
    }
}
