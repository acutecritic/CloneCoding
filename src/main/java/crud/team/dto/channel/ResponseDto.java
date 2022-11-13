package crud.team.dto.channel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean success;
    private int code;
    private T data;
    private Error error;

    public static <T> ResponseDto<T> success(int code, T data) {
        return new ResponseDto<>(true, code, data, null);
    }

    public static <T> ResponseDto<T> fail(String code, String message) {
        return new ResponseDto<>(false, new Error(code, message));
    }
}