package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Feedback;
import com.example.demo.service.FeedbackService;

@RestController
@RequestMapping("/travel-packages/{travelPackageId}/feedbacks")
public class TravelPackageFeedbackController {
	private FeedbackService feedbackService;

	public TravelPackageFeedbackController(FeedbackService feedbackService) {
		super();
		this.feedbackService = feedbackService;
	}
	
	@GetMapping
	public List<Feedback> getAllFeedbacksByTravelPackageId(@PathVariable("travelPackageId") int travelPackageId)
	{
		return feedbackService.findByTravelPackageId(travelPackageId);
	}
	
	@GetMapping("/{id}")
	public Feedback getFeedbackById(@PathVariable("id") int id)
	{
		return feedbackService.findById(id);
	}
	
	@PutMapping
	public List<Feedback> updateFeedbacksByTravelId(@PathVariable("travelPackageId")int travelPackageId,
			@RequestBody List<Feedback> feedbacks)
	{
		return feedbackService.saveAllByTravelPackageId(feedbacks, travelPackageId);
	}
	
	@PutMapping("/{id}")
	public Feedback updateFeedback(@RequestBody Feedback feedback, @PathVariable("id") int id)
	{
		feedback.setFeedbackId(id);
		return feedbackService.save(feedback);
	}
	
	@PostMapping
	public List<Feedback> createFeedbacksByTravelPackageId(@PathVariable("travelPackageId") int travelPackageId,
			@RequestBody List<Feedback> feedbacks)
	{
		return feedbackService.saveAllByTravelPackageId(feedbacks, travelPackageId);
	}
	
	@DeleteMapping
	public void deleteFeedbacks(@RequestParam("feedbackIdList") List<Integer> feedbackIdList)
	{
		feedbackService.deleteAll(feedbackIdList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFeedback(@PathVariable("id") int id)
	{
		feedbackService.delete(id);
	}
}
