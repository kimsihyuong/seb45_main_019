package ILearn.chapter.dto;

import ILearn.chapter.entity.Chapter;
import ILearn.word.entity.Word;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ApiModel(description = "챕터 정보")
public class ChapterInfo {
    @ApiModelProperty(value = "학습 제목", example = "인사와 소통")
    private String title;
    @ApiModelProperty(value = "챕터 ID", example = "1")
    private Long chapterId;
    @ApiModelProperty(value = "단어 ID 목록", example = "[1, 2, 3]")
    private Long[] wordId;


    public ChapterInfo(Chapter chapter) {
        this.title = chapter.getTitle();
        this.chapterId = chapter.getChapterId();
        List<Long> wordIdList = chapter.getWords().stream().map(Word::getWordId).collect(Collectors.toList());
        this.wordId = wordIdList.toArray(new Long[0]);
    }
}
