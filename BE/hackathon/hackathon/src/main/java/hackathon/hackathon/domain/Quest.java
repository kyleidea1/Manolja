package hackathon.hackathon.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Quest {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questNo;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String content;

    @NonNull
    @Column
    private int exp;

    @NonNull
    @Column
    private boolean isToday;

    @OneToMany(mappedBy = "place")
    private List<Reward> rewards = new ArrayList<>();
}
