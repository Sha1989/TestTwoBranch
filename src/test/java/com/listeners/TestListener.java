package com.listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.main.utilty.JiraPolicy;
import com.main.utilty.JiraServiceProvider;


public class TestListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
	 JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		
		if(isTicketReady) {
			
			// rasise jira ticket:
			System.out.println("is ticket ready for Jira :- " + isTicketReady);
			
			JiraServiceProvider jirasp = new JiraServiceProvider("https://19a.atlassian.net/", "shashank1989bansal@gmail.com", "KkbzbnQupWgORrjUMZr75C8D", "TES");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + " got failed give to some assertion or exception";
			String issueDescription = result.getThrowable().getMessage() + "\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			
			jirasp.createJiraTicket("Bug", issueSummary, issueDescription, "Shashank");
		} 
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
