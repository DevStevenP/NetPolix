package netpolix.services;

import java.util.List;


import netpolix.entity.Video;

public interface IVideoService {

	public List<Video> listar();
	
	public void  save(Video video);

}
