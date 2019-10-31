package codetask.fds.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Race Results")
public class NotFoundException extends RuntimeException {
    public NotFoundException(int start, int finish) {
        super("Could not found RaceResults for : " + start + " / " + finish);
    }
}
