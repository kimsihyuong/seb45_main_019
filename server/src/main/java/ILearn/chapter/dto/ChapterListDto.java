package ILearn.chapter.dto;

import ILearn.chapter.entity.Chapter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChapterListDto {
    private ChapterInfo[] chapterList;

    public ChapterListDto(List<Chapter> chapters) {
        this.chapterList = chapters.stream().map(ChapterInfo::new).toArray(ChapterInfo[]::new);
    }
}