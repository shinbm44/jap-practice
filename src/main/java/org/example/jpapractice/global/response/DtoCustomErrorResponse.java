package org.example.jpapractice.global.response;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * "Ex)"
 * {
 *
 *     "code": "400",
 *     "message": "잘못된 요청입니다.",
 *     "validation" : {
 *         "title" : "값을 입력해주세요.",
 *     }
 * }
 */
@Getter
@Builder
@RequiredArgsConstructor
public class DtoCustomErrorResponse {

    private final String code;
    private final String message;
    private final Map<String, String> validation = new HashMap<>();

    public void addValidation(String fieldname, String ErrorMessage) {
        this.validation.put(fieldname, ErrorMessage);

    }
}
