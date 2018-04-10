package com.controller;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.models.ErrorObject;
import com.models.FileInfo;
import com.models.Hospital;
import com.models.JwtUser;
import com.models.Persons;
import com.models.UserLogin;
import com.models.UserLoginDetails;
import com.models.UserRegist;
import com.models.UserRegistration;
import com.models.UserRegistrationDetails;
import com.models.Users;
import com.security.JwtGenerator;
import com.security.JwtValidator;
import com.service.OtpService;
import com.service.UserService;
import com.util.MailHelper;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@Autowired
	private OtpService otpService;

	/*
	 * @Autowired FileValidator fileValidator;
	 * 
	 * @Autowired MultiFileValidator multiFileValidator;
	 */

	/*
	 * @Autowired ServletContext context;
	 */

	@RequestMapping(value = "/user/auth/token")
	public UserLogin authenticateToken(@RequestBody Users user) {
		UserLogin userLogin = new UserLogin();
		Users userFetch = null;
		try {
			if (StringUtils.isBlank(user.getUsername())
					|| StringUtils.isBlank(user.getPassword()) && StringUtils.isBlank(user.getPin())) {
				LOGGER.info("Username and Password or Pin Required Success=2");
				userLogin.setSuccess(2);
				userLogin.setMsg("Username and Password or Pin Required");
				userLogin.setData(new UserLoginDetails());

			} else {

				userFetch = userService.fetchUser(user.getUsername(), user.getPassword(), user.getPin());

				if (userFetch != null) {
					userLogin.setMsg("Login Successfully");
					userLogin.setSuccess(1);
					JwtUser jwtUser = new JwtUser();
					jwtUser.setUserName(userFetch.getUsername());
					jwtUser.setId(userFetch.getId());
					UserLoginDetails userDetails = new UserLoginDetails();
					userDetails.setId(userFetch.getId());
					userDetails.setEmail(userFetch.getUserEmail());
					userDetails.setAge(userFetch.getPerson().getAge());
					userDetails.setFirstname(userFetch.getPerson().getFirstName());
					// userDetails.setFull_name(userFetch.getPerson().getFullName());
					userDetails.setLastname(userFetch.getPerson().getLastName());
					userDetails.setDob(userFetch.getPerson().getDob());
					userDetails.setGender(userFetch.getPerson().getGender());
					userDetails.setAdharno(userFetch.getPerson().getAdharnumber());
					userDetails.setHeight(userFetch.getPerson().getHeight());
					userDetails.setWeight(userFetch.getPerson().getWeight());
					userDetails.setAddress(userFetch.getPerson().getAddress().getFulladdress());
					userDetails.setPincode(userFetch.getPerson().getAddress().getPostalcode());
					userDetails.setCity(userFetch.getPerson().getAddress().getCity().getName());
					userDetails.setState(userFetch.getPerson().getAddress().getCity().getState().getName());

					userDetails.setUserType(userFetch.getType());
					String token = JwtGenerator.generate(jwtUser);
					userDetails.setToken(token);
					userService.updateToken(userFetch.getId(), token);
					userLogin.setData(userDetails);
				} else {
					LOGGER.info("Invalid Username and Password Success=3");
					userLogin.setSuccess(3);
					userLogin.setMsg("Invalid Username and Password");
					userLogin.setData(new UserLoginDetails());
				}

			}
		} catch (Exception e) {
			LOGGER.error(e);
			LOGGER.info("Invalid Username and Password Success=3");
			userLogin.setSuccess(3);
			userLogin.setMsg("Invalid Username and Password");
			userLogin.setData(new UserLoginDetails());
		}
		return userLogin;
	}

	@CrossOrigin
	@RequestMapping(value = "/user/updateProfile")
	public Object updateProfile(
			@RequestBody Users user/*
									 * ,
									 * 
									 * @RequestParam(name = "file", required =
									 * false) MultipartFile inputFile
									 */) {
		ModelMap model = new ModelMap();
		ErrorObject error = new ErrorObject("Not Found", 404);
		Boolean isValidate = true;
		try {
			/*
			 * if (inputFile != null && !inputFile.isEmpty()) { FileInfo
			 * fileInfo = new FileInfo(); String originalFilename =
			 * inputFile.getOriginalFilename(); File destinationFile = new
			 * File("C:\\Auronia\\upload" + File.separator + originalFilename);
			 * inputFile.transferTo(destinationFile);
			 * fileInfo.setUserId(user.getId());
			 * fileInfo.setFileName(inputFile.getOriginalFilename());
			 * fileInfo.setPath(destinationFile.getPath());
			 * fileInfo.setSize(inputFile.getSize());
			 * userService.getupload(fileInfo);
			 * LOGGER.info("File Update Success Success=4");
			 * 
			 * }
			 */
			if (StringUtils.isBlank(user.getPassword())) {
				error.setMsg("password can not be empty");
				error.setErrorCode(406);
				isValidate = false;
			}
			if (StringUtils.isBlank(user.getPerson().getPhone()) || !StringUtils.isNumeric(user.getPerson().getPhone())
					|| (StringUtils.length(user.getPerson().getPhone()) < 10)) {
				error.setMsg("Phone can not be empty and it must be at least 10 digit numeric value");
				error.setErrorCode(406);
				isValidate = false;
			}
			if (StringUtils.isBlank(user.getPerson().getAdharnumber())
					|| !StringUtils.isNumeric(user.getPerson().getAdharnumber())
					|| (StringUtils.length(user.getPerson().getAdharnumber()) < 12)) {
				error.setMsg("AdharNumber can not be empty and it must be at least 12 digit numeric value");
				error.setErrorCode(406);
				isValidate = false;

			}

			if (!StringUtils.isNumeric(user.getPerson().getWeight())) {
				error.setMsg("Weight Enter in Numeric value");
				error.setErrorCode(406);
				isValidate = false;
			}

			if (!StringUtils.isNumeric(user.getPerson().getHeight())) {
				error.setMsg("Height Enter in Numeric value");
				error.setErrorCode(406);
				isValidate = false;
			}

			if (isValidate == false) {
				return error;
			} else {
				return userService.updateProfile(user);
			}

		} catch (Exception e) {
			LOGGER.error(e);
			model.put("msg", "updation Failed");
		}
		return model;
		// return user;

	}

	@RequestMapping(value = "/user/register")
	public Object registerUser(@RequestBody UserRegistration userRegistration) {
		UserRegist userRegist = new UserRegist();
		ErrorObject error = new ErrorObject("Not Found", 404);
		Boolean isValidate = true;
		if (StringUtils.isBlank(userRegistration.getIspatient())) {
			error.setMsg("isPatient should be either 0 or 1");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getIsdoctor())) {
			error.setMsg("isDoctor should be either 0 or 1");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getPassword())) {
			error.setMsg("password can not be empty");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getFirstname())) {
			error.setMsg("Firstname can not be empty");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getLastname())) {
			error.setMsg("Lastname can not be empty");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getEmail())) {
			error.setMsg("Email can not be empty");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getPhone()) || !StringUtils.isNumeric(userRegistration.getPhone())
				|| (StringUtils.length(userRegistration.getPhone()) < 10)) {
			error.setMsg("Phone can not be empty and it must be at least 10 digit numeric value");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getIsdoctor())) {
			error.setMsg("IsDoctor can not be empty");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (StringUtils.isBlank(userRegistration.getIspatient())) {
			error.setMsg("IsPatient can not be empty");
			error.setErrorCode(406);
			isValidate = false;
		}
		if ("0".equals(userRegistration.getIspatient()) && "0".equals(userRegistration.getIsdoctor())) {
			error.setMsg("IsPatient and isDoctor can not be empty");
			error.setErrorCode(406);
			isValidate = false;
		}
		if (userService.fetchUserByEmail(userRegistration.getEmail()) != null) {
			error.setMsg("User already exists.");
			isValidate = false;
		}

		if (isValidate == false) {
			return error;
			/*
			 * userLogin.setSuccess(error.getErrorCode());
			 * userLogin.setMsg(error.getMsg());
			 */
			// userLogin.setData(new UserLoginDetails());
		} else {
			try {
				Users users = new Users();
				Persons persons = new Persons();
				persons.setFirstName(userRegistration.getFirstname());
				persons.setLastName(userRegistration.getLastname());
				persons.setPhone(userRegistration.getPhone());
				// persons.setHospital(new Hospital(1l));
				users.setPerson(persons);
				users.setPassword(userRegistration.getPassword());
				users.setUsername(userRegistration.getEmail());
				users.setUserEmail(userRegistration.getEmail());
				users.setRecordStatusDate(userRegistration.getRecordStatusDate());

				if (StringUtils.isNotBlank(userRegistration.getRecordStatusFlg())
						&& "Active".equals(userRegistration.getRecordStatusFlg())) {
					users.setType("Active");
				} else if (StringUtils.isNotBlank(userRegistration.getRecordStatusFlg())
						&& "Inactive".equals(userRegistration.getRecordStatusFlg())) {
					users.setType("Inactive");
				}

				if (StringUtils.isNotBlank(userRegistration.getIsdoctor())
						&& "1".equals(userRegistration.getIsdoctor())) {
					users.setType("Doctor");
				} else if (StringUtils.isNotBlank(userRegistration.getIspatient())
						&& "1".equals(userRegistration.getIspatient())) {
					users.setType("Patient");
				}

				Integer userId = userService.userRegistration(users);

				Integer otp = otpService.generateOTP(userRegistration.getEmail());

				boolean mail = MailHelper.sendOtpMail(userRegistration.getEmail(), otp);

				userRegist.setMsg("Registration Successfully");
				userRegist.setSuccess(1);

				UserRegistrationDetails userRegistrationDetails = new UserRegistrationDetails();
				userRegistrationDetails.setId(userId);
				userRegistrationDetails.setEmail(users.getUserEmail());
				userRegistrationDetails
						.setFull_name(userRegistration.getFirstname() + " " + userRegistration.getLastname());

				userRegist.setData(userRegistrationDetails);

			} catch (Exception e) {
				userRegist.setSuccess(2);
				userRegist.setMsg("Invalid Data");
				userRegist.setData(new UserRegistrationDetails());
			}
		}
		return userRegist;
	}

	@RequestMapping(value = "/user/resetPassword")
	public Map<String, Object> resetPassword(@RequestBody Map<String, String> userMap) {
		Map<String, Object> model = new HashMap<String, Object>();

		try {
			return userService.resetPassword(userMap);
		} catch (Exception e) {
			LOGGER.error(e);
			model.put("msg", "updation Failed");
		}
		return model;
		// return user;

	}

	@RequestMapping(value = "/user/token/validate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ModelMap> validateToken(@RequestBody Users user) {
		ModelMap model = new ModelMap();
		JwtValidator validator = new JwtValidator();
		JwtUser jwtUser = validator.validate(user.getToken());
		if (jwtUser == null) {
			model.put("Is UnAuthenticated", "Token Expired");
		} else {
			model.put("Is Authenticated", jwtUser);
		}
		return ResponseEntity.ok().body(model);
	}

	@RequestMapping("/hospital/{id}")
	public Object getHospital(HttpServletRequest request, @PathVariable("id") Long id) {
		Map<String, String> map = verifyToken(request);
		String isVerify = map.get("IsAuthenticated");
		map.put("success", "1");
		if (!"true".equals(isVerify)) {
			return map;
		}
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		Hospital hospital = userService.getHospital(id);
		result.put("success", "1");
		result.put("msg", "Hospital Details");
		result.put("data", hospital);
		return result;
	}

	@RequestMapping("/person/{id}")
	public Object getPerson(HttpServletRequest request, @PathVariable("id") Integer id) {
		Map<String, String> map = verifyToken(request);
		String isVerify = map.get("IsAuthenticated");
		if (!"true".equals(isVerify)) {
			return map;
		}
		Users person = userService.getPerson(id);
		return person;
	}

	@RequestMapping("/user/doctorList")
	public Object getDoctorList(HttpServletRequest request) {

		Map<String, String> map = verifyToken(request);
		String isVerify = map.get("IsAuthenticated");
		if (!"true".equals(isVerify)) {
			return map;
		}

		List<Map> userResult = userService.getDoctorList("Doctor");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", "1");
		result.put("msg", "Doctor List");
		result.put("data", userResult);
		return result;
	}

	@RequestMapping("/user/patientList")
	public Object getPatientList(HttpServletRequest request) {

		Map<String, String> map = verifyToken(request);
		String isVerify = map.get("IsAuthenticated");
		if (!"true".equals(isVerify)) {
			return map;
		}

		List<Map> userResult = userService.getDoctorList("Patient");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", "1");
		result.put("msg", "Patient List");
		result.put("data", userResult);
		return result;
	}

	/*---get all books---
	@RequestMapping("/users")
	public ResponseEntity<List<Users>> list() {
		List<Users> users = userService.list();
		return ResponseEntity.ok().body(users);
	}
	
	---Update a user by id---
	@PutMapping(value = "/user/update/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Users> updateUser(@PathVariable("id") Integer id, @RequestBody Users user) {
		userService.updateUser(id, user);
		return ResponseEntity.ok().body(user);
	}*/

	/*---Delete a user by id---*/
	@RequestMapping("/user/delete/{id}")
	public Map<String, String> delete(HttpServletRequest request, @PathVariable("id") Integer UserId) {

		Map<String, String> map = verifyToken(request);
		String isVerify = map.get("IsAuthenticated");
		if (!"true".equals(isVerify)) {
			return map;
		}

		userService.delete(UserId);
		map = new LinkedHashMap<String, String>();
		map.put("success", "1");
		map.put("msg", "User has been deleted successfully.");
		return map;
	}

	private Map<String, String> verifyToken(HttpServletRequest request) {
		Map<String, String> result = new HashMap<String, String>();
		String token = request.getHeader("token");
		if (StringUtils.isEmpty(token)) {
			result.put("IsAuthenticated", "Token Not Found");
			return result;
		}
		JwtValidator validator = new JwtValidator();
		JwtUser jwtUser = validator.validate(token);
		if (jwtUser == null) {
			result.put("IsAuthenticated", "Token Expired");
		} else {
			result.put("IsAuthenticated", "true");
		}
		return result;
	}

	@RequestMapping(value = "/user/validateOtp")
	public Map<String, String> validateOtp(@RequestBody Map<String, Object> userMap) {
		Map<String, String> result = new HashMap<String, String>();
		String msg = "";
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
		String username = (String) userMap.get("username");
		Integer otp = (Integer) userMap.get("otp");
		if (otp >= 0) {
			int serverOtp = otpService.getOtp(username);
			if (serverOtp > 0) {
				if (otp == serverOtp) {
					otpService.clearOTP(username);
					msg = "Entered Otp is valid";
				} else {
					msg = SUCCESS;
				}
			} else {
				msg = FAIL;
			}
		} else {
			msg = FAIL;
		}
		result.put("msg", msg);
		return result;
	}

	@RequestMapping(value = "/fileupload", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public ResponseEntity<FileInfo> upload(HttpServletRequest request, @RequestParam("file") MultipartFile inputFile) {
		FileInfo fileInfo = new FileInfo();
		// Users user = new Users();
		HttpHeaders headers = new HttpHeaders();
		System.out.println(request.getParameter("userid"));

		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				File destinationFile = new File("C:\\Auronia\\upload" + File.separator + originalFilename);
				inputFile.transferTo(destinationFile);
				// fileInfo.setUserId(user.getId());

				Integer userId = Integer.valueOf(request.getParameter("userid"));
				fileInfo.setUserId(userId);
				fileInfo.setFileName(inputFile.getOriginalFilename());
				fileInfo.setPath(destinationFile.getPath());
				fileInfo.setSize(inputFile.getSize());

				// fileInfo.setFileName(destinationFile.getPath());

				userService.getupload(fileInfo);
				headers.add("File Uploaded Successfully - ", originalFilename);
				return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	}

}