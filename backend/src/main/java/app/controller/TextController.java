package app.controller;

import app.entity.Text;
import app.service.TextService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/text")
public class TextController
{
	private TextService textService;
	public TextController(TextService textService)
	{
		this.textService=textService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Text save(@RequestBody Text text)
	{
		return textService.save(text);
	}
	@PutMapping("/{id}")
	public Text update(@RequestBody Text text,@PathVariable Long id)
	{
		text.setId(id);
		return textService.update(text);
	}
	@GetMapping("/{id}")
	public Text findById(@PathVariable Long id)
	{
		return textService.findById(id);
	}
}