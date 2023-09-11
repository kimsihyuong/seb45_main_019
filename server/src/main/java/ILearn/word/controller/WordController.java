package ILearn.word.controller;

import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.word.dto.WordGetDto;
import ILearn.word.service.WordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/words")
@Slf4j
@Validated
@RequiredArgsConstructor
@EnableSwagger2
@Api(tags = "단어 조회 컨트롤러", description = "단어 조회 관련 작업")
public class WordController {
    private final WordService wordService;

    @GetMapping("/{word_Id}")
    @ApiOperation(value = "단어 조회", notes = "단어 아이디로 단어를 조회")
    public ResponseEntity<ApiResponse<?>> getWord(@PathVariable("word_Id") @Positive Long wordId) {
        try {
            WordGetDto word = wordService.getWords(wordId);
            ApiResponse<WordGetDto> response = new ApiResponse<>(true, "success", word);

            return ResponseEntity.ok(response);

        } catch (ApiResponseException ex) {
            ApiResponse<?> response = ex.getResponse();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
