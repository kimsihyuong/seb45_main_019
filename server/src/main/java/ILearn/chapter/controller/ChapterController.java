package ILearn.chapter.controller;

import ILearn.chapter.dto.ChapterInfo;
import ILearn.chapter.entity.Chapter;
import ILearn.chapter.response.ChapterResponse;
import ILearn.chapter.service.ChapterService;
import ILearn.global.response.ApiResponse;
import ILearn.global.response.ApiResponseException;
import ILearn.member.dto.MemberResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/learning")
@EnableSwagger2
@Api(tags = "챕터 조회 컨트롤러", description = "챕터 관련 작업")
public class ChapterController {

    private final ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping
    public ResponseEntity<ChapterResponse> getChapters() {
        ChapterResponse response = chapterService.getAllChaptersResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}