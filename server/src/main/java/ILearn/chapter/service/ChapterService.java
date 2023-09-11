package ILearn.chapter.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
import ILearn.chapter.response.ChapterResponse;
import ILearn.question.entity.Question;
import ILearn.word.entity.Word;
import ILearn.word.repository.WordRepository;
import ILearn.word.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public ChapterResponse getAllChaptersResponse() {
        List<Chapter> chapters = chapterRepository.findAll();
        return new ChapterResponse(true, "success", chapters);
    }
}