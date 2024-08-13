package hackathon.hackathon.controller;

import hackathon.hackathon.dto.MemberSaveRequestDto;
import hackathon.hackathon.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/init")
    public ResponseEntity<?> saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        try {
            memberService.saveMember(memberSaveRequestDto);
        } catch(IllegalAccessException ex) {
            return ResponseEntity.status(202)
                    .body(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
