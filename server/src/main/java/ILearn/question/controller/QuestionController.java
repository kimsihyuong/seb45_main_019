package ILearn.question.controller;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.question.dto.QuestionGetDto;
import ILearn.question.dto.QuestionTypeDto;
import ILearn.question.entity.Question;
import ILearn.question.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Slf4j
@Validated
@RequiredArgsConstructor
@EnableSwagger2
@Api(tags = "문제 컨트롤러", description = "문제 관련 작업")
public class QuestionController {
    private final QuestionService questionService;

    // 문제 생성
    @PostMapping("/generate-questions")
    @ApiOperation(value = "server용 질문 등록", notes = "server만 사용하는 API")
    public ResponseEntity<?> createQuestion(@Valid @RequestBody QuestionTypeDto questionTypeDto) {
        try {
            List<Question> questions = questionService.generateQuestionsByWordId(questionTypeDto);
            ApiResponse<List<Question>> response = new ApiResponse<>(true, "success", questions);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // 질문 단일조회
    @GetMapping("/{questionId}")
    @ApiOperation(value = "질문 등록", notes = "질문 단일 조회")
    @ApiResponses(@io.swagger.annotations.ApiResponse(code = 200, message = "문제 조회 성공", response = Question.class))
    public ResponseEntity<ApiResponse<?>> getMember(@PathVariable @Positive Long questionId) {
        try {
            QuestionGetDto question = questionService.getQuestion(questionId);
            ApiResponse<QuestionGetDto> response = new ApiResponse<>(true, "success", question);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
