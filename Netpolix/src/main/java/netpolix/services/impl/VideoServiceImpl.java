package netpolix.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import netpolix.entity.Video;
import netpolix.repository.IVideoRepository;
import netpolix.services.IVideoService;

@Service
public class VideoServiceImpl implements IVideoService{
	
	@Autowired
	private IVideoRepository videoRepository;

	@Override
	public List<Video> listar() {
		return videoRepository.findAll();
	}

	@Override
	public void save(Video video ) {
		videoRepository.save(video);
	}

}
