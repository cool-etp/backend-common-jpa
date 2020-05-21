package org.cooletp.common.jpa.exception;

import javax.persistence.EntityNotFoundException;

public final class EtpEntityNotFoundException extends EntityNotFoundException {
    public EtpEntityNotFoundException() {
    }

    public EtpEntityNotFoundException(final String message) {
        super(message);
    }
}
