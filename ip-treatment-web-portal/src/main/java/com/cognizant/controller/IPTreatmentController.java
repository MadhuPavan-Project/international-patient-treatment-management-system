package com.cognizant.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Admin;
import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.service.AuthFeignService;
import com.cognizant.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IPTreatmentController {

	@Autowired
	AuthFeignService feignService;

	@Autowired
	PortalService portalService;

	/**
	 * return the login page
	 */
	@GetMapping(value = "/")
	public ModelAndView getLoginPage(HttpServletRequest request) {
		log.debug("Start : {}", "Start");
		if (request.getSession().getAttribute("token") == null) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("redirect:/admindashboard");
		}
	}

	/**
	 * perform the Login Operation by Validating the User Credentials
	 */
	@PostMapping("/login")
	public ModelAndView getLogin(@ModelAttribute("user") Admin user, ModelMap modelMap, HttpServletRequest request) {
		Admin admin = null;
		log.info("Start : {}", "Login Page");
		try {
			@SuppressWarnings("unchecked")
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) feignService.getToken(user).getBody();
			admin = new Admin(map.get("userid"), map.get("upassword"), map.get("uname"), map.get("authToken"));

		} catch (Exception e) {

			String invalidLogin = "Invalid Credentials, Please Try Again!!";
			modelMap.put("error1", invalidLogin);

			return new ModelAndView("login", modelMap);

		}
		request.getSession().setAttribute("token", "Bearer " + admin.getAuthToken());
		log.info("End : {}", "login successfull");
		return new ModelAndView("redirect:/admindashboard");
	}

	/**
	 * return the Admin dash board page.
	 */
	@GetMapping("/admindashboard")
	public ModelAndView getDashboard(HttpServletRequest request) {

		String token = (String) request.getSession().getAttribute("token");

		log.info("In the Admin Dashboard");
		if (feignService.validate(token)) {
			return new ModelAndView("AdminDashboard");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	/**
	 * register a Patient based on the Ailment and treatment Package Chosen
	 */
	@PostMapping("/register")
	public ModelAndView getRegister(HttpServletRequest request, @RequestParam("pId") String id,
			@RequestParam("cost") int cost, @RequestParam("pName") String pack, @RequestParam("aName") String ailment) {

		String token = (String) request.getSession().getAttribute("token");
		log.info("To register a patient for the treatment");
		if (feignService.validate(token)) {
			ModelAndView mAV = new ModelAndView("registration");
			mAV.addObject("pack", pack);
			mAV.addObject("ailment", ailment);
			mAV.addObject("cost", cost);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * register a Patient based on the Ailment and treatment Package Chosen and
	 * Create a Treatment Plan
	 */
	@PostMapping("/registerSubmit")
	public ModelAndView registerPatient(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("age") int age, @RequestParam("ailment") String ailment,
			@RequestParam("treatmentPackageName") String pkg, @RequestParam("cost") int cost, ModelMap map) {

		PatientDetail patient = new PatientDetail(0, name, age, ailment, pkg, null);
		String token = (String) request.getSession().getAttribute("token");
		if (feignService.validate(token)) {
			TreatmentPlan treatmentPlan = portalService.registerPatient(patient, token);

			map.put("patient", treatmentPlan);
			log.info("Registration complete");
			return new ModelAndView("particulartreatplan", map);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * return the List of the Patient whose Treatment is going On.
	 */
	@GetMapping("/patients")
	public ModelAndView getPatients(HttpServletRequest request, ModelMap map) {
		log.info("START :: Method :: getPatients() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		log.info("Returning Treatmentplan of all the patients");
		if (feignService.validate(token)) {
			List<TreatmentPlan> treatmentPlanOfPatient = portalService.getTreatmentPlanList(token);
			map.put("patient", treatmentPlanOfPatient);
			return new ModelAndView("patients", map);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * return the List of the Patient whose Treatment is going On And Status can be
	 * changed.
	 */
	@GetMapping("/ongoingTreatments")
	public ModelAndView getTreatmentPlans(HttpServletRequest request, ModelMap map) {

		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		log.info("Return the Details of ongoing treatments");
		if (feignService.validate(token)) {
			List<TreatmentPlan> listOfPatient = portalService.getOnGoingTreatmentPlanList(token);
			map.put("patient", listOfPatient);
			return new ModelAndView("treatplan", map);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * return the List of Specialist Available in the Hospital.
	 */
	@GetMapping("/specialists")
	public ModelAndView getSpecialist(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		log.info("Returning the Specialists Details");
		if (feignService.validate(token)) {
			List<SpecialistDetail> listOfSpecialists = portalService.getSpecialistDetail(token);
			ModelMap model = new ModelMap();
			model.addAttribute("specialists", listOfSpecialists);
			return new ModelAndView("specialists", model);
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	/**
	 * return the List of Treatment Packages Available at the Hospital.
	 */
	@GetMapping("/packages")
	public ModelAndView getPackages(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		log.info("Returning  All Package details");
		if (feignService.validate(token)) {
			List<IPTreatmentPackage> listAllPackages = portalService.getPackageDetail(token);
			ModelMap model = new ModelMap();
			model.addAttribute("packages", listAllPackages);
			return new ModelAndView("packages", model);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * return the list of all packages available in hospital.
	 */
	@GetMapping("/allpackages")
	public ModelAndView getAllPackages(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		log.info("Returning  All Package details");
		if (feignService.validate(token)) {
			List<IPTreatmentPackage> listAllPackages = portalService.getPackageDetail(token);
			ModelMap model = new ModelMap();
			model.addAttribute("packages", listAllPackages);
			return new ModelAndView("allpackages", model);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * 
	 * return the List of Insurance Providers Available in the Hospital.
	 */
	@GetMapping("/insurer")
	public ModelAndView getInsurer(HttpServletRequest request, ModelMap map) {
		String token = (String) request.getSession().getAttribute("token");
		log.info("Returning Insurer Details");
		if (feignService.validate(token)) {
			List<InsurerDetail> listOfInsurer = portalService.getInsurerDetail(token);
			map.addAttribute("insurer", listOfInsurer);
			return new ModelAndView("insurer", map);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * return the List of Insurance Providers Available in the Hospital by package
	 * name.
	 */
	@GetMapping("/insurerByName/{packageName}")
	public ModelAndView getInsurerByPckageName(HttpServletRequest request, @PathVariable String packageName,
			ModelMap map) {
		String token = (String) request.getSession().getAttribute("token");
		log.info("To get  Insurer details by package name");
		if (feignService.validate(token)) {
			InsurerDetail insurerDetailPackageName = portalService.getInsurerDetail(packageName, token);
			map.addAttribute("insurer", insurerDetailPackageName);
			return new ModelAndView("insurer", map);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * return the List of Insurer Available in the Hospital for a Particular
	 * Patient.
	 */
	@GetMapping("/claimInsurance")
	public ModelAndView claimInsurance(@RequestParam("id") int ptId, HttpServletRequest request, ModelMap map) {
		log.info("To claim insurance for the patients");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");

		if (feignService.validate(token)) {

			List<InsurerDetail> listOfInsurers = portalService.claimInsurance(token);
			map.put("ptId", ptId);
			map.put("insurers", listOfInsurers);
			return new ModelAndView("claim", map);
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	/**
	 * return the FInal Amount payable by a patient after the insurance claim is
	 * Settled.
	 */
	@PostMapping("/initiateClaim")
	public ModelAndView initiateClaim(HttpServletRequest request, @RequestParam("ptId") long ptId,
			@RequestParam String pckgName, ModelMap map) {
		String token = (String) request.getSession().getAttribute("token");
		InsurerDetail insurerDetail = portalService.getInsurerDetail(pckgName, token);
		TreatmentPlan treatmentPlan = portalService.getTreatmentDetail(ptId, token);
		InitiateClaim initiateClaim = new InitiateClaim(treatmentPlan.getPtDetail().getName(),
				treatmentPlan.getPtDetail().getAilment(), treatmentPlan.getPackageName(),
				insurerDetail.getInsurerName());

		log.info("To return balance amount to be paid after insurance claim");
		if (feignService.validate(token)) {
			double amt = portalService.initiateClaim(initiateClaim, token);
			if (amt <= 0) {
				amt = 0;
				map.put("amountError", "Your insurance plan covers your treatment cost...");
			}
			portalService.updatePlan(ptId, token);
			double packageAmount = treatmentPlan.getCost();
			double insurerAmount = insurerDetail.getInsuranceAmountLimit();
			map.put("balanceAmount", amt);
			map.put("packageAmount", packageAmount);
			map.put("insurerAmount", insurerAmount);
			map.put("thankyou", "We are here to serve you");
			map.put("greetings", "Thank you!!!");
			return new ModelAndView("final", map);
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	/**
	 * will inValidate the session of the Current User
	 */
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		log.info("Logout");
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}

}
