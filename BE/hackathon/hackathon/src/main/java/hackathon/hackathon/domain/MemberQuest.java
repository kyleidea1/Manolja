package hackathon.hackathon.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class MemberQuest {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberQuestNo;


    @ManyToOne
    @JoinColumn
    private Member member;

    @ManyToOne
    @JoinColumn
    private Quest quest;

    @NonNull
    @Column
    private LocalDateTime date;

    public MemberQuest(Member member, Quest quest) {
        this.member = member;
        this.quest = quest;
        date = LocalDateTime.now();
    }
}
