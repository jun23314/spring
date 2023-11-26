package umc.spring.apiLoadResponse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apiLoadResponse.code.BaseErrorCode;
import umc.spring.apiLoadResponse.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
