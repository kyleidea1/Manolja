package hackathon.hackathon.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Reward {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rewardNo;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String content;

    @NonNull
    @Column
    private String coupon;

    @NonNull
    @Column
    private String place;

    @NonNull
    @Column
    private double discount;
}
