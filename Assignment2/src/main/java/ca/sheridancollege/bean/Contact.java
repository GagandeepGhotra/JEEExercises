package ca.sheridancollege.bean;

import lombok.*;

@Data
@NoArgsConstructor
public class Contact {
	private String contactName;
	private long contactPhoneNumber;
	private String contactAddress;
	private String contactEmail;
}
