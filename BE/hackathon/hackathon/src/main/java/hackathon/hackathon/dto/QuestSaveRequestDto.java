package hackathon.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QuestSaveRequestDto {
    String name;
    String content;
    int exp;
    String place;
}
