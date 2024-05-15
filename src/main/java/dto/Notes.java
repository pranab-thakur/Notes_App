package dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notes {
	@Id
	private int id;
	private String title;
	private String Description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
   private User user;
}