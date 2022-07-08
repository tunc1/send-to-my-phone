package app.service;

import org.springframework.stereotype.Service;
import app.entity.Text;
import app.repository.TextRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class TextService
{
	private TextRepository textRepository;
	public TextService(TextRepository textRepository)
	{
		this.textRepository=textRepository;
	}
	public Text save(Text text)
	{
		return textRepository.save(text);
	}
	public Text update(Text text)
	{
		return textRepository.save(text);
	}
	public Text findById(Long id)
	{
		return textRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}