package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;

@Service
public class ImageService {

	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	@Transactional
	public Iterable<Image> findAll() {
		return imageRepository.findAll();
	}
	
	@Transactional
	public Image findById(int id)
	{
		return imageRepository.findById(id).get();
	}
	
	@Transactional
	public List<Image> saveAll(List<Image> images)
	{
		return (List<Image>)imageRepository.saveAll(images);
	}
	
	@Transactional
	public Image save(Image image)
	{
		return imageRepository.save(image);
	}
	
	@Transactional
	public void delete(Image image)
	{
		imageRepository.deleteById(image.getImageId());
	}

}
