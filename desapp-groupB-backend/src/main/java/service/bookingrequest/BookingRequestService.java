package service.bookingrequest;

import org.springframework.transaction.annotation.Transactional;

import model.booking.BookingRequest;
import model.exceptions.NoAceptedException;
import model.exceptions.RequestNoExistException;
import model.user.User;
import persistence.generic.GenericService;
import service.publication.PublicationService;
import service.user.UserService;

public class BookingRequestService extends GenericService<BookingRequest> {

	private static final long serialVersionUID = -2932116622242535843L;

	public BookingRequest searchById(Long id) {
		return this.getRepository().findById(id);
	}

	public void updateById(Long id, BookingRequest updatedPublication) {
		updatedPublication.setId(id);
		this.getRepository().update(updatedPublication);
	}
	
	@Transactional
	public void aceptRequest(Long userId, Long requestId, UserService userService, PublicationService publicationService)  {
		BookingRequest request = this.searchById(requestId);
		User user = userService.searchById(userId);
		user.setMyPublications(
				publicationService.selectByFunction((publication) -> publication.getUser().getId() == userId));
		request.acept();
		try {
			user.aceptRequest(request);}
		catch (RequestNoExistException e) {}
		
		this.updateById(requestId, request);
	}

	@Transactional
	public void rejectRequest(Long userId, Long requestId, UserService userService, PublicationService publicationService) {
		BookingRequest request = this.searchById(requestId);
		User user = userService.searchById(userId);
		user.rejectRequest(request);
		
		this.updateById(requestId, request);
	}

	@Transactional
	public void initBySeller(Long userId, Long requestId, UserService userService,PublicationService publicationService) {
		BookingRequest request = this.searchById(requestId);
		User user = userService.searchById(userId);
		user.setMyPublications(
				publicationService.selectByFunction((publication) -> publication.getUser().getId() == userId));
		
		try {
			user.confirmVehicleRetreatBuyer(request);
		} catch (NoAceptedException e) {}
		
		System.out.println("______________________________");
		System.out.println(request.getStatus().getConfirmRetreatBuyer());
		System.out.println(request.getStatus().getConfirmRetreatSeller());
		System.out.println(request.getStatus().getConfirmReturnBuyer());
		System.out.println(request.getStatus().getConfirmReturnSeller()); 
		
		this.updateById(requestId, request);
		
	}
	@Transactional
	public void finishBySeller(Long userId, Long requestId, UserService userService, PublicationService publicationService) {
		BookingRequest request = this.searchById(requestId);
		User user = userService.searchById(userId);
		user.setMyPublications(
				publicationService.selectByFunction((publication) -> publication.getUser().getId() == userId));
		
		this.updateById(requestId, request);
	}
		
	
}
