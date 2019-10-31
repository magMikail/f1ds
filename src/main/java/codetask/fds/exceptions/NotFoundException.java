package codetask.fds.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not found Race Results")
public class NotFoundException extends RuntimeException {
    public NotFoundException(int start, int finish) {
        super("Could not found Race Results for : " + start + " / " + finish);
    }
}
