package hackathon.hackathon.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RewardSaveRequestDto {
    String name;
    String content;
    String coupon;
    String place;
}
