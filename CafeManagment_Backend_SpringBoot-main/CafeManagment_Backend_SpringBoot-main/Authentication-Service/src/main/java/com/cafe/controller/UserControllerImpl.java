package com.cafe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.constants.CafeConstants;
import com.cafe.service.UserService;
import com.cafe.utils.CafeUtils;
import com.cafe.wrapper.UserWrapper;

import lombok.extern.slf4j.Slf4j;

//21:27
@RestController
@Slf4j
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;

	/* SignUp */
	public ResponseEntity<String> signUp(Map<String, String> requestMap) { // name : value
		log.info("Enter in SignUp UserControllerImpl {} ", requestMap);

		try {
			return userService.signUp(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/* Login */
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		log.info("Enter in Login UserControllerImpl {} ", requestMap);

		try {
			return userService.login(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/******* Getting Data *********/

	public ResponseEntity<List<UserWrapper>> getAllUser() {
		log.info("Get Mapping Start{}");
		try {
			return userService.getAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Get Mapping End{}");
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			return userService.update(requestMap);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> checkToken() {
		try {
			return userService.checkToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
		log.info("password  {}", requestMap);
		try {

			ResponseEntity<String> password = userService.changePassword(requestMap);

			log.info("New Password {} ", password);
			return password;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<String> forgotPassword(Map<String, String> requestMap) {
		try {
			ResponseEntity<?> otp = userService.forgotPassword(requestMap);
			log.info("New OTP {} ", otp);
			return CafeUtils.getResponseEntity("Check Your Mail For OTP", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
