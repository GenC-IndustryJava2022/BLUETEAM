package com.cognizant.academy.blueteam.models;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "This value is already in the database")
public class DuplicateTableEntryException extends DuplicateKeyException {
	public DuplicateTableEntryException(String msg) {
		super(msg);
	}

}
