package hackathon.hackathon.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @NonNull
    @Column(unique = true)
    private String uuid;

    @NonNull
    @Column
    private String nickname;

    @NonNull
    @Column
    private int exp;

    public void increaseExp(int exp) {
        this.exp += exp;
    }
}
