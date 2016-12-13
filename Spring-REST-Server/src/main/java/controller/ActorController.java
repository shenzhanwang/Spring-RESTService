package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import po.Actor;
import service.ActorService;

@Controller
public class ActorController {
	@Autowired
	private ActorService actorservice;
	
	@RequestMapping(value="/actors",method = RequestMethod.GET)
	@ResponseBody
	public List<Actor> getactorlist(){
		List<Actor> list=actorservice.getActors();
		return  list;
	}
	
	@RequestMapping(value="/actors/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public Actor updateactor(@PathVariable("id") int id,@RequestParam("name2") String name,@RequestParam("age2") int age){
		Actor a=new Actor();
		a.setId(id);
		a.setName(name);
		a.setAge(age);
		actorservice.UpdateActor(a);
		return a;
	}
	
	@RequestMapping(value="/actors/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Actor getactorbyid(@PathVariable("id") int id){
		Actor a=actorservice.getActorByid(id);
		return a;
	}
	
	@RequestMapping(value="/actors",method = RequestMethod.POST)
	@ResponseBody
	public Actor add(@RequestParam("name") String name,@RequestParam("age") int age){
			Actor a=new Actor();
			a.setName(name);
			a.setAge(age);
			actorservice.SaveActor(a);
			return a;//a即为被保存好的对象，直接返回已经拥有新主键
	}
	
	@RequestMapping(value="/actors/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") int id){
		actorservice.Delete(id);
		return "";
	}
	
	@RequestMapping(value="rest",method = RequestMethod.GET)
	public String rest(){
		return "rest";
	}
	
	
}
