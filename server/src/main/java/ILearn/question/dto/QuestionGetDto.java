package ILearn.question.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.List;

@Getter
@Setter
@ApiModel(description = "질문 정보")
public class QuestionGetDto {
    @ApiModelProperty(value = "문제 ID", example = "1")
    private Long questionId;

    @ApiModelProperty(value = "챕터 넘버", example = "1")
    private Long chapterNum;

    @ApiModelProperty(value = "단어 ID", example = "1")
    private Long wordNum;

    @ApiModelProperty(value = "문제 타입", example = "1")
    private Long questionType;

    @ApiModelProperty(value = "문제", example = "문제 입니다")
    private String question;

    @ApiModelProperty(value = "단어 ID", example = "예제 입니다")
    private String examples;

    @ApiModelProperty(value = "정답", example = "1")
    private String correct;

    @ApiModelProperty(value = "번역", example = "안녕하세요! 오늘 어떻게 지내세요")
    private String translation;
}
