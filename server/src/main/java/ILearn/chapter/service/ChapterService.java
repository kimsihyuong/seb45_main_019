package ILearn.chapter.service;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.repository.ChapterRepository;
<<<<<<< HEAD
import ILearn.chapter.response.ChapterResponse;
=======
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
>>>>>>> ab68dbe1d20e3e09fc567d9259a06f3ca80240f5
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

    public ChapterInfo getChapterInfoById(Long chapterId) {
        Optional<Chapter> chapterOptional = chapterRepository.findById(chapterId);
        if (chapterOptional.isPresent()) {
            Chapter chapter = chapterOptional.get();
            List<Long> wordIds = chapter.getWords().stream()
                    .map(Word::getWordId)
                    .collect(Collectors.toList());

            return new ChapterInfo(
                    chapter.getTitle(),
                    chapter.getChapterId(),
                    wordIds
            );
        } else {
            throw new ApiResponseException(
                    new ApiResponse<>(false, "Chapter not found"),
                    new RuntimeException("Chapter not found")
            );
        }
    }
}