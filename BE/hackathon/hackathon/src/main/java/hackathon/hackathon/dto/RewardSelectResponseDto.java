package hackathon.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RewardSelectResponseDto {
    String name;
    String content;
    String coupon;
    String place;
    double discount;
}
