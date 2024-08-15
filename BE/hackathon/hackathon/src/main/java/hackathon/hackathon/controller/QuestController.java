package hackathon.hackathon.controller;

import hackathon.hackathon.dto.QuestSaveRequestDto;
import hackathon.hackathon.dto.QuestResponseDto;
import hackathon.hackathon.dto.RewardSaveRequestDto;
import hackathon.hackathon.dto.RewardSelectResponseDto;
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


    @GetMapping("/quest/today")
    public ResponseEntity<QuestResponseDto> getTodayQuest() {
        return ResponseEntity.ok().body(questService.getTodayQuest());
    }
    @GetMapping("/quest/coupon/{uuid}")
    public ResponseEntity<?> getMemberCoupon(@PathVariable("uuid") String uuid) {
        RewardSelectResponseDto rewardSelectResponseDto = null;
        try {
            rewardSelectResponseDto = questService.getMemberCoupon(uuid);
        } catch (IllegalAccessException ex) {
            ResponseEntity.status(404).body(ex.getMessage());
        }
        return ResponseEntity.ok().body(rewardSelectResponseDto);
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



    /**
     * reward
     */


    @PostMapping("/reward/create")
    public ResponseEntity<?> createReward(@RequestBody RewardSaveRequestDto rewardSaveRequestDto) {
        questService.createReward(rewardSaveRequestDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/reward/show/{uuid}")
    public ResponseEntity<?> showSelectReward(@PathVariable("uuid") String uuid) {
        List<RewardSelectResponseDto> list = null;
        try {
            list = questService.showSelectReward(uuid);
        } catch(IllegalAccessException ex) {
            return ResponseEntity.status(401)
                    .body(ex.getMessage());
        }
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/reward/select/{rewardNo}/{uuid}")
    public ResponseEntity<?> selectReward(@PathVariable("rewardNo") long rewardNo, @PathVariable("uuid") String uuid) {
        questService.selectReward(rewardNo, uuid);
        return ResponseEntity.ok().build();
    }
}
