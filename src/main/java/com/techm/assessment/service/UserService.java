package com.techm.assessment.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.assessment.dao.UserRepository;
import com.techm.assessment.model.User;

@Service
public class UserService {


	@Autowired
	UserRepository repo;

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<User> getUser(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public User saveUser(User User) {
		User u=new User();
		BeanUtils.copyProperties(User, u);
		u.setActive(true);
		u.setCreatedBy("Dileep");
		u.setCreatedDate(new Date());
		return repo.save(u);
	}

	public User updatedUser(User newUser, Long id) {
		return repo.findById(id).map(User -> {
			User.setId(id);
			User.setFirstName(newUser.getListName());
			User.setListName(newUser.getListName());
			User.setContact(newUser.getContact());
			User.setHouseNo(newUser.getHouseNo());
			User.setStreet(newUser.getStreet());
			User.setState(newUser.getState());
			User.setPin(newUser.getPin());
			User.setLastUpdatedBy("Dileep");
			User.setModifiedDate(new Date());
			return repo.save(User);
		}).orElseGet(() -> {
			return repo.save(newUser);
		});
	}

	public void deleteUser(Long id) {
		// TODO Auto-generated method stub

		repo.deleteById(id);
	}
}
