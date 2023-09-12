package ILearn.chapter.controller;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.response.ChapterResponse;
import ILearn.chapter.service.ChapterService;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.dto.MemberResponseDto;
<<<<<<< HEAD
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
=======
import ILearn.question.dto.QuestionGetDto;
import ILearn.question.entity.Question;
import ILearn.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
>>>>>>> ab68dbe1d20e3e09fc567d9259a06f3ca80240f5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/learning")
<<<<<<< HEAD
@EnableSwagger2
@Api(tags = "챕터 조회 컨트롤러", description = "챕터 관련 작업")
public class ChapterController {

    private final ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }
=======
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;
    private final QuestionService questionService;
>>>>>>> ab68dbe1d20e3e09fc567d9259a06f3ca80240f5

    @GetMapping
    @ApiOperation(value = "챕터 전체 조회", notes = "챕터와 챕터에 포함된 wordId 함께 조회")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "챕터 목록 조회 성공", response = ChapterInfo.class)})
    public ResponseEntity<ChapterResponse> getChapters() {
        ChapterResponse response = chapterService.getAllChaptersResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/{chapterNum}/{questionId}")
//    public ResponseEntity<?> getQuestion(@PathVariable("chapterNum") @Positive Long chapterNum, @PathVariable("questionId") @Positive Long questionId) {
//        try {
//            QuestionGetDto question = questionService.getQuestion(questionId);
//            ApiResponse<QuestionGetDto> response = new ApiResponse<>(true, "success", question);
//
//            return ResponseEntity.ok(response);
//        } catch (ApiResponseException ex) {
//            ApiResponse<?> response = ex.getResponse();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//    }
}