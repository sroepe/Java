package com.sararoepe.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	
	public String getDate() {
		Date timestamp = new Date();
		SimpleDateFormat fmtDate = new SimpleDateFormat("MMMM dd, yyyy - hh:mm a");
		String strTimestamp = fmtDate.format(timestamp);
		return strTimestamp;
	}
	
	@RequestMapping("/")
	public String indexRed() {
		
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String gold(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			//session.setAttribute(new ArrayList<String>();
		}
		
		if(session.getAttribute("activityLog") == null) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activityLog", activities);
		}
		int totalGold = ((int) session.getAttribute("gold"));
		model.addAttribute("gold", totalGold);
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = ((ArrayList<String>) session.getAttribute("activityLog"));
		model.addAttribute("activityLog", activities);
		return "gold";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/findgold", method=RequestMethod.POST)
	public String findGold(HttpSession session, @RequestParam(value = "bldg") String bldg, Model model) {
		ArrayList<String> activityLog = new ArrayList<String>();
		activityLog = ((ArrayList<String>) session.getAttribute("activityLog"));
		Random amt = new Random();
		int gold = 0;
		int totalGold = (int) session.getAttribute("gold");
		
		if(bldg.equals("farm")) {
			gold = (amt.nextInt(20 - 10) +1) +10;
			totalGold += gold;
			session.setAttribute("gold", totalGold);			
		} else if(bldg.equals("cave")){
			gold = (amt.nextInt(10 - 5) +1) +5;
			totalGold += gold;
			session.setAttribute("gold", totalGold);
		} else if(bldg.equals("house")){
			gold = (amt.nextInt(5 - 2) +1) +2;
			totalGold += gold;
			session.setAttribute("gold", totalGold);
		} else if(bldg.equals("casino")){
			gold = (amt.nextInt(50 - -50) +1) -50;
			totalGold += gold;
			session.setAttribute("gold", totalGold);
		}
		String timeAdded = getDate();
		
		if(gold < 0) {
			activityLog.add("You entered a casino and lost " + gold + " gold!" + " ( " + timeAdded + " )");
			session.setAttribute("gold", totalGold);
		} else {
		activityLog.add("You entered a " + bldg + " and earned " + gold + " gold!" + " ( " + timeAdded + " )");
		session.setAttribute("gold", totalGold);
		}
		
		Collections.reverse(activityLog);
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/gold";
	}
	
	//from demo with Tim
	//public void updateStuff(int min, int max, HttpSession session){
	//Random r = new Random();
	//int gold = r.nextInt(max - min) + min;
	//session.setAttribute("goldCount", (int) session.getAttribute("goldCount") + gold);
	
	

}
