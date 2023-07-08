package myProject.roadDemo.dto.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreateModelRequest {
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	private int brandId;
	


	private double horsepower;
	
	private double displacement;
	

	
}
