package netpolix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import netpolix.entity.Video;

@Repository
public interface IVideoRepository extends JpaRepository<Video, Integer>{

}
