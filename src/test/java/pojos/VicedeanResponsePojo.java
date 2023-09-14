package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class VicedeanResponsePojo implements Serializable {
	private String httpStatus;
	private String message;
	private VicedeanObjectPojo object;

	public VicedeanResponsePojo() {
	}

	public VicedeanResponsePojo(String httpStatus, String message, VicedeanObjectPojo object) {
		this.httpStatus = httpStatus;
		this.message = message;
		this.object = object;
	}

	public void setHttpStatus(String httpStatus){
		this.httpStatus = httpStatus;
	}

	public String getHttpStatus(){
		return httpStatus;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setObject(VicedeanObjectPojo object){
		this.object = object;
	}

	public VicedeanObjectPojo getObject(){
		return object;
	}

	@Override
 	public String toString(){
		return 
			"VicedeanResponsePojo{" + 
			"httpStatus = '" + httpStatus + '\'' + 
			",message = '" + message + '\'' + 
			",object = '" + object + '\'' + 
			"}";
		}
}