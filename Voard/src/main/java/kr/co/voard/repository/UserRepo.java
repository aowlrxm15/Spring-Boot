package kr.co.voard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.voard.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String> {
	public int countUserEntityByUid(String uid);
	public int countUserEntityByNick(String nick);
}
