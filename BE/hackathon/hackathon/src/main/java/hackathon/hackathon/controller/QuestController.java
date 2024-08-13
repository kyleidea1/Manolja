package hackathon.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/quest")
public class QuestController {
    private final QuestService questService;

    @Autowired
    QuestController(QuestService questService) {
        this.questService = questService;
    }


    @GetMapping
    public RequestEntity<Member> findMember() {

    }
}
