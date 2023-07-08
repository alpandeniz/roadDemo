package myProject.roadDemo.user.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequest {
	@NotNull
	@NotBlank
	private String name;

	private Integer journeyId;

	private Integer modelId;
}
