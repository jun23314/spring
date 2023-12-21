package umc.spring.web.controller;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiLoadResponse.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.service.TempQueryService;
import umc.spring.web.dto.TempResponse.TempExceptionDTO;
import umc.spring.web.dto.TempResponse.TempTestDTO;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempTestDTO> testAPI() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        Logger.getGlobal().setLevel(Level.INFO);

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        //로그 출력 방식 설정
        logger.addHandler(new ConsoleHandler() {
            {
                setOutputStream(System.out);
                setLevel(Level.INFO);
            }
        });

        tempQueryService.CheckFlag(flag);
        Logger.getGlobal().info("실행되면 안되는거 아니냐..");
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}