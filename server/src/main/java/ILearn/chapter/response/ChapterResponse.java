package ILearn.chapter.response;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.dto.ChapterListDto;
import ILearn.chapter.entity.Chapter;
import ILearn.word.entity.Word;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChapterResponse {

    private boolean status;
    private String msg;
    private ChapterListDto data;

    public ChapterResponse(boolean status, String msg, List<Chapter> chapters) {
        this.status = status;
        this.msg = msg;
        this.data = new ChapterListDto(chapters);
    }
}