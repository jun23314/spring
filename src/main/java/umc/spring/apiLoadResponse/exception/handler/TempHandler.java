package umc.spring.apiLoadResponse.exception.handler;

import umc.spring.apiLoadResponse.code.BaseErrorCode;
import umc.spring.apiLoadResponse.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}